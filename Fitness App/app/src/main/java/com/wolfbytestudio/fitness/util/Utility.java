package com.wolfbytestudio.fitness.util;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.wolfbytestudio.fitness.Constants;
import com.wolfbytestudio.fitness.workout.Workout;

import java.util.Random;
import java.util.UUID;

/**
 * This class contains utility methods
 *
 * @author Zack Davidson <<zackdavidson2014@outlook.com>>
 * @author Wolfbyte Studio <<Wolfbytestudio@gmail.com>>
 */
public class Utility
{

    /**
     * Random object to generate random numbers
     */
    private static final Random RANDOM = new Random();

    /**
     * Bad value exception
     */
    private static final IllegalArgumentException BAD_VALUE =
            new IllegalArgumentException("Value must be positive");

    /**
     * The current workout object, place holder
     */
    public static Workout workout;

    /**
     * Private Utility class
     */
    private Utility()
    {
        throw Constants.CANNOT_INIT;
    }

    /**
     * Gets a random index with a maximum
     *
     * @param max - the max index
     * @return - a random value between 0 and max
     */
    public static int getRandomIndex(int max)
    {
        if (max < 1) throw BAD_VALUE;

        return RANDOM.nextInt(max);
    }

    /**
     * Gets a random uuid with a specific length and
     * removes all dashes (-) in the uuid
     *
     * @param length - the length of the uuid
     * @return - the new uuid
     */
    public static String getRandomUUID(int length)
    {
        String seed = UUID.randomUUID().toString();
        return seed.substring(0, length).replace("-", "");
    }

    /**
     * Formats a string value to capitalize the first letter
     *
     * @param upper - The string
     * @return - the new formatted string
     */
    public static String format(String upper)
    {
        char firstLetter = Character.toUpperCase(upper.charAt(0));
        return firstLetter + upper.substring(1).replace("_", " ").toLowerCase();
    }

    /**
     * Formats the date, redundant code
     *
     * @param time - the date to format
     * @return - String formatted time
     */
    public static String getFormattedDate(long time)
    {
        String outPut = "";
        // TODO: 18/04/2016 - format time to hh:mm:ss
        return outPut;
    }

    /**
     * Sets the height of a list view determined by the
     * amount of items and their height
     *
     * @param listView - The list view to be changed
     */
    public static void setListViewHeightBasedOnChildren(ListView listView)
    {
        ListAdapter listAdapter = listView.getAdapter();

        if (listAdapter == null)
        {
            return;
        }

        int totalHeight = 0;

        for (int i = 0; i < listAdapter.getCount(); i++)
        {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }

}
