package com.wolfbytestudio.fitness.exercise.impl;

import com.wolfbytestudio.fitness.exercise.Category;
import com.wolfbytestudio.fitness.exercise.Difficulty;
import com.wolfbytestudio.fitness.exercise.Equipment;
import com.wolfbytestudio.fitness.exercise.Exercise;
import com.wolfbytestudio.fitness.exercise.MuscleGroup;

import java.util.Arrays;

/**
 * @author Zack Davidson <<zackdavidson2014@outlook.com>>
 * @author Wolfbyte Studio <<Wolfbytestudio@gmail.com>>
 */
public class Squats extends Exercise
{

    private static final long serialVersionUID = -1876486181256412675L;

    /**
     * The name of the exercise
     */
    private static final String NAME = "Squats";

    /**
     * The muscle groups the exercise works on
     */
    private static final MuscleGroup[] MUSCLE_GROUP = {
            MuscleGroup.LOWER_BACK, MuscleGroup.HAMSTRINGS,
            MuscleGroup.GLUTES, MuscleGroup.QUADRICEPS
    };

    /**
     * The equipment required to preform the exercise
     */
    private static final Equipment[] EQUIPMENT = {
            Equipment.NONE
    };

    /**
     * The difficulty of the exercise
     */
    private static final Difficulty DIFFICULTY = Difficulty.EASY;

    /**
     * The category of the exercise
     */
    private static final Category CATEGORY = Category.STANDARD;

    /**
     * The points gained for 1 rep
     */
    private static final int POINTS = 1;

    /**
     * Is the exercise Timed?
     */
    private static final boolean TIMED = false;

    /**
     * Pushup constructor
     */
    public Squats()
    {
        super(NAME, Arrays.asList(MUSCLE_GROUP),
                Arrays.asList(EQUIPMENT), DIFFICULTY,
                CATEGORY, POINTS, TIMED);
    }

    /**
     * Sets the image id
     */
    @Override
    protected void setImageId(int id)
    {
        this.imageId = id;
    }

}
