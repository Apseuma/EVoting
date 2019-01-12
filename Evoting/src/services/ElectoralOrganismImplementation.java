/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Exceptions.NoAvailableEOException;
import data.DigitalSignature;
import data.Nif;
import data.Party;

/**
 *
 * @author Albert Planes
 */
public class ElectoralOrganismImplementation implements ElectoralOrganism{

    public boolean abledVoter = true;
    
    @Override
    public boolean canVote(Nif nif) throws NoAvailableEOException {
        throw new UnsupportedOperationException();
    }

    private boolean disableVoterExecuted=false;

    @Override
    public void disableVoter(Nif nif){
        disableVoterExecuted=true;
    }

    @Override
    public DigitalSignature askForDigitalSignature(Party party) throws Exception {
        throw new UnsupportedOperationException();
    }
}
