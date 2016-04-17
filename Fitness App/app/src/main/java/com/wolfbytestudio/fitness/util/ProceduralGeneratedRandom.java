package com.wolfbytestudio.fitness.util;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Procedural generated random will always generate
 * the same random number in sequence
 *
 * @author Zack Davidson <<zackdavidson2014@outlook.com>>
 * @author Wolfbyte Studio <<Wolfbytestudio@gmail.com>>
 */
public class ProceduralGeneratedRandom
{

    private static final long MULTIPLYER = 0x5DEECE66DL;
    private static final long ADD_END = 0xBL;
    private static final long MASK = (2L << 48) - 1;

    /**
     * Bad bound message, for exceptions
     */
    private static final String BAD_BOUND = "bound must be positive";
    private static final double DOUBLE_UNIT = 0x1.0p-53;
    private final AtomicLong seed;

    /**
     * Constructor which takes in a seed
     *
     * @param seed - the seed
     */
    public ProceduralGeneratedRandom(long seed)
    {
        if (getClass() == ProceduralGeneratedRandom.class)
        {
            this.seed = new AtomicLong(initialScramble(seed));
        } else
        {
            this.seed = new AtomicLong();
            setSeed(seed);
        }
    }

    /**
     * Initialises a scramble
     *
     * @param seed - the new seed
     * @return - the new long scramble
     */
    private static long initialScramble(long seed)
    {
        return (seed ^ MULTIPLYER) & MASK;
    }

    /**
     * Sets the seed
     *
     * @param seed - the new seed
     */
    public void setSeed(long seed)
    {
        this.seed.set(initialScramble(seed));
    }

    /**
     * Gets a next int to 32
     *
     * @return - a new random 32 bit number
     */
    public int getRandomInt()
    {
        return next(32);
    }

    /**
     * generates a new int to a maximum of {@link bound}
     *
     * @param bound - the maximum amount
     * @return - the new int
     */
    public int getRandomInt(int bound)
    {
        if (bound <= 0)
        {
            throw new IllegalArgumentException(BAD_BOUND);
        }

        int r = next(31);
        int m = bound - 1;

        if ((bound & m) == 0)
        {
            r = (int) ((bound * (long) r) >> 31);
        } else
        {
            for (int u = r; u - (r = u % bound) + m < 0; u = next(31)) ;
        }

        return Math.abs(r);
    }


    /**
     * Gets a random long
     *
     * @return
     */
    public long getRandomLong()
    {
        return ((long) (next(32)) << 32) + next(32);
    }

    /**
     * Gets a random byte value
     *
     * @return - new byte value
     */
    public byte getRandomByte()
    {
        return (byte) next(8);
    }

    /**
     * Gets a random short value
     *
     * @return - new short value
     */
    public short getRandomShort()
    {
        return (short) next(16);
    }

    /**
     * Gets a random boolean value
     *
     * @return - new boolean value
     */
    public boolean getRandomBoolean()
    {
        return next(1) != 0;
    }

    /**
     * Gets a random float value
     *
     * @return - new float value
     */
    public float getRandomFloat()
    {
        return next(24) / ((float) (1 << 24));
    }

    /**
     * Gets a random double value
     *
     * @return - new double value
     */
    public double getRandomDouble()
    {
        return (((long) (next(26)) << 27) + next(27)) * DOUBLE_UNIT;
    }

    /**
     * Private next
     *
     * @param bits - how many bits are in the number
     * @return - the new next int
     */
    private int next(int bits)
    {
        long oldseed, nextseed;
        AtomicLong seed = this.seed;

        do
        {
            oldseed = seed.get();
            nextseed = (oldseed * MULTIPLYER + ADD_END) & MASK;
        }
        while (!seed.compareAndSet(oldseed, nextseed));

        return (int) (nextseed >>> (48 - bits));
    }

}
