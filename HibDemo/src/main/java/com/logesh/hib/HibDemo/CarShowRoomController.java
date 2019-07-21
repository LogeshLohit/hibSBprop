package com.logesh.hib.HibDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarShowRoomController {
	@Autowired
	private CarShowRoomService service;
	@RequestMapping("cars")
	public void getCarDtls() {
		service.getDtls();
	}
}
