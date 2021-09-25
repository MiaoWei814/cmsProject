package org.learn.domain;

import java.util.ArrayList;
import java.util.List;

public class CityService {
	//定义一个集合专门来装省份
	private static List<City> provinces = new ArrayList<City>();
	
	//定义一个集合专门来装市
	private static List<City> citys = new ArrayList<City>();
	
	static{
		//初始化数据
		City province1 = new City(1L, "湖北省", null);
		//添加省份
		provinces.add(province1);
		
		City city1 = new City(11L, "仙桃市", province1);
		City city2 = new City(12L, "咸宁市", province1);
		City city3 = new City(13L, "武汉市", province1);
		//添加市
		citys.add(city1);
		citys.add(city2);
		citys.add(city3);
		
		
		City province2 = new City(2L, "四川省", null);
		provinces.add(province2);
		
		City city4 = new City(21L, "都江堰市", province2);
		City city5 = new City(22L, "成都市", province2);
		City city6 = new City(23L, "绵阳市", province2);
		citys.add(city4);
		citys.add(city5);
		citys.add(city6);
		
	}
	
	/**
	 * 返回所有的省份
	 * @return
	 */
	public static List<City> getProvinces(){
		return provinces;
	}
	
	/**
	 * 通过省份id查找对应的城市
	 * @param id
	 * @return
	 */
	public static List<City> findCityByProvinceId(Long id){
		List<City> cs = new ArrayList<>();
		for (City city : citys) {
			if(city.getParent().getId() == id){
				cs.add(city);
			}
		}
		return cs;
	}
	
	public static void main(String[] args) {
		List<City> list = getProvinces();
		for (City city : list) {
			System.out.println(city);
		}
		System.out.println("--------------------------------------");
		List<City> list2 = findCityByProvinceId(1L);
		
		for (City city : list2) {
			System.out.println(city);
		}
	}
}
