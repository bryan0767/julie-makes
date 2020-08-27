package com.example.Julie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@SpringBootApplication
@RestController
public class JulieApplication {

	public static void main(String[] args) {
		SpringApplication.run(JulieApplication.class, args);
	}

	@GetMapping("/getAll")
	public Map<String, String> getAll() {
			System.out.println("noone said this would be easy");
		    HashMap<String, String> map = new HashMap<>();
		    map.put("name", "Bryan Atencia");
		    map.put("job", "Dev");
		    return map;
		}

	@PostMapping("/sendMessage")
	 public String postMessage() {
		return "Dope";
	}

}
