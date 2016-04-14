package com.wolfbytestudio.fitness.cache;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.wolfbytestudio.fitness.workout.Workout;

public class Cache
{
	
	private final static Cache instance = new Cache();
	public final static Cache getCache()
	{
		return instance;
	}
	
	private final Exercises EXERCISES = new Exercises();
	public final Exercises getExercises()
	{
		return EXERCISES;
	}

	private List<Workout> workouts = new ArrayList<>();
	public List<Workout> getWorkouts()
	{
		return workouts;
	}
	
	public void addWorkout(Workout workout)
	{
		workouts.add(workout);
	}
	
	public void removeWorkout(Workout workout)
	{
		workouts.remove(workout);
	}
	
	/**
	 * Saves all workouts
	 */
	public void saveWorkouts()
	{
		try 
		{
			FileOutputStream file = new FileOutputStream("workouts.wolfbyte");
			ObjectOutputStream obj = new ObjectOutputStream(file);
			
			obj.writeObject(workouts);
			
			file.close();
			obj.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * Loads all workouts
	 */
	public void loadWorkouts()
	{
		try 
		{
			FileInputStream file = new FileInputStream("workouts.wolfbyte");
			ObjectInputStream obj = new ObjectInputStream(file);
			
			workouts = (List<Workout>) obj.readObject();
			
			file.close();
			obj.close();
		} 
		catch (IOException | ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
   	 
        
	}
}
