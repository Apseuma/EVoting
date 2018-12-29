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
    public void TesttoString(){
        MailAddress adress= new MailAddress("ivc44@alumnes.udl.cat");
        String adress2 = "Address{ ='ivc44@alumnes.udl.cat'}";
        assertEquals(adress2,adress.toString());  
    }
    
    @Test
    public void TestEquals(){
        MailAddress adress = new MailAddress("hola@gmail.com");
        MailAddress adress2 = new MailAddress ("hola@gmail.com");
        assertTrue(adress.equals(adress));
    }
    
    @Test
    public void TestHashCode(){
        MailAddress adress = new MailAddress ("adeu@gmail.com");
        MailAddress adress2 = new MailAddress ("adeu@gmail.com");
        assertTrue(adress.hashCode()==adress2.hashCode());
    }  

}
