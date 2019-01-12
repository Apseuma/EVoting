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
//import static junit.framework.Assert.assertEquals;
//import static junit.framework.Assert.assertTrue;
import Exceptions.NullReceivedAsParameterException;
import static org.junit.jupiter.api.Assertions.*;

//import org.junit.Test;
import org.junit.jupiter.api.Test;  //JUNIT 5

public class PartyTest {
       
    @Test
    public void TestEquals() throws NullReceivedAsParameterException {
        Party pp = new Party ("Partido Popular");
        Party cs = new Party ("Partido Popular");
        assertTrue(pp.equals(cs));
    }
    
    @Test
    public void TestHashCode() throws NullReceivedAsParameterException{
        Party party1 = new Party("PSC");
        Party party2 = new Party("PSC");
        assertTrue(party1.hashCode()==party2.hashCode());
            
    }
    
    @Test
    public void TestToString() throws NullReceivedAsParameterException{
        Party erc = new Party ("Esquerra Republicana");
        String expected="Party{name='Esquerra Republicana'}";
        assertEquals(expected,erc.toString());
    }

    @Test
    public void exceptionTest() {
        assertThrows(NullReceivedAsParameterException.class,
                ()->{
                    Party s = new Party(null);
                });
    }
}
