import org.junit.*;
import play.test.*;
import models.*;
 
public class autenticarUsuario extends UnitTest {
	
	@Test
	public void tryConnectAsUser() {
	    // Create a new user and save it
	    //new Usuario("irwinghg@gmail.com", "123", "Irwin", "ciudad", "123").save();
	    
	    // Test 
	    assertNotNull(Usuario.connect("irwinghg@gmail.com", "123"));
	    assertNull(Usuario.connect("irwinghg@gmail.com", "badpassword"));
	}
}

