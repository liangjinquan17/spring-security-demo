package com.sf.springsecurity.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController{
	
	/**
	 * 测试鉴权服务是否通畅
	 * @return
	 */
	@GetMapping("hello")
	public String hello(){
		return "hello security";
	}

	/**
	 * 免鉴权接口
	 * @return
	 */
	@GetMapping("getName")
	public String getName() {
		return "免鉴权接口";
	}
	
}
