package com.wolfbytestudio.fitness.exercise;

import com.wolfbytestudio.fitness.util.ProceduralGeneratedRandom;
import com.wolfbytestudio.fitness.util.Utility;

/**
 * @author Zack Davidson <<zackdavidson2014@outlook.com>>
 * @author Wolfbyte Studio <<Wolfbytestudio@gmail.com>>
 */
public enum Difficulty
{

    /**
     * Easy Difficulty
     */
    EASY(1),

    /**
     * Medium difficulty
     */
    MEDIUM(3),

    /**
     * Hard Difficulty
     */
    HARD(5),

    /**
     * Insane difficulty
     */
    INSANE(8);

    /**
     * Difficulty Multiplier
     *
     * Used for generating the amount of exercises and rounds
     */
    private final int multiplier;

    /**
     * Enum Constructor
     * @param multiplier - the difficulty multiplier
     */
    Difficulty(final int multiplier)
    {
        this.multiplier = multiplier;
    }

    /**
     * The amount of difficulties there is
     * @return
     */
    public static int count()
    {
        return values().length;
    }

    /**
     * Gets a random from a procedural generated random
     *
     * @param r - the procedural generated random
     * @return - a difficulty
     */
    public static Difficulty getRandom(ProceduralGeneratedRandom r)
    {
        int random = r.getRandomInt(count());
        if (random == 4)
            random = 3;
        return values()[random];
    }

    /**
     * Gets a random difficulty
     *
     * @return
     */
    public static Difficulty getRandom()
    {
        return values()[Utility.getRandomIndex(count())];
    }

    /**
     * Gets the multiplier
     *
     * @return - the multiplier
     */
    public int getMultiplier()
    {
        return multiplier;
    }

}
