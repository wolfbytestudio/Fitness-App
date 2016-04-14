package com.wolfbytestudio.fitness.workout;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wolfbytestudio.fitness.exercise.Difficulty;
import com.wolfbytestudio.fitness.exercise.Equipment;
import com.wolfbytestudio.fitness.exercise.MuscleGroup;
import com.wolfbytestudio.fitness.util.Utility;

/**
 * Workout object contains everything for a workout
 * @author Zack Davidson <<zackdavidson2014@outlook.com>>
 * @author Wolfbyte Studio <<Wolfbytestudio@gmail.com>>
 *
 */
public class Workout implements Serializable, Cloneable
{
	private static final long serialVersionUID = 4583807712164476492L;
	
	
	private List<WorkoutRound> rounds = new ArrayList<>();
	private String workoutName;
	private WorkoutType type;
	private Difficulty difficulty;
	private int timesComplete;
	private Date bestTime;
	
	public List<WorkoutRound> getRounds()
	{
		return rounds;
	}

	public void setRounds(List<WorkoutRound> rounds)
	{
		this.rounds = rounds;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}
	
	public String getWorkoutName()
	{
		return workoutName;
	}

	public void setWorkoutName(String workoutName)
	{
		this.workoutName = workoutName;
	}

	public WorkoutType getType()
	{
		return type;
	}

	public void setType(WorkoutType type)
	{
		this.type = type;
	}

	public void setTimesComplete(int timesComplete)
	{
		this.timesComplete = timesComplete;
	}

	public void setBestTime(Date time)
	{
		this.bestTime = time;
	}
	
	public Date getBestTime()
	{
		return bestTime;
	}
	
	public void complete()
	{
		timesComplete++;
	}
	
	public int getTimesComplete()
	{
		return timesComplete;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException 
	{
		return (Workout) super.clone();
	}
	
	/**
	 * Gets all muscle groups for the workout
	 * @return - a list of the muscle groups
	 */
	public List<MuscleGroup> getMuscleGroups()
	{
		List<MuscleGroup> ls = new ArrayList<>();
		
		for(WorkoutRound round : rounds)
		{
			for(ExerciseSet set : round.getSets())
			{
				for(MuscleGroup muscle : set.getExercise().getMuscles())
				{
					if(!ls.contains(muscle))
					{
						ls.add(muscle);
					}
				}
			}
		}
		
		return ls;
	}
	
	public String formatMuscleGroups(List<MuscleGroup> list)
	{
		String out = "";
		int counter = 0;
		for(MuscleGroup m : list)
		{
			counter++;
			if(counter == list.size())
			{
				out += MuscleGroup.format(m);
			}
			else
			{
				out += MuscleGroup.format(m) + ", ";	
			}
			
		}
		
		return out;
	}
	
	public List<Equipment> getEquipment()
	{
		return null;
	}
	
	public void addRound(WorkoutRound round)
	{
		rounds.add(round);
	}
	
	public void removeRound(WorkoutRound round)
	{
		rounds.remove(round);
	}
	
	public WorkoutRound getRound(int index)
	{
		return rounds.get(index);
	}

	/**
	 * Gets the amount of experience the workout will give
	 * @return - The amount of experience
	 */
	public int getExperience()
	{
		int counter = 0;
		for(WorkoutRound round : rounds)
		{
			for(ExerciseSet set : round.getSets())
			{
				counter += (set.getExercise().getPoints() * set.getAmount());
			}
		}

		return counter;
	}

	/**
	 * Prints off the workout, used as a testing method
	 */
	public void print()
	{
		Log.d("zz1", "Workout Name: " + workoutName);
		Log.d("zz1", "Workout Difficulty: " + difficulty);
		Log.d("zz1", "Workout Type: " + type);
		Log.d("zz1", "Rounds: " + rounds.size());
		Log.d("zz1", "Times Complete: " + timesComplete);
		Log.d("zz1", "Muscle Groups: " + formatMuscleGroups(getMuscleGroups()));
		
		if(bestTime != null)
			Log.d("zz1", "Best Time: " + Utility.getFormattedDate(bestTime));
		
		for(int i = 0; i < rounds.size(); i++)
		{
			Log.d("zz1", "Round: " + (i + 1));
			Log.d("zz1", rounds.get(i).toString());
		}
	}
	
}