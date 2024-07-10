package com.myfirstapp.ex_3_sevicebroadcast

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.bluetooth.BluetoothAdapter
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.ActivityCompat
import android.app.Service
import android.os.IBinder


class BluetoothStatusReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action === BluetoothAdapter.ACTION_STATE_CHANGED) {
            val state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.STATE_OFF)
            val status: String
            status = when (state) {
                BluetoothAdapter.STATE_OFF -> "Off"
                BluetoothAdapter.STATE_TURNING_ON -> "Turning On"
                BluetoothAdapter.STATE_ON -> "On"
                BluetoothAdapter.STATE_TURNING_OFF -> "Turning Off"
                else -> "Unknown"
            }
            Log.i("Broadcast Receiver", "Bluetooth status: $status")
            //updateForegroundServiceNotification(context, status);
        }
    }
}

   /* private fun updateForegroundServiceNotification(context:Context, status:String) {
        // Create a NotificationChannel (for Android Oreo and above)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel(context);
        }
        *//*val builder: NotificationCompat.Builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setContentTitle("Bluetooth Status")
            .setContentText("Bluetooth is now $status")
            //.setSmallIcon(R.drawable.ic_bluetooth) // Replace with your icon resource
            .setOngoing(true) // Mark as ongoing notification for a foreground service
            .setPriority(NotificationCompat.PRIORITY_LOW) // Set notification priority
*//*

        // Add an intent to open your app on notification tap (optional)

        // Add an intent to open your app on notification tap (optional)
        val notificationIntent =
            Intent(context, MainActivity::class.java) // Replace with your activity class

        val pendingIntent =
            PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_IMMUTABLE)
        builder.setContentIntent(pendingIntent)

        // Build and send the notification using NotificationManagerCompat

        // Build and send the notification using NotificationManagerCompat
        val notificationManager = NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, builder.build())
        notificationManager.notify(NOTIFICATION_ID, builder.build())

        Intent(applicationContext, ForegroundService::class.java).also {
            it.action = ForegroundService.Actions.START.toString()
            startService(it)
        }
        Intent(applicationContext, ForegroundService::class.java).also {
            it.action = ForegroundService.Actions.START.toString()
            startService(it)
        }

    }

    private fun createNotificationChannel(context: Context) {
        val channel = NotificationChannel(
            CHANNEL_ID,
            "Bluetooth Status Notifications", NotificationManager.IMPORTANCE_DEFAULT
        )
        channel.description = "Notifications for Bluetooth status changes"
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}

*/