package com.example.leanplumsampleproject.leanplumsampleproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by 00128395 on 12/20/16.
 */

public class SecondActivity extends Activity {

    private static final String TAG = "SecondActivity";

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        Log.i(TAG, "onCreate: ");



    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
        Intent thirdActivityIntent = new Intent(this, ThirdActivity.class);
        startActivity(thirdActivityIntent);
    }
}
