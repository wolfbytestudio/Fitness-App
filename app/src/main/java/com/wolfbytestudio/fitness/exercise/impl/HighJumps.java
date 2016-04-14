package com.wolfbytestudio.fitness.exercise.impl;

import com.wolfbytestudio.fitness.exercise.Category;
import com.wolfbytestudio.fitness.exercise.Difficulty;
import com.wolfbytestudio.fitness.exercise.Equipment;
import com.wolfbytestudio.fitness.exercise.Exercise;
import com.wolfbytestudio.fitness.exercise.MuscleGroup;

import java.util.Arrays;

/**
 * 
 * @author Zack Davidson <<zackdavidson2014@outlook.com>>
 * @author Wolfbyte Studio <<Wolfbytestudio@gmail.com>>
 *
 */
public class HighJumps extends Exercise
{

	private static final long serialVersionUID = 6138129177470349875L;

	/**
	 * The name of the exercise
	 */
	private final static String NAME = "High Jumps";

	/**
	 * The muscle groups the exercise works on
	 */
	private final static MuscleGroup[] MUSCLE_GROUP = {
			MuscleGroup.QUADRICEPS, MuscleGroup.HAMSTRINGS,
			MuscleGroup.CALVES
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
	private final static Difficulty DIFFICULTY = Difficulty.EASY;

	/**
	 * The category of the exercise
	 */
	private final static Category CATEGORY = Category.STANDARD;

	/**
	 * The points gained for 1 rep
	 */
	private final static int POINTS = 1;

	/**
	 * Is the exercise Timed?
	 */
	private final static boolean TIMED = false;

	/**
	 * Pushup constructor
	 */
	public HighJumps()
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
