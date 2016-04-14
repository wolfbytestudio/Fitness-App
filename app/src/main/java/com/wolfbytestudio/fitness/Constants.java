package com.wolfbytestudio.fitness;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.wolfbytestudio.fitness.workout.*;

/**
 * Created by Zack on 30/03/2016.
 */
public class Constants
{

    /**
     * The current workout object, place holder
     */
    public static Workout workout = null;

    /**
     * Sets the height of a list view determined by the
     * amount of items and their height
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
