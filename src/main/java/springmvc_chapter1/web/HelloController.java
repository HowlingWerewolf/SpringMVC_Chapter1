package springmvc_chapter1.web;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	protected final static org.slf4j.Logger logger = LoggerFactory.getLogger(HelloController.class);
    
	protected static int counter = 0;
	protected static final String VIEW_INDEX = "index";
	protected static final String VIEW_HELLO = "hello";

	protected static final String WELCOME = "Welcome";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {

		model.addAttribute("message", WELCOME);
		model.addAttribute("counter", ++counter);
		logger.debug("[welcome] counter : {}", counter);

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_INDEX;
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {

		model.addAttribute("message", WELCOME + " " + name);
		model.addAttribute("counter", ++counter);
		logger.debug("[welcomeName: " + name + "] counter : {}", counter);
		return VIEW_HELLO;
	}

}