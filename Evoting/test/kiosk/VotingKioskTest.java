package kiosk;

import Exceptions.*;
import data.DigitalSignature;
import data.MailAddress;
import data.Nif;
import data.Party;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.ElectoralOrganismImplementation;
import services.MailerService;
import services.MailerServiceImplementation;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;


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
 /*       public boolean disableVoterExecuted;
        @Override
        public void disableVoter(Nif nif) throws NoAvailableEOException {
            disableVoterExecuted=true;
        }
*/
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

    @Test
    void NoValidUserTest() throws NullReceivedAsParameterException, NoAvailableEOException, NotExistingPartyException {
        ElectoralOrganismImplementation eo = new NotValidVoterEO();
        MailerService mail = new MailerServiceImplementation();

        kiosk.setElectoralOrganism(eo);
        kiosk.setMailerService(mail);

        kiosk.vote(new Party("ERC"));

        assertEquals(0,kiosk.voteCounter.getTotal());
        assertEquals(0,kiosk.voteCounter.getVotesFor(new Party("ERC")));

    }

    @Test
    void DisableVoterAfterTest() throws NullReceivedAsParameterException, NoAvailableEOException {
        ElectoralOrganismImplementation eo = new ValidVoterEO();
        MailerService mail = new MailerServiceImplementation();

        kiosk.setElectoralOrganism(eo);
        kiosk.setMailerService(mail);

        kiosk.vote(new Party("PSOE"));

        assertTrue(((ValidVoterEO) eo).disableVoterExecuted);  //corregir
        assertTrue(kiosk.electoralOrganism.disableVoterExecuted);

    }

    @Test
    void ValidUserVotesUnacceptedPartyTest() throws NullReceivedAsParameterException, NoAvailableEOException {
        ElectoralOrganismImplementation eo = new ValidVoterEO();
        MailerService mail = new MailerServiceImplementation();

        kiosk.setElectoralOrganism(eo);
        kiosk.setMailerService(mail);

        kiosk.vote(new Party("partit inventat"));

        assertEquals(1,kiosk.voteCounter.getTotal());
        assertEquals(1,kiosk.voteCounter.getNulls());

    }

    @Test
    void validUserVotesAcceptedPartyTest() throws NullReceivedAsParameterException, NoAvailableEOException, NotExistingPartyException {
        ElectoralOrganismImplementation eo = new ValidVoterEO();
        MailerService mail = new MailerServiceImplementation();

        kiosk.setElectoralOrganism(eo);
        kiosk.setMailerService(mail);

        kiosk.vote(new Party("PP"));

        assertEquals(1,kiosk.voteCounter.getTotal());
        assertEquals(1,kiosk.voteCounter.getVotesFor(new Party("PP")));
    }

    @Test
    void NotAvailableEOVotingTest() throws NullReceivedAsParameterException, NoAvailableEOException {
        ElectoralOrganismImplementation eo = new NoAvailableEO();
        MailerService mail = new MailerServiceImplementation();

        kiosk.setElectoralOrganism(eo);
        kiosk.setMailerService(mail);

        assertThrows(NoAvailableEOException.class,
                ()->{
                    kiosk.vote(new Party("PP"));
                });

        assertThrows(NoAvailableEOException.class,
                ()->{
                    kiosk.vote(new Party("inventat"));
                });

    }

    @Test
    void notAvailableDigitalSignatureSendeReceipt() throws NullReceivedAsParameterException, NoAvailableEOException {
        MailerService mS = new MailerServiceImplementation();
        ElectoralOrganismImplementation eo= new NoAvailableSignature();

        kiosk.setMailerService(mS);
        kiosk.setElectoralOrganism(eo);

        kiosk.vote(new Party("Podemos"));

        assertThrows(NoAvailableSignatureException.class,
                ()->{
                    kiosk.sendeReceipt(new MailAddress("abc@gmail.com"));
                });
    }

    @Test
    void notAvailableMailerServiceSendeReceiptTest()  throws NullReceivedAsParameterException, NoAvailableEOException {
        MailerService mS = new NoAvailableMailerService();
        ElectoralOrganismImplementation eo= new ValidVoterEO();

        kiosk.setMailerService(mS);
        kiosk.setElectoralOrganism(eo);

        kiosk.vote(new Party("Cs"));

        assertThrows(NoAvailableMailerServiceException.class,
                ()->{
                    kiosk.sendeReceipt(new MailAddress("abc@gmail.com"));
                });
    }

}
