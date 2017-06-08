package ru.babin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.babin.web.model.Item;


@Controller
public class MainController {
		
	@GetMapping("/")
	public @ResponseBody String root() {
		return "Welcome to the spring-boot application!";
	}
	
	/*
	 * Send data as form params (Content-Type: application/x-www-form-urlencoded)
	 * 
	 */
	@PostMapping("/post")
	public @ResponseBody String post1(@RequestParam String q, @RequestParam String w ) {
		return String.format("jobs: q=%s , w=%s", q, w);
	}
	
	/*
     * Send data as form params (Content-Type: application/x-www-form-urlencoded)
     * 
     */
    @PostMapping("/post2")
    public @ResponseBody String post2(Item item ) {
        return String.format("post2: %s", item);
    }
	
	
	/*
	 * Send data as JSON-object (Content-Type: application/json)
	 */
    @PostMapping("/post3")
    public @ResponseBody String post3(@RequestBody Item item ) {
        return String.format("post3: %s", item);
    }

	
}
