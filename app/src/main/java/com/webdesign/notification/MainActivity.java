package com.webdesign.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;



public class MainActivity extends AppCompatActivity {

    NotificationCompat.Builder notification;
    private static final int uniqueID = 45612;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);


    }

    public void AmrsButtonClicked(View view) {

        // build the notification
        notification.setSmallIcon(R.drawable.ic_launcher);
        notification.setTicker("This is the ticker !!! ");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("here is the title");
        notification.setContentText("iam the body of ur notification");

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        // build notification and issues it
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID,notification.build());

    }
}