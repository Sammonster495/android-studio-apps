package com.example.progressbar;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        CountAsyncTask countAsyncTask = new CountAsyncTask();
        countAsyncTask.execute();
    }

    private class CountAsyncTask extends AsyncTask<Void, Integer, Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setMax(1000);
            progressBar.setProgress(0);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = 1; i <= 1000; i++){
                publishProgress(i);
                try {
                    Thread.sleep(10);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
        }
    }
}