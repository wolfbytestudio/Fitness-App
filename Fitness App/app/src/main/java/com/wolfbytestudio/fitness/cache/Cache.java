package com.wolfbytestudio.fitness.cache;

import com.wolfbytestudio.fitness.workout.Workout;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Cache
{

    private static final Cache instance = new Cache();
    private final Exercises EXERCISES = new Exercises();
    private List<Workout> workouts = new ArrayList<>();

    public static final Cache getCache()
    {
        return instance;
    }

    public final Exercises getExercises()
    {
        return EXERCISES;
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
        try
        {
            FileOutputStream file = new FileOutputStream("workouts.wolfbyte");
            ObjectOutputStream obj = new ObjectOutputStream(file);

            obj.writeObject(workouts);

            file.close();
            obj.close();
        } catch (IOException e)
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
        } catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }


    }
}
