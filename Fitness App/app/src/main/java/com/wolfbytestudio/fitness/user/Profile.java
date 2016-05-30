package com.wolfbytestudio.fitness.user;

import com.google.gson.Gson;


/**
 * The user profile for the fitness app
 *
 * @author Zack Davidson <<zackdavidson2014@outlook.com>>
 * @author Wolfbyte Studio <<Wolfbytestudio@gmail.com>>
 */
public class Profile
{

    /**
     * Your name
     */
    private String name;

    /**
     * The user's skill object
     */
    private Skill skill;

    /**
     * Your motivation speech string
     */
    private String motivation;

    /**
     * The amount of calories burned in total
     */
    private int caloriesBurned;

    /**
     * The users join date
     */
    private long joinDate;

    /**
     * Gson object to save and load
     */
    private static final Gson GSON = new Gson();

    /**
     * Converts the user profile to a json format
     * @return - a json formatted string
     */
    public String toJson() { return GSON.toJson(this); }

    /**
     * Converts a json string to a profile object
     *
     * @param json - the json string
     * @return - the profile object
     */
    public static Profile fromJson(String json)
    {
        return GSON.fromJson(json, Profile.class);
    }

    /**
     * Constructor
     */
    public Profile(String name, Skill skill, String motivation, int caloriesBurned, long joinDate)
    {
        this.name = name;
        this.skill = skill;
        this.motivation = motivation;
        this.caloriesBurned = caloriesBurned;
        this.joinDate = joinDate;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Skill getSkill()
    {
        return skill;
    }

    public void setSkill(Skill skill)
    {
        this.skill = skill;
    }

    public String getMotivation()
    {
        return motivation;
    }

    public void setMotivation(String motivation)
    {
        this.motivation = motivation;
    }

    public int getCaloriesBurned()
    {
        return caloriesBurned;
    }

    public void setCaloriesBurned(int caloriesBurned)
    {
        this.caloriesBurned = caloriesBurned;
    }

    public long getJoinDate()
    {
        return joinDate;
    }



}
