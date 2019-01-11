/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Exceptions.NullReceivedAsParameterException;

/**
 *
 * @author Albert Planes
 */
public class MailAddress {
    private final String address;
    
    public MailAddress(String adress) throws NullReceivedAsParameterException {

        if(adress == null){
            throw new NullReceivedAsParameterException("Null party received.");
        }

        this.address = adress; };
    
    public String getAddress() { return address; };
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MailAddress mailAdress1 = (MailAddress) o;
        return address.equals(mailAdress1.address);
    }
    
    @Override
     public int hashCode() { return address.hashCode(); }
    
     @Override
    public String toString() {
        return "Mail address='" + address + "'";
    }
    
}
