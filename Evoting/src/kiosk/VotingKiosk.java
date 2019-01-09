/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiosk;

import data.DigitalSignature;
import data.MailAddress;
import data.Party;
import services.ElectoralOrganism;
import services.ElectoralOrganismImplementation;
import services.MailerService;
import services.MailerServiceImplementation;

/**
 *
 * @author Albert Planes
 */
public class VotingKiosk {
    
    ElectoralOrganism electoralOrganism = new ElectoralOrganismImplementation();
    MailerService mailerService = new MailerServiceImplementation();
    
    VoteCounter voteCounter;
    Party currentParty;
    
    public VotingKiosk(VoteCounter vC) { 
        voteCounter = vC;
    }
 
    public void setElectoralOrganism(ElectoralOrganism eO) { 
        electoralOrganism = eO;
    }
 
    public void setMailerService(MailerService mService){ 
        mailerService = mService;
    }
    
    public void vote(Party party) {
        voteCounter.scrutinize(party);
        currentParty = party;
    }
 
    public void sendeReceipt(MailAddress address) { 
        DigitalSignature signature = electoralOrganism.askForDigitalSignature(currentParty);
        mailerService.send(address, signature);
    }
}