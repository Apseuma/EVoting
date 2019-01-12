/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Exceptions.NoAvailableEOException;
import Exceptions.NoAvailableSignatureException;
import data.DigitalSignature;
import data.Nif;
import data.Party;

/**
 *
 * @author Albert Planes
 */
public interface ElectoralOrganism {
    boolean canVote(Nif nif) throws NoAvailableEOException;
    void disableVoter(Nif nif)throws NoAvailableEOException;
    DigitalSignature askForDigitalSignature(Party party)throws NoAvailableEOException, NoAvailableSignatureException, Exception;
}
