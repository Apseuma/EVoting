/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiosk;

import data.Party;
import java.util.ArrayList;
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
   
    ArrayList<Party> partyList = new ArrayList<>();
    HashSet<Party> validParties = new HashSet<>();
    
    int nullCounter = 0;
    int blankCounter = 0;
    
    public VoteCounter(Set<Party> validParties) { 
        this.validParties = (HashSet<Party>) validParties; //!!!!
        
        partiesWithVotes.put(NULL, 0);
        partiesWithVotes.put(BLANK, 0);
        for(Party party : validParties){
            partiesWithVotes.put(party.getName(), 0);
        }
    }
    
    public void countParty(Party party) { 
        if(party == null){  //!!!!!
            countBlank();    
        }else if(validParties.contains(party)){
            partyList.add(party);
        }else{
            countNull();
        }
    }
    
    public void countNull() { 
        nullCounter++;
    }
    
    public void countBlank() { 
        blankCounter++;
    }
    
    public void scrutinize(Party party) { 
        //WHAT?   
    }
    
    public int getVotesFor(Party party) throws NullPointerException { 
       if(party.equals(null)){
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
