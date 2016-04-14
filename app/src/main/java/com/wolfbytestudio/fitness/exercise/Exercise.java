package com.wolfbytestudio.fitness.exercise;

import java.io.Serializable;
import java.util.List;

/**
 * Exercise class defines an exercise and contains properties
 * for an exercise
 *
 * @author Zack Davidson <<zackdavidson2014@outlook.com>>
 * @author Wolfbyte Studio <<Wolfbytestudio@gmail.com>>
 */
public abstract class Exercise implements Serializable
{
    /**
     * UID to stop the compiler complaining.
     */
    private static final long serialVersionUID = 2259829267927015964L;

    /**
     * The exercise name
     */
    protected String name;

    /**
     * The image id
     * Will be used for android development
     */
    protected int imageId;

    /**
     * A list of all muscles used in the Exercise
     */
    protected List<MuscleGroup> muscles;

    /**
     * A list of possible equipment you may need
     */
    protected List<Equipment> equipment;

    /**
     * The Exercise Difficulty
     */
    protected Difficulty difficulty;

    /**
     * The category of the exercise
     */
    protected Category category;

    /**
     * The points to gain per rep
     */
    protected int points;

    /**
     * Check the the exercise is timed or not
     */
    protected boolean isTimed;

    /**
     * Public constructor
     *
     * @param name       - {@link name}
     * @param muscles    - {@link muscles}
     * @param equipment  - {@link equipment}
     * @param difficulty - {@link difficulty}
     * @param category   - {@link category}
     * @param points     - {@link points}
     * @param isTimed    - {@link isTimed}
     */
    public Exercise(
            String name, List<MuscleGroup> muscles,
            List<Equipment> equipment, Difficulty difficulty,
            Category category, int points, boolean isTimed)
    {
        this.name = name;
        this.muscles = muscles;
        this.equipment = equipment;
        this.difficulty = difficulty;
        this.category = category;
        this.points = points;
        this.isTimed = isTimed;
    }


    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<MuscleGroup> getMuscles()
    {
        return muscles;
    }

    public void setMuscles(List<MuscleGroup> muscles)
    {
        this.muscles = muscles;
    }

    public List<Equipment> getEquipment()
    {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment)
    {
        this.equipment = equipment;
    }

    public Difficulty getDifficulty()
    {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty)
    {
        this.difficulty = difficulty;
    }

    public int getPoints()
    {
        return points;
    }

    public void setPoints(int points)
    {
        this.points = points;
    }

    public boolean isTimed()
    {
        return isTimed;
    }

    public void setTimed(boolean isTimed)
    {
        this.isTimed = isTimed;
    }

    public int getImageId()
    {
        return imageId;
    }


    protected abstract void setImageId(int id);

}
