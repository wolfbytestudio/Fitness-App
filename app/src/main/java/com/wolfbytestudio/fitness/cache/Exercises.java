package com.wolfbytestudio.fitness.cache;

import java.util.ArrayList;
import java.util.List;

import com.wolfbytestudio.fitness.exercise.*;
import com.wolfbytestudio.fitness.exercise.impl.*;
import com.wolfbytestudio.fitness.util.ProceduralGeneratedRandom;
import com.wolfbytestudio.fitness.util.Utility;


public class Exercises
{

	/**
	 * A List of all Exercises
	 */
	private static final List<Exercise> EXERCISES = new ArrayList<>();

	/**
	 * The rest exercise
	 */
	private static final Rest REST = new Rest();

	/**
	 * Gets the rest exercise
	 * @return
	 */
	public final static Rest getRest()
	{
		return REST;
	}

	/**
	 * Static field to populate the {@link EXERCISES} list
	 */
	static
	{
		EXERCISES.add(new Burpees());
		EXERCISES.add(new CrossCrunches());
		EXERCISES.add(new Crunches());
		EXERCISES.add(new HeelTouches());
		EXERCISES.add(new Squats());
		EXERCISES.add(new TrianglePushUps());
		EXERCISES.add(new LegRaises());
		EXERCISES.add(new OneLeggedSquats());
		EXERCISES.add(new PushUps());
		EXERCISES.add(new SitUps());
		EXERCISES.add(new Lunges());
		EXERCISES.add(new Climbers());
		EXERCISES.add(new HighJumps());
	}

	/**
	 * Returns the {@link EXERCISES} list
	 * @return - the {@link EXERCISES} list
	 */
	public static final List<Exercise> getList()
	{
		return EXERCISES;
	}


	/**
	 * Gets an exercise by name
	 * @param name - the name of the exercise to get
	 * @return - the exercise object
	 */
	public static Exercise getExerciseByName(String name)
	{
		for (Exercise c : EXERCISES)
		{
			if(c.getName().equalsIgnoreCase(name))
				return c;
		}
		return null;
	}

	/**
	 * The amount of elements in the {@link EXERCISES} list
	 * @return - the amount of elements in the {@link EXERCISES} list
	 */
	public static final int exerciseListCount()
	{
		return EXERCISES.size();
	}

	/**
	 * Get a random Exercise from the {@link EXERCISES} list
	 * @return - a random {@link EXERCISES}
	 */
	public Exercise getRandom()
	{
		return EXERCISES.get(Utility.getRandomIndex(exerciseListCount()));
	}

	/**
	 * Gets a random exercise based on the procedural generated random object
	 * Produces the same result everytime
	 * @param rnd - the ProceduralGeneratedRandom object
	 * @return - an exercise
	 */
	public Exercise getRandom(ProceduralGeneratedRandom rnd)
	{
		return EXERCISES.get(rnd.getRandomInt(exerciseListCount()));
	}

	/**
	 * Gets a random Exercise from the {@link EXERCISES} list
	 * for a specific muscle group
	 * @param muscleGroup - the muscle group
	 * @return - the exercise
	 */
	public Exercise getRandomForMuscle(MuscleGroup muscleGroup)
	{
		Exercise ex = getRandom();

		while(!ex.getMuscles().contains(muscleGroup))
		{
			ex = getRandom();
		}

		return ex;
	}

	/**
	 * Gets a random exercise for equipment
	 * @param equipment - The equipment to get an exercise from
	 * @return - the new exercise
	 */
	public Exercise getRandomForEquipment(Equipment equipment)
	{
		Exercise ex = getRandom();

		while(!ex.getEquipment().contains(equipment))
		{
			ex = getRandom();
		}

		return ex;
	}

	/**
	 * Gets an exercise from the {@link EXERCISES} list  by index
	 * @param index - the index
	 * @return - the exercise
	 */
	public Exercise getIndex(int index)
	{
		return EXERCISES.get(index);
	}


}
