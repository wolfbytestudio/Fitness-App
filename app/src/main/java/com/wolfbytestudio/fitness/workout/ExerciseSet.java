package com.wolfbytestudio.fitness.workout;

import java.io.Serializable;

import com.wolfbytestudio.fitness.exercise.Exercise;

/**
 * 
 * @author Zack Davidson <<zackdavidson2014@outlook.com>>
 * @author Wolfbyte Studio <<Wolfbytestudio@gmail.com>>
 *
 */
public class ExerciseSet implements Serializable
{
	
	private static final long serialVersionUID = -3282963882168359755L;
	
	private int amount;
	private Exercise exercise;
	
	public ExerciseSet(int amount, Exercise exercise)
	{
		this.amount = amount;
		this.exercise = exercise;
	}
	
	public Exercise getExercise()
	{
		return exercise;
	}

	public void setExercise(Exercise exercise)
	{
		this.exercise = exercise;
	}
	
	
	public int getAmount() {
		return amount;
	}

	public String getFormattedAmount()
	{
		String out = "";

		if(exercise.isTimed())
			out = amount + " Seconds ";
		else
			out = "" + amount;

		return out;
	}

	public void setAmount(int amount) { this.amount = amount; }
	
}
