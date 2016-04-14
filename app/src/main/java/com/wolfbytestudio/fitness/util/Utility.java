package com.wolfbytestudio.fitness.util;

import java.util.Date;
import java.util.Random;

/**
 * Contains utility methods
 * @author Zack Davidson <<zackdavidson2014@outlook.com>>
 * @author Wolfbyte Studio <<Wolfbytestudio@gmail.com>>
 *
 */
public class Utility
{

	/**
	 * Random object
	 */
	private final static Random RND = new Random();

	/**
	 * Bad value exception
	 */
	private final static IllegalArgumentException BAD_VALUE =
			new IllegalArgumentException("Value must be positive");

	/**
	 * Gets a random index with a maximum
	 * @param max - the max index
	 * @return - a random value between 0 and max
	 */
	public static int getRandomIndex(int max)
	{
		if(max < 1) throw BAD_VALUE;
		
		return RND.nextInt(max);
	}

	/**
	 * Formats a string value to capitalize the first letter
	 * @param upper - The string
	 * @return - the new formatted string
	 */
	public static String format(String upper)
	{
		char firstLetter = Character.toUpperCase(upper.charAt(0));
		return firstLetter + upper.substring(1).replace("_", " ").toLowerCase();
	}

	/**
	 * Formats the date, redundant code
	 * @param date - the date to format
	 * @return - String formatted time
	 */
	public static String getFormattedDate(Date date)
	{
		String outPut;
		outPut = date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
		return outPut;
	}
	
}
