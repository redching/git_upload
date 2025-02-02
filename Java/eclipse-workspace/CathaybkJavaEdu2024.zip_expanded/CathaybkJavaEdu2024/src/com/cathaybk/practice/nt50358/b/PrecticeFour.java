package com.cathaybk.practice.nt50358.b;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PrecticeFour {

	public static void csvwriter(List<LinkedHashMap<String, String>> mapList, String[] headers, String filePath)
            throws IOException {
        check(mapList, headers, filePath);
        //判断是否有源文件，如果有就追加写入
        if (!readCsv(filePath)){

            FileOutputStream fos = null;
            //需要UTF-8-BOM编码
            byte[] uft8bom={(byte)0xef,(byte)0xbb,(byte)0xbf};
            fos = new FileOutputStream(filePath, true);
            fos.write(uft8bom);
            //第一次写入
            try (PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(fos, "UTF-8"))) {
                StringBuilder builder = new StringBuilder();
                for(String header : headers) {
                    builder.append(header).append(",");
                }
                builder.deleteCharAt(builder.length() - 1);
                printWriter.println(builder.toString());
                builder.delete(0, builder.length());
                for (LinkedHashMap<String, String> map : mapList) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        builder.append(entry.getValue()).append(",");
                    }
                    builder.deleteCharAt(builder.length() - 1);
                    printWriter.println(builder.toString());
                    builder.delete(0, builder.length());
                }
            }
       
        }else {
            //追加写入
//            File csvFile = new File(filePath);
            try{
                FileOutputStream fos = null;
                //需要UTF-8-BOM编码
                byte[] uft8bom={(byte)0xef,(byte)0xbb,(byte)0xbf};
                fos = new FileOutputStream(filePath, true);
                fos.write(uft8bom);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8"), 1024);

                //遍历所有数据
                for (LinkedHashMap<String, String> map : mapList) {
                    StringBuilder builder = new StringBuilder();
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        builder.append(entry.getValue()).append(",");
                    }
                    builder.append("\r\n");
                    bw.write(builder.toString());
                }
                bw.flush();
                bw.close();

            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
	private static boolean readCsv(String filePath) {
		// TODO Auto-generated method stub
		return false;
	}
	private static void check(List<LinkedHashMap<String, String>> mapList, String[] headers, String filePath) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
