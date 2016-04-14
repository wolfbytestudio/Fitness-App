package com.wolfbytestudio.fitness.generator;

import com.wolfbytestudio.fitness.Constants;

import java.util.UUID;

/**
 * Created by Zack on 30/03/2016.
 */
public class UUIDGenerator
{


    public static String getRandomUUID(int length)
    {
        String seed = UUID.randomUUID().toString();
        return seed.substring(0, length).replace("-", "");
    }

}

