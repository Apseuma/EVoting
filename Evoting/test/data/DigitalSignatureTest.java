/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

//import static junit.framework.Assert.assertEquals;
//import static junit.framework.Assert.assertTrue;
import Exceptions.NullReceivedAsParameterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.Signature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.assertThrows;
//import org.junit.Test;
//import static org.junit.Assert.*;

/**helloo
 *
 * @author mique
 */
public class DigitalSignatureTest {
    
    private DigitalSignature signature;
    private DigitalSignature same;
    
    @BeforeEach
    void initDigitalSignature() throws NullReceivedAsParameterException {
        signature=new DigitalSignature("IVCSIGNATURE");
        same = new DigitalSignature("IVCSIGNATURE");
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

    @Test
    public void exceptionTest() {
        assertThrows(NullReceivedAsParameterException.class,
                ()->{
                    DigitalSignature s = new DigitalSignature(null);
                });
    }
}
