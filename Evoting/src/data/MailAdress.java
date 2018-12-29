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
public class MailAdress {
    private final String adress;
    
    public MailAdress(String adress) { this.adress = adress; };
    
    public String getAdress() { return adress; };
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MailAdress mailAdress1 = (MailAdress) o;
        return adress.equals(mailAdress1.adress);
    }
    
    @Override
     public int hashCode() { return adress.hashCode(); }
    
     @Override
    public String toString() {
        return "Mail adress='" + adress + "'";
    }
    
}
