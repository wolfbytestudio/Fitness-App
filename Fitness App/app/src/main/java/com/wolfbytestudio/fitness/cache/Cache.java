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
 * The cache that contains all the users settings and workouts
 *
 * @author Zack Davidson <<zackdavidson2014@outlook.com>>
 * @author Wolfbyte Studio <<Wolfbytestudio@gmail.com>>
 */
// TODO: 18/04/2016 - This class needs completely redone
public class Cache
{

    /**
     * A singleton instance of the cache class
     */
    private static final Cache instance = new Cache();

    /**
     * A list of all workouts
     */
    private List<Workout> workouts = new ArrayList<>();

    /**
     * Gets the singleton cache object
     *
     * @return - the singleton cache object
     */
    public static final Cache getCache()
    {
        return instance;
    }

    /**
     * Gets all the workouts
     *
     * @return - returns the list of workouts
     */
    public List<Workout> getWorkouts()
    {
        return workouts;
    }

    /**
     * Adds a workout to the workout list
     *
     * @param workout - the workout to add
     */
    public void addWorkout(Workout workout)
    {
        workouts.add(workout);
    }

    /**
     * Removes a workout from the list
     *
     * @param workout - the workout to remove
     */
    public void removeWorkout(Workout workout)
    {
        workouts.remove(workout);
    }

    /**
     * Saves all workouts to the users device
     */
    public void saveWorkouts()
    {
       // TODO: 18/04/2016 - save using JSON
    }

    /**
     * Loads all workouts from the users device
     */
    public void loadWorkouts()
    {
       // TODO: 18/04/2016 - load using JSON
    }
}
