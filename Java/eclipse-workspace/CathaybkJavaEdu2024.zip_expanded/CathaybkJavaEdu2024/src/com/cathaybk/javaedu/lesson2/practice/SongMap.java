package com.cathaybk.javaedu.lesson2.practice;

import java.util.Map;
import java.util.TreeMap;

public class SongMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map = new TreeMap<String, String>();
		map.put("Coldplay", "Yellow");
		map.put("Adele", "Skyfall");
		map.put("Lady Gaga", "Shallow");
		for (Map.Entry<String, String> lll : map.entrySet()) {
			System.out.println("Singer：" + lll.getKey() + ",Song：" + lll.getValue());
		}
		System.out.println(map.keySet());
		System.out.println(map.values());
	}

}
