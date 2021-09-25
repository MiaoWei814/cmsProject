package org.learn.controller;

import org.learn.domain.City;
import org.learn.domain.CityService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author MiaoDaWei
 */
@RestController
@CrossOrigin
public class CityController {
	@RequestMapping("/province")
	public List<City> province(HttpServletResponse resp){
		//指定跨域访问的的域
//		resp.setHeader("Access-Control-Allow-Origin", "*");
		//操作cookie
//		resp.setHeader("Access-Control-Allow-Credentials", "true");
		return CityService.getProvinces();
	}
	
	@RequestMapping("/city")
	public List<City> city(Long pid){
		return CityService.findCityByProvinceId(pid);
	}
}
