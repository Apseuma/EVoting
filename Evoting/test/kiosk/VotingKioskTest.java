package kiosk;

import data.DigitalSignature;
import data.MailAddress;
import data.Nif;
import data.Party;
import org.junit.jupiter.api.BeforeAll;
import services.ElectoralOrganismImplementation;
import services.MailerServiceImplementation;


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
            throw new NoAvailableEOException();
        }

        @Override
        public void disableVoter(Nif nif){
            throw new NoAvailableEOException();
        }

        @Override
        public DigitalSignature askForDigitalSignature(Party party) {
            throw new NoAvailableEOException();
        }
    }

    private static abstract class NoAvailableSignature extends ValidVoter{
        @Override
        DigitalSignature askForDigitalSignature(Party party)throws NoAvailableEOException, NoAvailableSignatureException{
            throw new NoAvailableSignatureException();
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
