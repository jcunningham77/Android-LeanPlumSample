package com.example.leanplumsampleproject.leanplumsampleproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by 00128395 on 12/21/16.
 */

public class LeanPlumBroadcastReciever extends BroadcastReceiver {

    private static final String TAG = "LeanPlumBroadcastReciev";

    @Override
    public void onReceive(Context context, Intent intent) {

    //TODO - manually compensate for tracking the open -

    //TODO - forward the 'URL to Open' to a native handle to directly open the Third Activity

    Bundle leanPlumBundle = intent.getExtras();

    Log.i(TAG, "onReceive: URL to open" + leanPlumBundle.getString("_lpx"));
        try {
            JSONObject urlToOpen = new JSONObject(leanPlumBundle.getString("_lpx"));
            Log.i(TAG, "onReceive: urlToOpen" + urlToOpen.getString("URL"));
            Intent deepLinkIntent = new Intent(Intent.ACTION_VIEW);
            deepLinkIntent.setData(Uri.parse(
                    urlToOpen.getString("URL")));
            deepLinkIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(deepLinkIntent);

        } catch (JSONException e) {
            e.printStackTrace();
        }



        //TODO - open the correct Activity based on this open



    }
}
