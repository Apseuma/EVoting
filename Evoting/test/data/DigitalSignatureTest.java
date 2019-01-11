/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

//import static junit.framework.Assert.assertEquals;
//import static junit.framework.Assert.assertTrue;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.Test;
import org.junit.jupiter.api.Test;  //JUNIT 5
//import static org.junit.Assert.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.engine.*;
import static org.junit.jupiter.api.Assertions.*;

/**helloo
 *
 * @author mique
 */
public class DigitalSignatureTest {
    
    private DigitalSignature signature;
    private DigitalSignature same;
    
    @BeforeEach
    void initDigitalSignature(){
        signature=new DigitalSignature("IVCSIGNATURE");
        same = new DigitalSignature("IVCSIGNATURE");
        int prova;

    }
   
    @Test
    void TestToString(){
        String expected = "Digital signature='IVCSIGNATURE'";
        assertEquals(expected,signature.toString());
    }
    
    @Test
    void TestEquals(){
        assertTrue(same.equals(signature));
        assertTrue(same.equals(same));

    }
    
    @Test
    void TestHashCode(){
        assertTrue(signature.hashCode()==same.hashCode());
    }  
}
