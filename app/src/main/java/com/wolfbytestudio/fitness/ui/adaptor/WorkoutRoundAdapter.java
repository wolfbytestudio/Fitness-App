package com.wolfbytestudio.fitness.ui.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.wolfbytestudio.fitness.MainActivity;
import com.wolfbytestudio.fitness.R;
import com.wolfbytestudio.fitness.util.Utility;
import com.wolfbytestudio.fitness.workout.Workout;
import com.wolfbytestudio.fitness.workout.WorkoutRound;

/**
 * Created by Zack on 30/03/2016.
 */
public class WorkoutRoundAdapter extends BaseAdapter
{

    private static LayoutInflater inflater = null;
    private MainActivity owner;
    private ExerciseAdapter exerciseAdapter;

    public WorkoutRoundAdapter(Context context, MainActivity owner, Workout workout)
    {
        this.owner = owner;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount()
    {
        return Utility.workout.getRounds().size();
    }

    @Override
    public Object getItem(int position)
    {
        return position;
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = convertView;

        if (convertView == null)
        {
            view = inflater.inflate(R.layout.workout_round, null);
        }


        WorkoutRound workoutRound = Utility.workout.getRound(position);

        TextView lblRound = (TextView) view.findViewById(R.id.lblRound);
        lblRound.setText("Round " + (position + 1) + " out of " + (Utility.workout.getRounds().size()));

        final ListView lstExercise = (ListView) view.findViewById(R.id.lstWorkoutComponents);

        exerciseAdapter = new ExerciseAdapter(workoutRound, owner, inflater.getContext());
        lstExercise.setAdapter(exerciseAdapter);

        Utility.setListViewHeightBasedOnChildren(lstExercise);

        return view;
    }


}
