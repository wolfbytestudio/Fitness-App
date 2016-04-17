package com.wolfbytestudio.fitness.cache;

import com.wolfbytestudio.fitness.exercise.Exercise;
import com.wolfbytestudio.fitness.workout.Workout;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * The cache that contains all the users workouts
 *
 * @author Zack Davidson <<zackdavidson2014@outlook.com>>
 * @author Wolfbyte Studio <<Wolfbytestudio@gmail.com>>
 */
public class Cache
{

    private static final Cache instance = new Cache();

    private List<Workout> workouts = new ArrayList<>();

    public static final Cache getCache()
    {
        return instance;
    }

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
       //// TODO: 18/04/2016 - save using JSON
    }

    /**
     * Loads all workouts
     */
    public void loadWorkouts()
    {
       //// TODO: 18/04/2016 - load using JSON
    }
}
