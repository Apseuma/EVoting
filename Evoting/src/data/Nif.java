/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author mique
 */
final public class Nif {
    
    private final String nif;
 
    public Nif(String nif) { this.nif = nif; }
    
    public String getNif() { return nif; }
  
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nif nif1 = (Nif) o;
        return this.nif.equals(nif1.nif);
    }

    @Override
    public int hashCode() { return nif.hashCode(); }
    
    @Override
    public String toString() {
        return "NIF= " + nif + ".";
    }
}
