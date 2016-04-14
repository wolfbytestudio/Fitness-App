package com.wolfbytestudio.fitness.exercise;

import java.io.Serializable;

import com.wolfbytestudio.fitness.util.ProceduralGeneratedRandom;
import com.wolfbytestudio.fitness.util.Utility;

/**
 * 
 * @author Zack Davidson <<zackdavidson2014@outlook.com>>
 * @author Wolfbyte Studio <<Wolfbytestudio@gmail.com>>
 *
 */
public enum Difficulty implements Serializable
{

	EASY(1),
	MEDIUM(3),
	HARD(5),
	INSANE(8);
	
	private final int multiplier;
	
	private Difficulty(final int multiplier)
	{
		this.multiplier = multiplier;
	}

	public int getMultiplier()
	{
		return multiplier;
	}
	
	public static int count()
	{
		return values().length;
	}
	
	/**
	 * Gets a random from a procedural generated random
	 * @param r - the procedural generated random
	 * @return - a difficulty
	 */
	public static Difficulty getRandom(ProceduralGeneratedRandom r)
	{
		int random = r.getRandomInt(count());
		if(random == 4)
			random = 3;
		return values()[random];
	}
	
	/**
	 * Gets a random difficulty
	 * @return
	 */
	public static Difficulty getRandom()
	{
		return values()[Utility.getRandomIndex(count())];
	}

}
