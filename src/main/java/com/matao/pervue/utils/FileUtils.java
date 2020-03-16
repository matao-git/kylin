package com.matao.pervue.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**-
 * 
    * @ClassName: FileUtils
    * @Description: 读取文件的工具类
    * @author mt
    * @date 2019年11月9日
    *
 */
public class FileUtils {

	
	
	/**
	 * 
	    * @Title: readFile
	    * @Description: 解析字符文件的实体类
	    * @param @param fileName
	    * @param @return
	    * @param @throws Exception    参数
	    * @return List<String>    返回类型
	    * @throws
	 */
	
	
	public static List<String> readFile(String fileName) throws Exception{
		
		List<String> lines = new ArrayList();
		File file = new File(fileName);
		
		FileInputStream stream = new FileInputStream(file);
		
		InputStreamReader in = new InputStreamReader(stream,"gbk");
		
		BufferedReader reader = new BufferedReader(in);
		
		String str = "";
		
		while((str = reader.readLine()) != null){
			//System.out.println(str);
			lines.add(str);
		}
		
		return lines;
	}
	
	
	public static BufferedReader readerLine(String fileName) throws IOException{
		
		
		File file = new File(fileName);
		
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(file),"gbk")
				);
		
		return reader;
	}
	
	
	/*
	 * 读取文件（可设置编码方式）
	 * @return 文件内容
	 */
	public String ReadFileContent(String filePath){
		File file = new File(filePath);
		// BufferedReader br = new BufferedReader(new FileReader(file));
		BufferedReader br=null;
		try {
			br = new BufferedReader(new InputStreamReader(
					new FileInputStream(file), "gbk"));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String str = null;
		StringBuffer Buff = new StringBuffer();
		try {
			while ((str = br.readLine()) != null) {
				Buff.append(str + "\r\n");
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return Buff.toString();
	}
}
