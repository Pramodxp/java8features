package com.learnjava.practice;

/**
 * @author pramodr
 *
 */
public class MobileNumber {

	private String number;

	public MobileNumber(String number) {
		super();
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "MobileNumber [number=" + number + "]";
	}

}