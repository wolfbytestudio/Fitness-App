package com.wolfbytestudio.fitness.cache;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wolfbytestudio.fitness.MainActivity;
import com.wolfbytestudio.fitness.R;
import com.wolfbytestudio.fitness.exercise.Equipment;
import com.wolfbytestudio.fitness.exercise.Exercise;
import com.wolfbytestudio.fitness.exercise.MuscleGroup;
import com.wolfbytestudio.fitness.util.ProceduralGeneratedRandom;
import com.wolfbytestudio.fitness.util.Utility;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class Exercises
{

    /**
     * Gson object used for loading all exercises in the list
     */
    public static final Gson GSON = new Gson();
    /**
     * A List of all Exercises
     */
    private static List<Exercise> exercises = new ArrayList<>();

    /**
     * Returns the {@link exercises} list
     *
     * @return - the {@link exercises} list
     */
    public static final List<Exercise> getList()
    {
        return exercises;
    }

    /**
     * Gets an exercise by name
     *
     * @param name - the name of the exercise to get
     * @return - the exercise object
     */
    public static Exercise getByName(String name)
    {
        for (Exercise c : exercises)
        {
            if (c.getName().equalsIgnoreCase(name))
                return c;
        }
        return null;
    }

    /**
     * The amount of elements in the {@link exercises} list
     *
     * @return - the amount of elements in the {@link exercises} list
     */
    public static final int listCount()
    {
        return exercises.size();
    }

    /**
     * Gets an exercise by it's name
     *
     * @param name - the exercise we are trying to find
     * @return - the exercise
     */
    public static Exercise get(String name)
    {
        for (Exercise ex : exercises)
        {
            if (ex.getName().equalsIgnoreCase(name))
                return ex;
        }
        return null;
    }

    /**
     * Loads all exercises from a file
     *
     * @param main - the main activity object
     */
    public static void load(MainActivity main)
    {
        InputStream ins = main.getResources().openRawResource(R.raw.exercises);
        String json = readTextFile(ins);

        Type listType = new TypeToken<ArrayList<Exercise>>()
        {
        }.getType();

        exercises = GSON.fromJson(json, listType);

        for (Exercise ex : exercises)
        {
            Log.d("abc", ex.getName());
        }
    }

    /**
     * Reads all text from a file
     *
     * @param inputStream - the input stream
     * @return - the files string
     */
    private static String readTextFile(InputStream inputStream)
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try
        {
            while ((len = inputStream.read(buf)) != -1)
            {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e)
        {

        }
        return outputStream.toString();
    }

    /**
     * Get a random Exercise from the {@link exercises} list
     *
     * @return - a random {@link exercises}
     */
    public Exercise getRandom()
    {
        return exercises.get(Utility.getRandomIndex(listCount()));
    }

    /**
     * Gets a random exercise based on the procedural generated random object
     * Produces the same result everytime
     *
     * @param rnd - the ProceduralGeneratedRandom object
     * @return - an exercise
     */
    public Exercise getRandom(ProceduralGeneratedRandom rnd)
    {
        return exercises.get(rnd.getRandomInt(listCount()));
    }

    /**
     * Gets a random Exercise from the {@link exercises} list
     * for a specific muscle group
     *
     * @param muscleGroup - the muscle group
     * @return - the exercise
     */
    public Exercise getRandomForMuscle(MuscleGroup muscleGroup)
    {
        Exercise ex = getRandom();

        while (!ex.getMuscles().contains(muscleGroup))
        {
            ex = getRandom();
        }

        return ex;
    }

    /**
     * Gets a random exercise for equipment
     *
     * @param equipment - The equipment to get an exercise from
     * @return - the new exercise
     */
    public Exercise getRandomForEquipment(Equipment equipment)
    {
        Exercise ex = getRandom();

        while (!ex.getEquipment().contains(equipment))
        {
            ex = getRandom();
        }

        return ex;
    }

    /**
     * Gets an exercise from the {@link exercises} list  by index
     *
     * @param index - the index
     * @return - the exercise
     */
    public Exercise getIndex(int index)
    {
        return exercises.get(index);
    }


}
