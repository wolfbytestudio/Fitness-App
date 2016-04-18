package com.wolfbytestudio.fitness.workout;

import com.wolfbytestudio.fitness.cache.Exercises;
import com.wolfbytestudio.fitness.exercise.Exercise;

import java.io.Serializable;

/**
 * @author Zack Davidson <<zackdavidson2014@outlook.com>>
 * @author Wolfbyte Studio <<Wolfbytestudio@gmail.com>>
 */
public class ExerciseRep implements Serializable
{
    private static final long serialVersionUID = -3282963882168359755L;

    /**
     * The amount of reps to do
     */
    private int amount;

    /**
     * The exercise you have to do
     */
    private String exercise;

    /**
     * Constructor
     *
     * @param amount
     * @param exercise
     */
    public ExerciseRep(int amount, String exercise)
    {
        this.amount = amount;
        this.exercise = exercise;
    }

    /**
     * Default Constructor
     *
     * Sets amount to 1
     * Sets Exercise to null
     */
    public ExerciseRep()
    {
        setAmount(1);
        setExercise("null");
    }

    /**
     * Gets the exercise
     *
     * @return - the Exercise object
     */
    public Exercise getExercise()
    {
        return Exercises.get(exercise);
    }

    /**
     * Set's the
     *
     * @param exercise
     */
    public void setExercise(String exercise)
    {
        this.exercise = exercise;
    }


    public int getAmount()
    {
        return amount;
    }

    public void setAmount(int amount)
    {
        this.amount = amount;
    }

    /**
     * Formats the amount of reps
     *
     * If the exercise is timed it will return AMOUNT seconds
     * else it will return AMOUNT
     * @return
     */
    public String getFormattedAmount()
    {
        String out = "";

        if (getExercise().isTimed())
            out = amount + " Seconds ";
        else
            out = "" + amount;

        return out;
    }

}
