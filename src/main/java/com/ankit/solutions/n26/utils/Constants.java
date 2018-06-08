package com.ankit.solutions.n26.utils;

public interface Constants {

	public static final int timeLimitInSeconds = 60;
	
	//timeLimitInSeconds has to be in multiple of 60 for precise calculation in minutes
	public static final int timeLimitInMinutes = timeLimitInSeconds/60;
	
	
	
}
