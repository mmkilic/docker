package mmk.test.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
	
	private Map<Integer,String> users;
	
	public DemoController() {
		users = new HashMap<>();
		users.put(1, "Mehmet");
		users.put(2, "Merve");
		users.put(3, "Gokmen");
		users.put(4, "Elif");
	}
	
	@GetMapping
	public String getHello(){
		return "Hello Demo API!...";
	}
	@GetMapping("/{id}")
	public String getUser(@PathVariable int id){
		return users.entrySet()
				.stream()
				.filter(e -> e.getKey() == id)
				.map(Map.Entry::getValue)
				.findFirst()
				.get();
	}
	
	@PostMapping
	public String save(@RequestBody String demo) {
		return demo;
	}
	
}
