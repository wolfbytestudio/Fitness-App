package com.wolfbytestudio.fitness.workout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zack Davidson <<zackdavidson2014@outlook.com>>
 * @author Wolfbyte Studio <<Wolfbytestudio@gmail.com>>
 */
public class WorkoutRound implements Serializable
{

    private static final long serialVersionUID = -7831129396127358218L;
    private List<ExerciseRep> sets = new ArrayList<>();

    public WorkoutRound(ExerciseRep[] sets)
    {
        this.sets = Arrays.asList(sets);
    }

    public WorkoutRound()
    {
    }

    public WorkoutRound(List<ExerciseRep> sets)
    {
        this.sets = sets;
    }

    public List<ExerciseRep> getSets()
    {
        return sets;
    }

    public void addSet(ExerciseRep set)
    {
        sets.add(set);
    }

    public void removeSet(ExerciseRep set)
    {
        sets.remove(set);
    }

    public void removeLastRest()
    {
        removeSet(sets.size() - 1);
    }

    public void removeSet(int index)
    {
        sets.remove(index);
    }

    public ExerciseRep getSet(int index)
    {
        return sets.get(index);
    }

    @Override
    public String toString()
    {
        String strOut = "";
        for (ExerciseRep set : sets)
        {
            String type = set.getExercise().isTimed() == false ? "Reps" : "Seconds";
            strOut += "Exercise: " + set.getExercise().getName() + ", " + type + ": " + set.getAmount() + "\n";
        }
        return strOut;
    }

}

