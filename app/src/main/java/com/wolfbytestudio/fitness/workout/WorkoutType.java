package com.wolfbytestudio.fitness.workout;

import com.wolfbytestudio.fitness.util.ProceduralGeneratedRandom;

import java.io.Serializable;

/**
 * @author Zack Davidson <<zackdavidson2014@outlook.com>>
 * @author Wolfbyte Studio <<Wolfbytestudio@gmail.com>>
 */
public enum WorkoutType implements Serializable
{

    /**
     * Incline will increase the reps each round
     */
    INCLINE,

    /**
     * Decline will decline the reps each round
     */
    DECLINE,

    /**
     * Pyramid will increase reps to the middle
     * then decrease reps till the end
     */
    PYRAMID,

    /**
     * Steady will be the same reps throughout
     */
    STEADY;

    /**
     * gets a random workout type based on the
     * procedurally random object
     *
     * @param rnd - the procedural random object
     * @return - return a workout type
     */
    public static WorkoutType getRandom(ProceduralGeneratedRandom rnd)
    {
        int random = rnd.getRandomInt(values().length);
        if (random >= 4)
        {
            random = 3;
        }
        return values()[random];
    }
}
