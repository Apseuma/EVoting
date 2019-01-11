package data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Exceptions.NullReceivedAsParameterException;

/**
 *
 * @author Albert Planes
 */
final public class Party {
 
    private final String name;
 
    public Party(String name) throws NullReceivedAsParameterException {

        if(name == null){
            throw new NullReceivedAsParameterException("Null party received.");
        }

        this.name = name;
    }
    
    public String getName() { return name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Party party1 = (Party) o;
        return name.equals(party1.name);
    }
 
    @Override
    public int hashCode() { return name.hashCode(); }
    
    @Override
    public String toString() {
        return "Party{" + "name='" + name + '\'' + '}';
    }
}

