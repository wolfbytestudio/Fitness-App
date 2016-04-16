package com.wolfbytestudio.fitness.exercise;

import com.wolfbytestudio.fitness.util.Utility;

/**
 * All The Muscle Groups in an enumerator
 * Implements Serializable to save and load
 *
 * @author Zack Davidson <<zackdavidson2014@outlook.com>>
 * @author Wolfbyte Studio <<Wolfbytestudio@gmail.com>>
 */
public enum MuscleGroup
{

    TOP_ABS,
    BOTTOM_ABS,
    OBLIQUES,
    CHEST,
    LOWER_BACK,
    UPPER_BACK,
    MIDDLE_BACK,
    TRAPS,
    ABDUCTORS,
    FOREARMS,
    TRICEPS,
    ADDUCTORS,
    GLUTES,
    NECK,
    BICEPS,
    HAMSTRINGS,
    QUADRICEPS,
    CALVES,
    LATS,
    SHOULDERS;

    /**
     * Formats a muscle group
     * <br>example: BOTTOM_ABS = Bottom Abs
     *
     * @param m - the muscle group to format
     * @return - a formatted string version of a muscle group
     */
    public static String format(MuscleGroup m)
    {
        return Utility.format(m.name());
    }


}
