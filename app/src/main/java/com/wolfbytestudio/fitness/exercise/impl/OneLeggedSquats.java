package com.wolfbytestudio.fitness.exercise.impl;

import java.util.Arrays;

import com.wolfbytestudio.fitness.exercise.*;

/**
 * 
 * @author Zack Davidson <<zackdavidson2014@outlook.com>>
 * @author Wolfbyte Studio <<Wolfbytestudio@gmail.com>>
 *
 */
public class OneLeggedSquats extends Exercise
{

	private static final long serialVersionUID = 6009785082809850203L;

	/**
	 * The name of the exercise
	 */
	private final static String NAME = "One Legged Squats";
	
	/**
	 * The muscle groups the exercise works on
	 */
	private final static MuscleGroup[] MUSCLE_GROUP = {
			 MuscleGroup.HAMSTRINGS,
			 MuscleGroup.GLUTES,
			 MuscleGroup.QUADRICEPS
	};
	
	/**
	 * The equipment required to preform the exercise
	 */
	private final static Equipment[] EQUIPMENT = {
			Equipment.NONE
	};
	
	/**
	 * The difficulty of the exercise
	 */
	private final static Difficulty DIFFICULTY = Difficulty.HARD;
	
	/**
	 * The category of the exercise
	 */
	private final static Category CATEGORY = Category.STANDARD;
	
	/**
	 * The points gained for 1 rep
	 */
	private final static int POINTS = 3;
	
	/**
	 * Is the exercise Timed?
	 */
	private final static boolean TIMED = false;
	
	/**
	 * Pushup constructor
	 */
	public OneLeggedSquats()
	{
		super(	NAME, Arrays.asList(MUSCLE_GROUP),
				Arrays.asList(EQUIPMENT), DIFFICULTY,
				CATEGORY, POINTS, TIMED);
	}
	
	/**
	 * Sets the image id
	 */
	@Override
	protected void setImageId(int id)
	{
		this.imageId = id;
	}

}
