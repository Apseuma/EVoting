/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Albert Planes
 */
public class DigitalSignature {
    private final String signature;
    
    public DigitalSignature(String signature) { this.signature = signature; };
    
    public String getSignature() { return signature; };
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DigitalSignature digita1Signature1 = (DigitalSignature) o;
        return signature.equals(digita1Signature1.signature);
    }
    
    @Override
     public int hashCode() { return signature.hashCode(); }
    
     @Override
    public String toString() {
        return "Digital signature='" + signature +  "'";
    }
}
