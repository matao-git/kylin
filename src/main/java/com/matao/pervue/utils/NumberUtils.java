package com.matao.pervue.utils;

import java.util.Random;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

/*
 * 
    * @ClassName: NumberUtils
    * @Description: 数字工具类
    * @author mt
    * @date 2019年11月11日
    *
 */
public class NumberUtils {
		
	/**
	 * 
	    * @Title: isNumber
	    * @Description: 判断必须为数字
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	public static boolean isNumber(Object obj){
		
		
		Class class1 = obj.getClass();
		String name = class1.getName();
		System.out.println(name);
		if(name.equals("java.lang.Integer")){
			return true;
		}
		else if(name.equals("java.lang.Double")){
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * 
	    * @Title: randamNum
	    * @Description: 生成一个在指定范围的随机数
	    * @param @param num
	    * @param @return    参数
	    * @return int    返回类型
	    * @throws
	 */
	public static int randamNum(int num){
		Random random = new Random();
		int nextInt = random.nextInt(num);
		if(nextInt == 0 ){
			nextInt += 1 ;
		}
		return nextInt;
	}
	
	
	/**
	 * 生成在指定范围的数字
	 */
	
	public static int randomMaxMin(int min,int max){
			Random random = new Random();
			int scope = random.nextInt(max-min)+min;
			return scope;
    }
	
	public static int categoryShow(int num){
		
		int cat = 0 ;
		
		if(num==1){
			cat = NumberUtils.randomMaxMin(1, 3);
		}
		if(num==2){
			cat = cat = NumberUtils.randomMaxMin(4,8);
		}
		if(num==3){
			cat = NumberUtils.randomMaxMin(9,12);
		}
		if(num==4){
			cat = NumberUtils.randomMaxMin(13,16);
		}
		if(num==5){
			cat = NumberUtils.randomMaxMin(17,20);
		}
		if(num==6){
			cat = NumberUtils.randomMaxMin(21,24);
		}
		if(num==7){
			cat = NumberUtils.randomMaxMin(25,28);
		}
		return cat;
	}
	
	
	
}










































