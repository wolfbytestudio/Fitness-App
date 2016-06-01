package com.wolfbytestudio.fitness;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.wolfbytestudio.fitness.cache.Exercises;
import com.wolfbytestudio.fitness.workout.generator.GeneratedWorkout;
import com.wolfbytestudio.fitness.ui.adaptor.WorkoutRoundAdapter;
import com.wolfbytestudio.fitness.util.Utility;
import com.wolfbytestudio.fitness.workout.Workout;

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

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView imageView = (ImageView) findViewById(R.id.backgroundImage);

        imageView.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.background, 100, 100));

        Exercises.load(this);

        Utility.workout = GeneratedWorkout.generateWorkout("Zack");

        String json = Utility.workout.toJson();

        Workout newWorkout = Workout.fromJson(json);

        newWorkout.setWorkoutName("Zack");

        Log.d("abcd", newWorkout.toJson());


        lblName = (TextView) findViewById(R.id.lblWorkoutName);
        lblDifficulty = (TextView) findViewById(R.id.lblDifficulty);
        lblType = (TextView) findViewById(R.id.lblWorkoutType);
        lblRounds = (TextView) findViewById(R.id.lblRounds);
        lblMuscles = (TextView) findViewById(R.id.lblMuscleGroups);
        btnGenerate = (Button) findViewById(R.id.btnGenerate);
        txtSeed = (EditText) findViewById(R.id.txtSeed);


        lstRounds = (ListView) findViewById(R.id.lstRounds);

        btnGenerate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (txtSeed.getText().toString().equalsIgnoreCase("rnd"))
                {
                    setSeed(Utility.getRandomUUID(6));
                } else
                {
                    updateSeed();
                }
            }
        });

        btnGenerate.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View v)
            {
                setSeed(Utility.getRandomUUID(6));
                return true;
            }
        });

        txtSeed.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View v)
            {
                if (txtSeed.getText().toString().equalsIgnoreCase("rnd"))
                {
                    setSeed(Utility.getRandomUUID(6));
                }

                return true;
            }
        });

        txtSeed.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (txtSeed.getText().toString().equalsIgnoreCase("rnd"))
                {
                    setSeed(Utility.getRandomUUID(6));
                }
            }
        });

        updateDetails();

        customListViewAdapter = new WorkoutRoundAdapter(getApplicationContext(), this, Utility.workout);
        lstRounds.setAdapter(customListViewAdapter);
    }


    private void setSeed(String seed)
    {
        if (!txtSeed.getText().toString().equalsIgnoreCase("rnd"))
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
        lblName.setText("Name: " + Utility.workout.getWorkoutName());
        lblDifficulty.setText("Difficulty: " + Utility.workout.getDifficulty().name());
        lblType.setText("" + Utility.workout.getExperience());
        lblRounds.setText("" + Utility.workout.getCalories());
        lblMuscles.setText("Muscles: " + Utility.workout.formatMuscleGroups(Utility.workout.getMuscleGroups()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
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
