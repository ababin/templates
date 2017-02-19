package ru.babin.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.babin.web.api.Ob;
import ru.babin.web.api.Response;
import ru.babin.web.service.SomeService;


@Controller
public class TestController {
	
	@Autowired
	private SomeService service;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public Response some() {
		Response res = new Response();
		res.resultCode = service.getNumber();
		
		Map<String, Object> data = new HashMap<>();
		data.put("param1", "val1");
		data.put("param2", 10L);
		data.put("someObject", new Ob());
		
		res.data = data;
						
		return res;
	}
	
	
	@RequestMapping(value = "/mul/{p1},{p2}", method = RequestMethod.GET)
	@ResponseBody
	public Response mul(@PathVariable int p1, @PathVariable int p2) {
		Response res = new Response();
		res.data = p1*p2;
		return res;
	}
	
	@RequestMapping(value = "/channels", method = RequestMethod.GET)
	@ResponseBody
	public Response channels() {
		Response res = new Response();
		res.resultCode = service.getNumber();
						
		res.data = service.getChannels();						
		
		return res;
	}
	
		
}
