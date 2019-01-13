package kiosk;

import Exceptions.NoAvailableEOException;
import Exceptions.NoAvailableMailerServiceException;
import Exceptions.NoAvailableSignatureException;
import Exceptions.NullReceivedAsParameterException;
import data.DigitalSignature;
import data.MailAddress;
import data.Nif;
import data.Party;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.ElectoralOrganism;
import services.ElectoralOrganismImplementation;
import services.MailerService;
import services.MailerServiceImplementation;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class VotingKioskTest {

    private static class NotValidVoterEO extends ElectoralOrganismImplementation {
        @Override
        public boolean canVote(Nif nif) {
            return false;
        }
    }

    private static class ValidVoterEO extends ElectoralOrganismImplementation{
        @Override
        public boolean canVote (Nif nif){
            return true;
        }
    }

    private static class NoAvailableEO extends ElectoralOrganismImplementation{
        @Override
        public boolean canVote(Nif nif) throws NoAvailableEOException {
            throw new NoAvailableEOException("Organisme electoral no disponible");
        }

        @Override
        public void disableVoter(Nif nif) throws NoAvailableEOException {
            throw new NoAvailableEOException("Organisme electoral no disponible");
        }

        @Override
        public DigitalSignature askForDigitalSignature(Party party) throws NoAvailableEOException {
            throw new NoAvailableEOException("Organisme electoral no disponible");
        }
    }

    private static class NoAvailableSignature extends ValidVoterEO{
        @Override
        public DigitalSignature askForDigitalSignature(Party party) throws Exception {
            throw new NoAvailableSignatureException("Signatura digital no disponible");
        }

    }

    private static class NoAvailableMailerService extends MailerServiceImplementation {
        @Override
        public void send(MailAddress address, DigitalSignature signature) throws NoAvailableMailerServiceException {
            throw new NoAvailableMailerServiceException("Servidor de correu no disponible");
        }


    }

    VotingKiosk kiosk;

    @BeforeEach
    public void setUp() throws NullReceivedAsParameterException {
        kiosk=new VotingKiosk();
        HashSet<Party> votables = new HashSet<>(Arrays.asList(new Party("PP"), new Party("PSOE"),
                new Party("Podemos"), new Party("Cs"), new Party("ERC")));

        kiosk.setVoteCounter(new VoteCounter(votables));
        kiosk.setCurrentVoter(new Nif("48054733E"));
    }

    /* En aquest Test es comprova que s'intenta votar però el votant no és vàlid, i es finalitza la sessió de vot */
    @Test
    void NoValidUserTest() throws NullReceivedAsParameterException, NoAvailableEOException {
        ElectoralOrganism eo = new NotValidVoterEO();
        MailerService mail = new MailerServiceImplementation();

        kiosk.setElectoralOrganism(eo);
        kiosk.setMailerService(mail);

        kiosk.vote(new Party("ERC"));

        assertEquals(0,kiosk.voteCounter.getTotal());
        assertEquals(0,kiosk.voteCounter.getVotesFor(new Party("ERC")));

      //  kiosk.electoralOrganism.disableVoterExecuted;


    }

    @Test
    void NotAvailableEOTest() throws NullReceivedAsParameterException, NoAvailableEOException {
        ElectoralOrganism eo = new NoAvailableEO();
        MailerService mail = new MailerServiceImplementation();

        kiosk.setElectoralOrganism(eo);
        kiosk.setMailerService(mail);

        assertThrows(NoAvailableEOException.class,
                ()->{
         //           kiosk.vote(new Party("whatever"));
                    kiosk.electoralOrganism.canVote(new Nif ("fghjkghjk"));
                });





    }


}
