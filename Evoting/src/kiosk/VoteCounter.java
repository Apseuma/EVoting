/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiosk;

import data.Party;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Albert Planes
 */
public class VoteCounter {
    
    private final String BLANK = "blank";
    private final String NULL = "null";
   
    HashMap<String, Integer> partiesWithVotes = new HashMap<>();
   
    HashSet<Party> validParties = new HashSet<>();
    
    
    public VoteCounter(Set<Party> validParties) { 
        this.validParties = (HashSet<Party>) validParties; //!!!!
        
        partiesWithVotes.put(NULL, 0);
        partiesWithVotes.put(BLANK, 0);
        for(Party party : validParties){
            partiesWithVotes.put(party.getName(), 0);
        }
    }
    
    public void countParty(Party party) { 
        partiesWithVotes.put(party.getName(), partiesWithVotes.get(party.getName()) + 1);
    }
    
    public void countNull() { 
        partiesWithVotes.put(NULL, partiesWithVotes.get(NULL) + 1);
    }
    
    public void countBlank() { 
        partiesWithVotes.put(BLANK, partiesWithVotes.get(BLANK) + 1);
    }
    
    public void scrutinize(Party party) { 
        if(party == null){  //!!!!!
            countBlank();    
        }else if(validParties.contains(party)){
           countParty(party);
        }else{
            countNull();
        } 
    }
    
    public int getVotesFor(Party party) throws NullPointerException { 
       if(party == null){
           throw new NullPointerException();
       }
       
        return partiesWithVotes.get(party.getName());
    }
    
    public int getNulls() {
         return partiesWithVotes.get(NULL);
    }
    
    public int getBlanks() { 
         return partiesWithVotes.get(BLANK);
    }
   
    public int getTotal() { 
        int totalVotes = 0;
        
        for (String name : partiesWithVotes.keySet()){
            totalVotes += partiesWithVotes.get(name);
        }
        return totalVotes;
    }

}
