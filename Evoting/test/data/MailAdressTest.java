package data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Albert Planes
 */
public class MailAdressTest {
    
    @Test
    public void TestToString(){
        MailAdress adress= new MailAdress("ivc44@alumnes.udl.cat");
        String adress2 = "Mail adress='ivc44@alumnes.udl.cat'";
        assertEquals(adress2,adress.toString());  
    }
    
    @Test
    public void TestEquals(){
        MailAdress adress = new MailAdress("hola@gmail.com");
        MailAdress adress2 = new MailAdress ("hola@gmail.com");
        assertTrue(adress.equals(adress));
        assertTrue(adress.equals(adress2));

    }
    
    @Test
    public void TestHashCode(){
        MailAdress adress = new MailAdress ("adeu@gmail.com");
        MailAdress adress2 = new MailAdress ("adeu@gmail.com");
        assertTrue(adress.hashCode()==adress2.hashCode());
    }  

}
