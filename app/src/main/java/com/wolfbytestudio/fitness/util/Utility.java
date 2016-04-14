package com.wolfbytestudio.fitness.util;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.wolfbytestudio.fitness.workout.Workout;

import java.util.Date;
import java.util.Random;

/**
 * Contains utility methods
 *
 * @author Zack Davidson <<zackdavidson2014@outlook.com>>
 * @author Wolfbyte Studio <<Wolfbytestudio@gmail.com>>
 */
public class Utility
{

    /**
     * Random object
     */
    private static final Random RND = new Random();

    /**
     * The current workout object, place holder
     */
    public static Workout workout = null;

    /**
     * Bad value exception
     */
    private static final IllegalArgumentException BAD_VALUE =
            new IllegalArgumentException("Value must be positive");

    /**
     * Gets a random index with a maximum
     *
     * @param max - the max index
     * @return - a random value between 0 and max
     */
    public static int getRandomIndex(int max)
    {
        if (max < 1) throw BAD_VALUE;

        return RND.nextInt(max);
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
     * @param date - the date to format
     * @return - String formatted time
     */
    public static String getFormattedDate(Date date)
    {
        String outPut;
        outPut = date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
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
