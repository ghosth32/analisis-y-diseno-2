import org.junit.*;
import play.test.*;
import models.*;
 
public class BasicTest extends UnitTest {
	
	@Test
	public void createAndRetrieveUser() {
	    // Create a new user and save it
	    new Usuario("irwinghg@gmail.com", "123", "Irwin", "ciudad", "123").save();
	    
	    // Retrieve the user with e-mail address bob@gmail.com
	    Usuario irwin  = Usuario.find("byEmail", "irwinghg@gmail.com").first();
	    
	    // Test 
	    assertNotNull(irwin);
	    assertEquals("Irwin", irwin.nombre);
	}
	
	@Test
	public void tryConnectAsUser() {
	    // Create a new user and save it
	    //new Usuario("irwinghg@gmail.com", "123", "Irwin", "ciudad", "123").save();
	    
	    // Test 
	    assertNotNull(Usuario.connect("irwinghg@gmail.com", "123"));
	    assertNull(Usuario.connect("irwinghg@gmail.com", "badpassword"));
	}
}