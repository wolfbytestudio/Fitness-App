package com.wolfbytestudio.fitness.workout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Zack Davidson <<zackdavidson2014@outlook.com>>
 * @author Wolfbyte Studio <<Wolfbytestudio@gmail.com>>
 *
 */
public class WorkoutRound implements Serializable
{

	private static final long serialVersionUID = -7831129396127358218L;
	private List<ExerciseSet> sets = new ArrayList<>();

	public WorkoutRound(ExerciseSet[] sets)
	{
		this.sets = Arrays.asList(sets);
	}

	public WorkoutRound() { }

	public WorkoutRound(List<ExerciseSet> sets)
	{
		this.sets = sets;
	}

	public List<ExerciseSet> getSets()
	{
		return sets;
	}

	public void addSet(ExerciseSet set)
	{
		sets.add(set);
	}

	public void removeSet(ExerciseSet set)
	{
		sets.remove(set);
	}

	public void removeLastRest()
	{
		removeSet(sets.size() - 1);
	}

	public void removeSet(int index)
	{
		sets.remove(index);
	}

	public ExerciseSet getSet(int index)
	{
		return sets.get(index);
	}

	@Override
	public String toString()
	{
		String strOut = "";
		for(ExerciseSet set : sets)
		{
			String type = set.getExercise().isTimed() == false ? "Reps" : "Seconds";
			strOut += "Exercise: " + set.getExercise().getName() + ", "+type+": " + set.getAmount() + "\n";
		}
		return strOut;
	}

}

