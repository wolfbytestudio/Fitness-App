package com.wolfbytestudio.fitness;

/**
 * Contains all constants
 *
 * @author Zack Davidson <<zackdavidson2014@outlook.com>>
 * @author Wolfbyte Studio <<Wolfbytestudio@gmail.com>>
 */
public final class Constants
{

    /**
     * ExceptionInInitializerError object
     * used in classes which shouldn't be initialized
     */
    public static final ExceptionInInitializerError CANNOT_INIT =
            new ExceptionInInitializerError("Cannot initialize this class");


    /**
     * Private constructor
     */
    private Constants() { throw CANNOT_INIT; }
}
