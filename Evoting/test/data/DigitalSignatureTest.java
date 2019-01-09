/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
//import org.junit.Test;
import org.junit.jupiter.api.Test;  //JUNIT 5

/**
 *
 * @author mique
 */
public class DigitalSignatureTest {
     @Test
    public void TestToString(){
        DigitalSignature signature= new DigitalSignature("IVCSIGNATURE");
        String signature2 = "Digital signature='IVCSIGNATURE'";
        assertEquals(signature2,signature.toString());  
    }
    
    @Test
    public void TestEquals(){
        DigitalSignature signature = new DigitalSignature("ANOTHERSIGNATURE");
        DigitalSignature signature2 = new DigitalSignature ("ANOTHERSIGNATURE");
        assertTrue(signature.equals(signature));
        assertTrue(signature.equals(signature2));

    }
    
    @Test
    public void TestHashCode(){
        DigitalSignature signature = new DigitalSignature ("LASTSIGNATURE");
        DigitalSignature signature2 = new DigitalSignature ("LASTSIGNATURE");
        assertTrue(signature.hashCode()==signature2.hashCode());
    }  
}
