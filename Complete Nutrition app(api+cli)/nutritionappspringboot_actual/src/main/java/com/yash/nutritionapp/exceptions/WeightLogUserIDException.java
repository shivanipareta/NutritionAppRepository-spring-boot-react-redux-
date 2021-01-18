package com.yash.nutritionapp.exceptions;

public class WeightLogUserIDException extends Exception {
	private static final long serialVersionUID = 1L;

	public WeightLogUserIDException(String errorMsg)
	{
		super(errorMsg);
	}
}
