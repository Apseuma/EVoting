/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

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
    public boolean canVote(Nif nif) {
        return true;
    }

    @Override
    public void disableVoter(Nif nif) {
       abledVoter = false;
    }

    @Override
    public DigitalSignature askForDigitalSignature(Party party) {
        return new DigitalSignature(String.format("This voter has voted: %s", party.getName()));
    }
}
