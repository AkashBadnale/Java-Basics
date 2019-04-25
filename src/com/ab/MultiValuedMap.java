package com.gslab.ab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections4.map.MultiValueMap;

public class MultiValuedMap {

	public static void main(String[] args) {
		
		Map<String,String> map = new LinkedHashMap<>();
		map.put("A", "1");
		map.put("B", "2");
		map.put("A", "3");
		map.put("B", "4");
		
		System.out.println(map);
		
		MultiValueMap<String, String> map2 = new MultiValueMap<String, String>();
		map2.put("A", "1");
		map2.put("B", "2");
		map2.put("A", "3");
		map2.put("B", "4");
		System.out.println(map2);
	}		
}
