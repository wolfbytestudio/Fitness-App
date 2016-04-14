package com.wolfbytestudio.fitness;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.wolfbytestudio.fitness.generator.GeneratedWorkout;
import com.wolfbytestudio.fitness.generator.UUIDGenerator;
import com.wolfbytestudio.fitness.ui.adaptor.WorkoutRoundAdapter;
import com.wolfbytestudio.fitness.util.Utility;

import org.w3c.dom.Text;

import java.util.UUID;

public class MainActivity extends Activity
{

    /**
     * Custom view adapter for custom view controls
     */
    private WorkoutRoundAdapter customListViewAdapter;

    private ListView lstRounds;
    private TextView lblName;
    private TextView lblDifficulty;
    private TextView lblType;
    private TextView lblRounds;
    private TextView lblMuscles;
    private Button btnGenerate;
    private EditText txtSeed;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Utility.workout = GeneratedWorkout.generateWorkout("Zack");


        lblName = (TextView) findViewById(R.id.lblWorkoutName);
        lblDifficulty = (TextView) findViewById(R.id.lblDifficulty);
        lblType = (TextView) findViewById(R.id.lblWorkoutType);
        lblRounds = (TextView) findViewById(R.id.lblRounds);
        lblMuscles = (TextView) findViewById(R.id.lblMuscleGroups);
        btnGenerate = (Button) findViewById(R.id.btnGenerate);
        txtSeed = (EditText) findViewById(R.id.txtSeed);


        lstRounds = (ListView) findViewById(R.id.lstRounds);
        updateDetails();
        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtSeed.getText().toString().equalsIgnoreCase("rnd"))
                {
                    setSeed(UUIDGenerator.getRandomUUID(6));
                }
                else
                {
                    updateSeed();
                }
            }
        });

        btnGenerate.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v)
            {
                setSeed(UUIDGenerator.getRandomUUID(6));
                return true;
            }
        });

        txtSeed.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (txtSeed.getText().toString().equalsIgnoreCase("rnd"))
                {
                    setSeed(UUIDGenerator.getRandomUUID(6));
                }

                return true;
            }
        });

        txtSeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (txtSeed.getText().toString().equalsIgnoreCase("rnd")) {
                    setSeed(UUIDGenerator.getRandomUUID(6));
                }
            }
        });

        customListViewAdapter = new WorkoutRoundAdapter(getApplicationContext(), this, Utility.workout);
        lstRounds.setAdapter(customListViewAdapter);
    }


    private void setSeed(String seed)
    {
        if(!txtSeed.getText().toString().equalsIgnoreCase("rnd"))
        {
            txtSeed.setText(seed);
        }

        Utility.workout = GeneratedWorkout.generateWorkout(seed);
        customListViewAdapter.notifyDataSetChanged();
        updateDetails();
    }

    private void updateSeed()
    {

        setSeed(txtSeed.getText().toString());
    }

    public void updateDetails()
    {
        lblName.setText("Name: " +Utility.workout.getWorkoutName());
        lblDifficulty.setText("Difficulty: " + Utility.workout.getDifficulty().name());
        lblType.setText("Experience: " + Utility.workout.getExperience());
        lblRounds.setText("Rounds: " + Utility.workout.getRounds().size());
        lblMuscles.setText("Muscles: " + Utility.workout.formatMuscleGroups(Utility.workout.getMuscleGroups()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
