package com.wolfbytestudio.fitness.exercise;

import java.io.Serializable;

import com.wolfbytestudio.fitness.util.Utility;

/**
 * Contains possible equipment needed for a workout
 * @author Zack Davidson <<zackdavidson2014@outlook.com>>
 * @author Wolfbyte Studio <<Wolfbytestudio@gmail.com>>
 *
 */
public enum Equipment implements Serializable
{

	/**
	 * No equipment required
	 */
	NONE,

	/**
	 * Requires Dumbbells
	 */
	DUMBBELLS,

	/**
	 * Requires a pull-up bar
	 */
	PULLUP_BAR;

}
