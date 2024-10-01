package com.demo.swiggy_driver.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.swiggy_driver.service.DriverLocationService;

@RestController
@RequestMapping("/api")
public class DriverLocationController {
	@Autowired
	DriverLocationService dls;
	
	@PutMapping("/locations")
	public ResponseEntity<Map<String,Object>> updateLocation() throws InterruptedException{
		int n=100;
		while(n>0) {
			String coordinates=Math.random()+" , "+Math.random();
			//System.out.println(Math.random()+" , "+Math.random());
			dls.updateLocation(coordinates);
			Thread.sleep(1000);
			n--;
		}
		return new ResponseEntity<>(Map.of("message","Location Updated"),HttpStatus.OK);
	}
}
