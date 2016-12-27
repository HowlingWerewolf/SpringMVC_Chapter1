package springmvc_chapter1.web;

import org.junit.Test;
import org.springframework.ui.ModelMap;

import junit.framework.TestCase;

public class HelloControllerTest extends TestCase {

	protected final String INDEX = "index";
	protected final String HELLO = "hello";

	@Test
	public void testInit() {		
		HelloController controller = new HelloController();
		
		assertNotNull(controller.logger);
		assertEquals(controller.VIEW_INDEX, INDEX);
		assertEquals(controller.VIEW_HELLO, HELLO);	
	}

	@Test
	public void testWelcome() {		
		HelloController controller = new HelloController();
		
		ModelMap model = new ModelMap();
		
		assertNotNull(controller.logger);
		assertEquals(controller.welcome(model), INDEX);
		assertEquals(model.get("message"), controller.WELCOME);	
		assertTrue((int)model.get("counter") > 0);	
	}

	@Test
	public void testWelcomeName() {		
		HelloController controller = new HelloController();
		
		ModelMap model = new ModelMap();
		
		final String NAME = "test"; 
		
		assertNotNull(controller.logger);
		assertEquals(controller.welcomeName(NAME, model), HELLO);
		assertTrue(((String)model.get("message")).equals(controller.WELCOME + " " + NAME));	
		assertTrue((int)model.get("counter") > 0);	
	}

}
