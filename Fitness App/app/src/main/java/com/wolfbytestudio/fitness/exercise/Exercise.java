package com.wolfbytestudio.fitness.exercise;

import java.util.List;

/**
 * Exercise class defines an exercise and contains properties
 * for an exercise
 *
 * @author Zack Davidson <<zackdavidson2014@outlook.com>>
 * @author Wolfbyte Studio <<Wolfbytestudio@gmail.com>>
 */
public class Exercise
{

    /**
     * The exercise name
     */
    private final String name;

    /**
     * The image id
     * Will be used for android development
     */
    private int imageId;

    /**
     * A list of all muscles used in the Exercise
     */
    private final List<MuscleGroup> muscles;

    /**
     * A list of possible equipment you may need
     */
    private final List<Equipment> equipment;

    /**
     * The Exercise Difficulty
     */
    private final Difficulty difficulty;

    /**
     * The category of the exercise
     */
    private final Category category;

    /**
     * The points to gain per rep
     */
    private final int points;

    /**
     * Check the the exercise is timed or not
     */
    private final boolean isTimed;

    /**
     * How much calories are burned
     */
    private final float caloriesBurned;

    /**
     * Public constructor
     *
     * @param name       - The name of the exercise
     * @param muscles    - A list of all required muscles used in the exercise
     * @param equipment  - A list of all equipment used in the exercise
     * @param difficulty - The difficulty of the exercise
     * @param category   - The category of the exercise
     * @param points     - The points gained per exercise
     * @param isTimed    - Check if the exercise is timed or not
     */
    public Exercise(
            String name, List<MuscleGroup> muscles,
            List<Equipment> equipment, Difficulty difficulty,
            Category category, int points, boolean isTimed, float caloriesBurned)
    {
        this.name = name;
        this.muscles = muscles;
        this.equipment = equipment;
        this.difficulty = difficulty;
        this.category = category;
        this.points = points;
        this.isTimed = isTimed;
        this.caloriesBurned = caloriesBurned;
    }

    /**
     * Gets the category of the exercise
     *
     * @return - {@link category}
     */
    public Category getCategory()
    {
        return category;
    }

    /**
     * Gets the name of the exercise
     *
     * @return - {@link name}
     */
    public String getName()
    {
        return name;
    }

    /**
     * Gets the muscle groups of the exercise
     *
     * @return - {@link muscles}
     */
    public List<MuscleGroup> getMuscles()
    {
        return muscles;
    }


    /**
     * Gets the equipment required of the exercise
     *
     * @return - {@link equipment}
     */
    public List<Equipment> getEquipment()
    {
        return equipment;
    }

    /**
     * Gets the difficulty of the exercise
     *
     * @return - {@link difficulty}
     */
    public Difficulty getDifficulty()
    {
        return difficulty;
    }

    /**
     * Gets the points gained of the exercise
     *
     * @return - {@link points}
     */
    public int getPoints()
    {
        return points;
    }

    /**
     * Gets if the exercise is timed or not
     *
     * @return - {@link difficulty}
     */
    public boolean isTimed()
    {
        return isTimed;
    }

    /**
     * Gets the image id
     *
     * @return - {@link imageId}
     */
    public int getImageId()
    {
        return imageId;
    }

    /**
     * Gets the amount of calories burned for 1 exercise done
     *
     * @return - {@link caloriesBurned}
     */
    public float getCaloriesBurned()
    {
        return caloriesBurned;
    }

}
