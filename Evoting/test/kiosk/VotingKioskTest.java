package kiosk;

import Exceptions.NoAvailableEOException;
import Exceptions.NoAvailableMailerServiceException;
import Exceptions.NoAvailableSignatureException;
import data.DigitalSignature;
import data.Nif;
import data.Party;
import org.junit.jupiter.api.BeforeAll;
import services.ElectoralOrganismImplementation;


public class VotingKioskTest {

    private static abstract class NotValidVoter extends ElectoralOrganismImplementation {
        @Override
        public boolean canVote(Nif nif) {
            return false;
        }
    }

    private static abstract class ValidVoter extends ElectoralOrganismImplementation{
        @Override
        public boolean canVote (Nif nif){
            return true;
        }
    }

    private static abstract class NoAvailableEO extends ElectoralOrganismImplementation{
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

    private static abstract class NoAvailableSignature extends ValidVoter{
        @Override
        public DigitalSignature askForDigitalSignature(Party party) throws Exception {
            throw new NoAvailableSignatureException("Signatura digital no disponible");
        }

    }

    private static class NoAvailableMailerService extends MailerServiceImplementation{
        @Override
        public void send(MailAddress address, DigitalSignature signature) {
            throw new NoAvailableMailerServiceException();
        }


    }


    @BeforeAll
    public void setup(){
         VotingKiosk kiosk=new VotingKiosk();
    }

}
