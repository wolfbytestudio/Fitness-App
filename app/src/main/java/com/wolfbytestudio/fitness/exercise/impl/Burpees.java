package com.wolfbytestudio.fitness.exercise.impl;

import java.util.Arrays;

import com.wolfbytestudio.fitness.exercise.*;

/**
 * 
 * @author Zack Davidson <<zackdavidson2014@outlook.com>>
 * @author Wolfbyte Studio <<Wolfbytestudio@gmail.com>>
 *
 */
public class Burpees extends Exercise
{
	private static final long serialVersionUID = 4123373111689409217L;

	/**
	 * The name of the exercise
	 */
	private static final String NAME = "Burpees";
	
	/**
	 * The muscle groups the exercise works on
	 */
	private static final MuscleGroup[] MUSCLE_GROUP = {
			MuscleGroup.FOREARMS, MuscleGroup.CHEST,
			MuscleGroup.QUADRICEPS, MuscleGroup.HAMSTRINGS,
			MuscleGroup.BICEPS, MuscleGroup.GLUTES,
			MuscleGroup.BOTTOM_ABS, MuscleGroup.TOP_ABS,
			MuscleGroup.TRICEPS
	};
	
	/**
	 * The equipment required to preform the exercise
	 */
	private static final Equipment[] EQUIPMENT = {
			Equipment.NONE
	};
	
	/**
	 * The difficulty of the exercise
	 */
	private static final Difficulty DIFFICULTY = Difficulty.MEDIUM;
	
	/**
	 * The category of the exercise
	 */
	private static final Category CATEGORY = Category.STANDARD;
	
	/**
	 * The points gained for 1 rep
	 */
	private static final int POINTS = 3;
	
	/**
	 * Is the exercise Timed?
	 */
	private static final boolean TIMED = false;
	
	/**
	 * Pushup constructor
	 */
	public Burpees()
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
