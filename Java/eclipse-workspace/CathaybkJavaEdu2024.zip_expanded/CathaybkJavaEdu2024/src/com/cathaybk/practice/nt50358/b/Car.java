package com.cathaybk.practice.nt50358.b;

public class Car {
	private String MANUFACTURER;
	private String TYPE;
	private String MIN_PRICE;

	public String getMANUFACTURER() {
		return MANUFACTURER;
	}

	public void setMANUFACTURER(String mANUFACTURER) {
		MANUFACTURER = mANUFACTURER;
	}

	public String getTYPE() {
		return TYPE;
	}

	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}

	public String getMIN_PRICE() {
		return MIN_PRICE;
	}

	public void setMIN_PRICE(String mIN_PRICE) {
		MIN_PRICE = mIN_PRICE;
	}

	public String getPRICE() {
		return PRICE;
	}

	public void setPRICE(String pRICE) {
		PRICE = pRICE;
	}

	private String PRICE;

	public Car(String mANUFACTURER, String tYPE, String mIN_PRICE, String pRICE) {
		MANUFACTURER = mANUFACTURER;
		TYPE = tYPE;
		MIN_PRICE = mIN_PRICE;
		PRICE = pRICE;
	}

	@Override
	public String toString() {
		return "製造商：" + MANUFACTURER + "，型號：" + TYPE + "，售價：" + PRICE + "，底價：" + MIN_PRICE;
	}

}
