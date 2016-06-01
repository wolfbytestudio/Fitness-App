package com.wolfbytestudio.fitness.workout;

import android.util.Log;

import com.google.gson.Gson;
import com.wolfbytestudio.fitness.exercise.Difficulty;
import com.wolfbytestudio.fitness.exercise.Equipment;
import com.wolfbytestudio.fitness.exercise.MuscleGroup;
import com.wolfbytestudio.fitness.util.Utility;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Workout object contains everything for a workout
 *
 * @author Zack Davidson <<zackdavidson2014@outlook.com>>
 * @author Wolfbyte Studio <<Wolfbytestudio@gmail.com>>
 */
public class Workout implements Cloneable
{

    /**
     * All the workout rounds that the workout contains
     */
    private List<WorkoutRound> rounds = new ArrayList<>();

    /**
     * The workout name
     */
    private String workoutName;

    /**
     * The workout type
     */
    private WorkoutType type;

    /**
     * The difficulty of the workout
     */
    private Difficulty difficulty;

    /**
     * The amount of times you have complete the workout
     */
    private int timesComplete;

    /**
     * The fastest time you took to complete the workout
     */
    private long bestTime;

    public List<WorkoutRound> getRounds()  { return rounds; }
    public void setRounds(List<WorkoutRound> rounds)
    {
        this.rounds = rounds;
    }

    public Difficulty getDifficulty()
    {
        return difficulty;
    }
    public void setDifficulty(Difficulty difficulty)
    {
        this.difficulty = difficulty;
    }

    public String getWorkoutName() { return workoutName; }
    public void setWorkoutName(String workoutName)
    {
        this.workoutName = workoutName;
    }

    public WorkoutType getType()
    {
        return type;
    }
    public void setType(WorkoutType type)
    {
        this.type = type;
    }

    public long getBestTime()
    {
        return bestTime;
    }
    public void setBestTime(long time)
    {
        this.bestTime = time;
    }

    public void complete()
    {
        timesComplete++;
    }
    public int getTimesComplete()
    {
        return timesComplete;
    }
    public void setTimesComplete(int timesComplete)
    {
        this.timesComplete = timesComplete;
    }


    @Override
    public Workout clone() throws CloneNotSupportedException
    {
        return (Workout) super.clone();
    }

    /**
     * Clones a workout and renames it.
     *
     * @param newName - the new workout name
     * @return - The workout object
     * @throws CloneNotSupportedException
     */
    public Object clone(String newName) throws CloneNotSupportedException
    {
        Workout cloned = (Workout) super.clone();
        cloned.setWorkoutName(newName);

        return cloned;
    }

    /**
     * Gets all muscle groups for the workout
     *
     * @return - a list of the muscle groups
     */
    public List<MuscleGroup> getMuscleGroups()
    {
        List<MuscleGroup> ls = new ArrayList<>();

        for (WorkoutRound round : rounds)
        {
            for (ExerciseRep set : round.getSets())
            {
                for (MuscleGroup muscle : set.getExercise().getMuscles())
                {
                    if (!ls.contains(muscle))
                    {
                        ls.add(muscle);
                    }
                }
            }
        }

        return ls;
    }

    /**
     * Formats a muscle group and return it as a string
     * @param list - the list of muscles
     * @return - the formatted muscle group
     */
    public String formatMuscleGroups(List<MuscleGroup> list)
    {
        String out = "";
        int counter = 0;
        for (MuscleGroup m : list)
        {
            counter++;
            if (counter == list.size())
            {
                out += MuscleGroup.format(m);
            } else
            {
                out += MuscleGroup.format(m) + ", ";
            }

        }

        return out;
    }

    /**
     * Gets the amount of calories the workout burns
     *
     * @return - the amount of calories the workout burns
     */
    public int getCalories()
    {
        int counter = 0;
        for (WorkoutRound round : rounds)
        {
            for (ExerciseRep set : round.getSets())
            {
                counter += (set.getExercise().getCaloriesBurned() * set.getAmount());
            }
        }
        return counter;
    }

    /**
     * Gets all equipment required to do a workout
     * @return
     */
    public List<Equipment> getEquipment()
    {
        List<Equipment> ls = new ArrayList<>();

        for (WorkoutRound round : rounds)
        {
            for (ExerciseRep set : round.getSets())
            {
                for (Equipment eq : set.getExercise().getEquipment())
                {
                    if (!ls.contains(eq))
                    {
                        ls.add(eq);
                    }
                }
            }
        }
        return ls;
    }

    public void addRound(WorkoutRound round)
    {
        rounds.add(round);
    }
    public void removeRound(WorkoutRound round)
    {
        rounds.remove(round);
    }
    public WorkoutRound getRound(int index)
    {
        return rounds.get(index);
    }

    /**
     * Gets the amount of experience the workout will give
     *
     * @return - The amount of experience
     */
    public int getExperience()
    {
        int counter = 0;
        for (WorkoutRound round : rounds)
        {
            for (ExerciseRep set : round.getSets())
            {
                counter += (set.getExercise().getPoints() * set.getAmount());
            }
        }

        return counter;
    }

    /**
     * Prints off the workout, used as a testing method
     */
    public void print()
    {
        Log.d("zz1", "Workout Name: " + workoutName);
        Log.d("zz1", "Workout Difficulty: " + difficulty);
        Log.d("zz1", "Workout Type: " + type);
        Log.d("zz1", "Rounds: " + rounds.size());
        Log.d("zz1", "Times Complete: " + timesComplete);
        Log.d("zz1", "Muscle Groups: " + formatMuscleGroups(getMuscleGroups()));

        if (bestTime != 0)
            Log.d("zz1", "Best Time: " + Utility.getFormattedDate(bestTime));

        for (int i = 0; i < rounds.size(); i++)
        {
            Log.d("zz1", "Round: " + (i + 1));
            Log.d("zz1", rounds.get(i).toString());
        }
    }

    /**
     * Gson object used for getting a workouts
     * json string and loading a workout with a json string
     */
    private static final Gson GSON = new Gson();

    /**
     * Converts the workout to a json string
     *
     * @return
     */
    public String toJson()
    {
        return GSON.toJson(this);
    }

    /**
     * Loads a workout by json string
     *
     * @param json - the json string we are passing in
     * @return
     */
    public static Workout fromJson(String json)
    {
        return GSON.fromJson(json, Workout.class);
    }

}
