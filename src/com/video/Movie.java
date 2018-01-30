package com.video;
/**
 * 
 * @ClassName: Movie
 * @Description: TODO
 * @author dinasour
 * @date 2018年1月30日
 *
 */
public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	
	private String _title;
	private int _priceCode;
	
	public Movie(String title,int priceCode) {
		_title = title;
		_priceCode = priceCode;
	}
	
	public void setPriceCode(int priceCode) {
		_priceCode = priceCode;
	}
	
	public int getPriceCode() {
		return _priceCode;
	}
	
	public String getTitle() {
		return _title;
	}
}
