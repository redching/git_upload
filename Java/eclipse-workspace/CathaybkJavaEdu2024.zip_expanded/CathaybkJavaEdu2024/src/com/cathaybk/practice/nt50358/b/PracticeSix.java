package com.cathaybk.practice.nt50358.b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class PracticeSix {

	public static void main(String[] args) {
		List<Map<String, String>> carList = new ArrayList<>();
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream("Java評量_第6題cars.csv"));// 檔案讀取路徑
			BufferedReader reader = new BufferedReader(isr);
			String line = reader.readLine();
			while ((line = reader.readLine()) != null) {
				Map<String, String> map = new HashMap<String, String>();
				String item[] = line.split(",");
				/** 讀取 **/
				String Manufacturer = item[0].trim();// 小駝峰
				String TYPE = item[1].trim();
				String minPRICE = item[2].trim();
				String Price = item[3].trim();
				map.put("Manufacturer", Manufacturer);
				map.put("TYPE", TYPE);
				map.put("Min.PRICE", minPRICE);
				map.put("Price", Price);
				carList.add(map);
				Collections.sort(carList, new Comparator<Map<String, String>>() {
				
					@Override
					public int compare(Map<String, String> o1, Map<String, String> o2) {
						BigDecimal prBigDecimalo1 = new BigDecimal(o1.get("Price"));
						BigDecimal prBigDecimalo2 = new BigDecimal(o2.get("Price"));
						return prBigDecimalo2.compareTo(prBigDecimalo1);
					}

				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter("cars2.csv", StandardCharsets.UTF_8))) {

			StringBuilder csvContent = new StringBuilder();
			csvContent.append("Manufacturer").append(",").append("TYPE").append(",").append("Min.PRICE").append(",")
					.append("Price").append(",").append("\n");
			for (Map<String, String> map : carList) {

				csvContent.append(map.get("Manufacturer")).append(",").append(map.get("TYPE")).append(",")
						.append(map.get("Min.PRICE")).append(",").append(map.get("Price")).append(",").append("\n");
			}
			writer.write(csvContent.toString());

		} catch (IOException e) {
			e.printStackTrace();

		}
		try {
			Collections.sort(carList, new Comparator<Map<String, String>>() {

				@Override
				public int compare(Map<String, String> o1, Map<String, String> o2) {
					return o1.get("Manufacturer").compareTo(o2.get("Manufacturer"));
				}

			});
			TreeSet<String> carset = new TreeSet<>();

			for (Map<String, String> carsetmanuString : carList) {
				carset.add(carsetmanuString.get("Manufacturer"));
			}

			System.out.printf("%-14s%-9s%11s%7s\n", "Manufacturer", "TYPE", "Min.PRICE", "Price");
			BigDecimal totalPricebigDecimal = BigDecimal.ZERO;
			BigDecimal totalMinPricebigDecimal = BigDecimal.ZERO;
			
			ArrayList<BigDecimal> totalCarsPrice = new ArrayList<>();
            ArrayList<BigDecimal> totalCarsMinPrice = new ArrayList<>();
            TreeMap<String, List<Map<String, String>>> groupByManufacturer = new TreeMap<>();
            for (Map<String, String> car : carList) {
                String manufacturer = car.get("Manufacturer");
                if (!groupByManufacturer.containsKey(manufacturer)) {
                    List<Map<String, String>> cars = new ArrayList<>();
                    groupByManufacturer.put(manufacturer, cars);
                }
                groupByManufacturer.get(manufacturer).add(car);
            }
		    for (String manufacturer : groupByManufacturer.keySet()) {
              List<Map<String, String>> cars = groupByManufacturer.get(manufacturer);
              BigDecimal total_manu_price = BigDecimal.ZERO;
              BigDecimal total_manu_min_price = BigDecimal.ZERO;
              for (Map<String, String> map : cars) {
                  System.out.printf("%-14s%-9s%11s%7s\n", manufacturer, map.get("TYPE"), map.get("Min.PRICE"), map.get("Price"));
                  total_manu_price = total_manu_price.add(new BigDecimal(map.get("Price")));
                  total_manu_min_price = total_manu_min_price.add(new BigDecimal(map.get("Min.PRICE")));

              }
              System.out.printf("%-22s%11s%7s\n", "小計", total_manu_min_price, total_manu_price);
              totalCarsPrice.add(total_manu_price);
              totalCarsMinPrice.add(total_manu_min_price);
          }
          BigDecimal total_price = BigDecimal.ZERO;
          BigDecimal total_min_price = BigDecimal.ZERO;
          for (int i = 0; i < totalCarsMinPrice.size(); i++) {
              total_price = total_price.add(totalCarsPrice.get(i));
              total_min_price = total_min_price.add(totalCarsMinPrice.get(i));
          }
          System.out.printf("%-22s%11s%7s\n", "合計", total_min_price, total_price);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
