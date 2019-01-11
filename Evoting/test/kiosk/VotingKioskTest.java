package kiosk;

import data.Nif;
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





}
