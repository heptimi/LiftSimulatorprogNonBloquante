package fr.wcs.liftsimulator_prognonbloquante;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import java.lang.Object;
import android.os.SystemClock;

public class MainActivity extends AppCompatActivity {

    private boolean isLiftMoving = false;
    private int currentFloor = 0;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(9);
        progressBar.setProgress(0);

    }

    private void goToFloor(int floor) {
        if (!isLiftMoving && floor != currentFloor) {
            moveNextFloor(floor);
            isLiftMoving = false;
        }
    }

    private class MoveLift extends AsyncTask<Integer, Void, Integer>{



     //   protected void onPreExecute(Integer floor) {
            // Runs on the UI thread before doInBackground
            // Good for toggling visibility of a progress indicator

          //  TextView floorCount = (TextView) findViewById(R.id.floor_count);
           // floorCount.setText(String.valueOf(currentFloor));
     //   }

        protected Integer doInBackground(Integer ... param) {
            // Some long-running task like downloading an image.
            try {
                SystemClock.sleep(3000);
            } catch (Exception e) {

            }
            return param[0];  //WTF
        }

       //protected void onProgressUpdate(Progress... values) {
            // Executes whenever publishProgress is called from doInBackground
            // Used to update the progress indicator

        //}

        protected void onPostExecute(Integer floor) {
            // This method is executed in the UIThread
            // with access to the result of the long running task
            currentFloor = (floor > currentFloor) ? currentFloor + 1 : currentFloor - 1;
            TextView floorCount = (TextView) findViewById(R.id.floor_count);
            floorCount.setText(String.valueOf(currentFloor));

            moveNextFloor(floor);
            // Hide the progress bar
          //  progressBar.setVisibility(ProgressBar.INVISIBLE);
        }

    }



    private void moveNextFloor(int floor) {
        if (floor != currentFloor) {
            isLiftMoving = true;
           // waitForIt();
           // currentFloor = (floor > currentFloor) ? currentFloor + 1 : currentFloor - 1;
           // TextView floorCount = (TextView) findViewById(R.id.floor_count);
           // floorCount.setText(String.valueOf(currentFloor));
            //moveNextFloor(floor);
            progressBar.setProgress(currentFloor);
            new MoveLift().execute(floor);

        }
        else{
            isLiftMoving = false;

        }
    }

   // private void waitForIt() {
    //    // TODO : à compléter
   // SystemClock.sleep(3000);
   // }

    public void onClickbutton1(View view){goToFloor(1);}

    public void onClickbutton2(View view){goToFloor(2);}

    public void onClickbutton3(View view){goToFloor(3);}

    public void onClickbutton4(View view){goToFloor(4);}

    public void onClickbutton5(View view){goToFloor(5);}

    public void onClickbutton6(View view){goToFloor(6);}

    public void onClickbutton7(View view){goToFloor(7);}

    public void onClickbutton8(View view){goToFloor(8);}

    public void onClickbutton9(View view){goToFloor(9);}

    public void onClickbutton0(View view){goToFloor(0);}
}
