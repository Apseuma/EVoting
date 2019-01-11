package data;

//import static junit.framework.Assert.assertEquals;
//import static junit.framework.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

//import org.junit.Test;
import org.junit.jupiter.api.Test;  //JUNIT 5

public class NifTest {
    
    @Test
    public void TestEquals(){
        Nif josep = new Nif ("48054639W");
        Nif josep2 = new Nif ("48054639W"); 
        Nif ramon = new Nif ("78988654E");
        
        assertFalse(josep.equals(ramon));
        assertTrue(josep.equals(josep2));
        assertTrue(josep.equals(josep));        
    }
    
    @Test
    public void TestHashCode(){
        Nif nif1 = new Nif("78578558E");
        Nif nif2 = new Nif("78578558E");
        assertTrue(nif1.hashCode()==nif2.hashCode());
            
    }
    
    @Test
    public void TestToString(){
        Nif nif1 = new Nif ("48258278P");
        String expected="NIF='" +nif1.getNif()+ "' ";
        assertEquals(expected,nif1.toString());
        
        
        
    }
}