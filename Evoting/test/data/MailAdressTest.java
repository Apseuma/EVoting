package data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import static junit.framework.Assert.assertEquals;
//import static junit.framework.Assert.assertTrue;

import Exceptions.NullReceivedAsParameterException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.Test;
/**
 *
 * @author Albert Planes
 */
public class MailAdressTest {
    
    @Test
    @DisplayName("Test de toString del MailAdress")
    public void TestToString() throws NullReceivedAsParameterException {
        MailAddress address= new MailAddress("ivc44@alumnes.udl.cat");
        String expected = "Mail address='ivc44@alumnes.udl.cat'";
        assertEquals(expected,address.toString());  
    }
    
    @Test
    public void TestEquals() throws NullReceivedAsParameterException {
        MailAddress address = new MailAddress("hola@gmail.com");
        MailAddress address2 = new MailAddress ("hola@gmail.com");
        assertTrue(address.equals(address));
        assertTrue(address.equals(address2));

    }
    
    @Test
    public void TestHashCode() throws NullReceivedAsParameterException{
        MailAddress address = new MailAddress ("adeu@gmail.com");
        MailAddress address2 = new MailAddress ("adeu@gmail.com");
        assertTrue(address.hashCode()==address2.hashCode());
    }

    @Test
    public void exceptionTest() {
        assertThrows(NullReceivedAsParameterException.class,
                ()->{
                    MailAddress s = new MailAddress(null);
                });
    }

}
