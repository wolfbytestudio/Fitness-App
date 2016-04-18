package com.wolfbytestudio.fitness.user;

/**
 * The users skill
 *
 * @author Zack Davidson <<zackdavidson2014@outlook.com>>
 * @author Wolfbyte Studio <<Wolfbytestudio@gmail.com>>
 */
public class Skill
{

    /**
     * The maxiumum amount of experience a user can have
     */
    private static final int MAXIMUM_EXPERIENCE = 2_000_000_000;

    /**
     * The experience map
     *
     * contains all expereience needed for a specific level
     */
    private static final int[] EXPERIENCE_TABLE = new int[201];

    /**
     * Populates the experience table
     */
    static
    {
        int points = 0;
        int output = 0;

        for (int level = 1; level <= 200; level++)
        {
            EXPERIENCE_TABLE[level] = output;

            points += Math.floor(level + 100 * Math.pow(2, level / 10.0));

            output = (int) Math.floor(points / 1) / 10 * 10;
        }
    }

    /**
     * The amount of experience a user has
     */
    private int experience;

    /**
     * The level of the user
     */
    private int level;

    /**
     * Constructor for Skill
     * @param experience - the amount of experience
     * @param level - the level
     */
    public Skill(int experience, int level)
    {
        this.experience = experience;
        this.level = level;
    }

    /**
     * Gets the expereience
     * @return - experience
     */
    public int getExperience()
    {
        return experience;
    }

    /**
     * Get's the users level
     * @return - the level
     */
    public int getLevel()
    {
        return level;
    }

    /**
     * Adds experience points to the experience counter
     * @param amount - the amount of experience to add
     * @return - true if the user levels up
     */
    public boolean addExperience(int amount)
    {
        int newExperience = Math.min(experience + amount, MAXIMUM_EXPERIENCE);
        int max = getLevelForExperience(newExperience);
        int delta = max - experience;

        experience += delta;

        if(experience >= MAXIMUM_EXPERIENCE)
        {
            experience = MAXIMUM_EXPERIENCE;
            return false;
        }

        if(delta > 0)
        {
            level++;
            return true;
        }

        return false;
    }

    /**
     * Gets level for experience
     * @param experience - the amount of experience
     * @return - the level
     */
    public static int getLevelForExperience(int experience)
    {
        //// TODO: 18/04/2016 - fix this method
        for(int i = 1; i <= 199; i++)
        {
            if(experience < EXPERIENCE_TABLE[i + i])
            {
                return i;
            }
        }
        return 99;
    }
}
