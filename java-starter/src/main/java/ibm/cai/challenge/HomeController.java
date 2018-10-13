package ibm.cai.challenge;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {

	@Value("${welcome.message}")
	private String message = "Hello World";

	@RequestMapping("/")
	public String home(Map<String, Object> model) {
		model.put("message", this.message);
		return "home";
	}

	// @RequestMapping("/user")
	// public String user(Map<String, Object> model) {
	// 	model.put("message", this.message);
	// 	return "user";
	// }	
}