package com.wolfbytestudio.fitness.generator;

import com.wolfbytestudio.fitness.cache.Cache;
import com.wolfbytestudio.fitness.cache.Exercises;
import com.wolfbytestudio.fitness.exercise.Difficulty;
import com.wolfbytestudio.fitness.exercise.Exercise;
import com.wolfbytestudio.fitness.util.ProceduralGeneratedRandom;
import com.wolfbytestudio.fitness.workout.ExerciseRep;
import com.wolfbytestudio.fitness.workout.Workout;
import com.wolfbytestudio.fitness.workout.WorkoutRound;
import com.wolfbytestudio.fitness.workout.WorkoutType;

import java.util.ArrayList;
import java.util.List;

/**
 * Procedurally generated workout class
 */
public class GeneratedWorkout
{

    private static String name;

    /**
     * Private constructor, cannot initialize this class
     *
     * @throws ExceptionInInitializerError to stop initializing this class
     */
    private GeneratedWorkout()
    {
        throw new ExceptionInInitializerError("Cannot initialize this class");
    }

    /**
     * Generates a workout based on a seed's hashcode
     *
     * @param seed - the seed in a string format
     * @return - see generateWorkout() return type
     */
    public static Workout generateWorkout(String seed)
    {
        name = seed;
        return generateWorkout(seed.hashCode());
    }

    /**
     * Generates a workout based on a @seed
     *
     * @param seed - the seed
     * @return - the generated workout
     */
    public static Workout generateWorkout(int seed)
    {
        Workout workout = new Workout();

        workout.setWorkoutName(name);
        ProceduralGeneratedRandom rnd = new ProceduralGeneratedRandom(seed);

        Difficulty dif = Difficulty.getRandom(rnd);
        workout.setDifficulty(dif);

        int rounds = rnd.getRandomBoolean() == true ? dif.getMultiplier() : dif.getMultiplier() + 2;

        WorkoutType wt = WorkoutType.getRandom(rnd);
        workout.setType(wt);

        List<Exercise> list = generateExerciseList(rnd);

        WorkoutRound round = generateWorkoutRound(dif, rnd, list);


        round.addSet(new ExerciseRep(dif.getMultiplier() * 10, Exercises.get("Rest").getName()));

        for (int i = 0; i < rounds; i++)
        {
            workout.addRound(round);
            System.out.println(round.toString());
        }


        return workout;
    }

    /**
     * Generated the amount of work out rounds based of difficulty
     *
     * @param dif  - The Difficulty of the workout
     * @param rnd  - The random number Generator to generate the same result based on seed
     * @param list - The list of exercises
     * @return - A Workout Round object
     */
    private static WorkoutRound generateWorkoutRound(Difficulty dif, ProceduralGeneratedRandom rnd, List<Exercise> list)
    {
        WorkoutRound round = new WorkoutRound();

        for (Exercise exersice : list)
        {
            round.addSet(new ExerciseRep(generateAmount(exersice, dif, rnd), exersice.getName()));
        }

        return round;
    }

    /**
     * Generates the amount of exercise reps/seconds to do
     *
     * @param ex  - The exercise itself
     * @param dif - The Difficulty of the workout
     * @param rnd - The random number Generator to generate the same result based on seed
     * @return - The workout rep/seconds amount
     */
    private static int generateAmount(Exercise ex, Difficulty dif, ProceduralGeneratedRandom rnd)
    {
        int amount;

        int multiplier = rnd.getRandomInt(5) + 1;

        amount = (((dif.getMultiplier() * 2) * multiplier) / 5) * 5;

        if (amount == 0)
        {
            amount = 5;
        }

        return Math.abs(amount);
    }

    /**
     * Generates a list of exercises to be placed
     * into workout rounds. This will be the same
     * for every workout round
     *
     * @param rnd - The random number generator
     * @return - A collection of exercises
     */
    private static List<Exercise> generateExerciseList(ProceduralGeneratedRandom rnd)
    {
        int amount = rnd.getRandomBoolean() == true ? 3 : 5;

        List<Exercise> ls = new ArrayList<>();
        for (int i = 0; i < amount; i++)
        {
            Exercise current = Cache.getCache().getExercises().getRandom(rnd);

            while (ls.contains(current))
            {
                current = Cache.getCache().getExercises().getRandom(rnd);
            }

            ls.add(current);
        }

        return ls;
    }


}
