package ru.babin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.babin.web.model.Item2;
import ru.babin.web.model.Job;


@Controller
public class MainController {
		
	@GetMapping("/")
	public @ResponseBody String root() {
		return "Welcome to the spring-boot application!";
	}

	@Transactional
	@PostMapping("/post")
	public @ResponseBody String jobs(@RequestParam String q, @RequestParam String w ) {
		return String.format("jobs: q=%s , w=%s", q, w);
	}
	
	@Transactional
    @PostMapping("/post2")
    public @ResponseBody String jobs(@RequestBody Item2 item ) {
        return String.format("post2: %s", item);
    }

	@GetMapping("/get")
	public @ResponseBody Job statistics() {
		return new Job();
	}
}
