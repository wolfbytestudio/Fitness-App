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
public class OneLeggedSquats extends Exercise
{

    private static final long serialVersionUID = 6009785082809850203L;

    /**
     * The name of the exercise
     */
    private static final String NAME = "One Legged Squats";

    /**
     * The muscle groups the exercise works on
     */
    private static final MuscleGroup[] MUSCLE_GROUP = {
            MuscleGroup.HAMSTRINGS,
            MuscleGroup.GLUTES,
            MuscleGroup.QUADRICEPS
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
    private static final Difficulty DIFFICULTY = Difficulty.INSANE;

    /**
     * The category of the exercise
     */
    private static final Category CATEGORY = Category.STANDARD;

    /**
     * The points gained for 1 rep
     */
    private static final int POINTS = 5;

    /**
     * Is the exercise Timed?
     */
    private static final boolean TIMED = false;

    /**
     * How much calories burned per exercise
     */
    private static final float CALS = 0.4F;

    /**
     * Pushup constructor
     */
    public OneLeggedSquats()
    {
        super(NAME, Arrays.asList(MUSCLE_GROUP),
                Arrays.asList(EQUIPMENT), DIFFICULTY,
                CATEGORY, POINTS, TIMED, CALS);
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
