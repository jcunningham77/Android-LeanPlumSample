package com.example.leanplumsampleproject.leanplumsampleproject;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import com.leanplum.Leanplum;
import com.leanplum.LeanplumActivityHelper;
import com.leanplum.LeanplumPushNotificationCustomizer;
import com.leanplum.LeanplumPushService;

/**
 * Created by 00128395 on 12/20/16.
 */

public class BaseApplication extends Application {

    private static final String TAG = "BaseApplication";



    @Override
    public void onCreate() {
        super.onCreate();
        long start = System.currentTimeMillis();
        Leanplum.enableVerboseLoggingInDevelopmentMode();
        Leanplum.setApplicationContext(this);
//        Parser.parseVariables(this);
//        Parser.parseVariablesForClasses(HomePage.class, ProductDetailFragment.class);
        LeanplumActivityHelper.enableLifecycleCallbacks(this);
        LeanplumPushService.setGcmSenderId(BuildConfig.LP_GSM_SENDER_ID);
        LeanplumPushService.setCustomizer(new LeanplumPushNotificationCustomizer() {
            @Override
            public void customize(android.support.v4.app.NotificationCompat.Builder builder, Bundle bundle) {
                builder.setColor(getResources().getColor(R.color.colorPrimary));
                builder.setSmallIcon(R.drawable.ic_stat_notify_q);


//                //take all the data  from the LeanPlum SDK from the Bundle - take pieces of that data that is important for us
//                Log.i(TAG, "customize: " + bundle.toString());
//                Intent leanPlumDataIntent = new Intent(BaseApplication.this, LeanPlumBroadcastReciever.class);
//                leanPlumDataIntent.putExtra("lp_version",bundle.getString("lp_version"));
////                leanPlumDataIntent.putExtra("google.sent_time",bundle.getString("google.sent_time"));
////                leanPlumDataIntent.putExtra("lp_message",bundle.getString("lp_message"));
////                leanPlumDataIntent.putExtra("lp_messageId",bundle.getString("lp_messageId"));
////                leanPlumDataIntent.putExtra("_lpm",bundle.getString("_lpm"));
//                leanPlumDataIntent.putExtra("_lpx",bundle.getString("_lpx"));
////                leanPlumDataIntent.putExtra("google.message_id",bundle.getString("google.message_id"));
////                leanPlumDataIntent.putExtra("collapse_key",bundle.getString("collapse_key"));
//                //todo - see if the values for requestCode and Flags are ok
//                PendingIntent pendingIntent = PendingIntent.getBroadcast(BaseApplication.this,1,leanPlumDataIntent,PendingIntent.FLAG_UPDATE_CURRENT);
//
//                builder.setContentIntent(pendingIntent);
            }
        });
        if (BuildConfig.DEBUG) {
            Leanplum.setAppIdForDevelopmentMode(BuildConfig.LP_APP_ID, BuildConfig.LP_DEV_KEY);
        } else {
            Leanplum.setAppIdForProductionMode(BuildConfig.LP_APP_ID, BuildConfig.LP_PROD_KEY);
        }

        long duration = System.currentTimeMillis() - start;

        Log.i(TAG, "onCreate: Leanplum raw init took " + duration + " ms");


        Leanplum.start(this);
        duration = System.currentTimeMillis() - start;


        Log.i(TAG, "onCreate: full init took " + duration + " ms");

    }
}
