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
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;  

public class PartyTest {
       
    @Test
    public void TestEquals(){
        Party pp = new Party ("Partido Popular");
        Party cs = new Party ("Partido Popular");
        assertTrue(pp.equals(cs));
    }
    
    @Test
    public void TestHashCode(){
        
        
        
    }
    
    @Test
    public void TestToString(){
        Party erc = new Party ("Esquerra Republicana");
        String expected="Party{name='Esquerra Republicana'}";
        assertEquals(expected,erc.toString());
        
        
        
    }
}
