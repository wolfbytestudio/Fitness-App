package com.wolfbytestudio.fitness.ui.adaptor;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wolfbytestudio.fitness.MainActivity;
import com.wolfbytestudio.fitness.R;
import com.wolfbytestudio.fitness.util.Utility;
import com.wolfbytestudio.fitness.workout.ExerciseRep;
import com.wolfbytestudio.fitness.workout.WorkoutRound;

/**
 * Created by Zack on 30/03/2016.
 */
public class ExerciseAdapter extends BaseAdapter
{

    private static LayoutInflater inflater = null;
    private WorkoutRound round;
    private MainActivity owner;

    public ExerciseAdapter(WorkoutRound round, MainActivity owner, Context context)
    {
        this.owner = owner;
        this.round = round;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount()
    {
        return round.getSets().size();
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
            view = inflater.inflate(R.layout.exercise, null);
        }


        ExerciseRep exercise = round.getSet(position);

        TextView lblName = (TextView) view.findViewById(R.id.lblExerciseName);
        lblName.setText(exercise.getFormattedAmount() + " " + exercise.getExercise().getName());

        Utility.workout.print();

        return view;
    }
}
