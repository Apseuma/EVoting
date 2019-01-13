/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiosk;

import Exceptions.NoAvailableEOException;
import Exceptions.NullReceivedAsParameterException;
import data.DigitalSignature;
import data.MailAddress;
import data.Nif;
import data.Party;
import services.ElectoralOrganismImplementation;
import services.MailerServiceImplementation;

/**
 *
 * @author Albert Planes
 */
public class VotingKiosk {
    
    ElectoralOrganismImplementation electoralOrganism;
    MailerServiceImplementation mailerService;
    VoteCounter voteCounter;

    public Party currentParty; // Això s'eliminaria al finalitzar la sessió de vot
    private Nif currentVoter;
    private boolean canVote; // sempre s'inicialitza abans d'utilitzar-se

    public VotingKiosk() { }

    public void setCurrentVoter(Nif nif){currentVoter=nif; }
    public Nif getCurrentVoter(){return currentVoter; }

    public void setElectoralOrganism(ElectoralOrganismImplementation eO) { electoralOrganism = eO; }
    public void setVoteCounter(VoteCounter vC){voteCounter=vC; }
    public void setMailerService(MailerServiceImplementation mService){
        mailerService = mService;
    }


    public void vote(Party party) throws NoAvailableEOException, NullReceivedAsParameterException {
        if (electoralOrganism.canVote(currentVoter)){
            voteCounter.scrutinize(party);
            currentParty = party;
            electoralOrganism.disableVoter(currentVoter);
        } else{
            endSession();
        }
    }
 
    public void sendeReceipt(MailAddress address) throws Exception {
        DigitalSignature signature = electoralOrganism.askForDigitalSignature(currentParty);
        mailerService.send(address, signature);
        endSession();
    }

    public void endSession() {
        currentParty = null;
        currentVoter = null;

    }
}