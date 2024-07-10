package com.myfirstapp.ex_3_sevicebroadcast

import android.bluetooth.BluetoothAdapter
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log


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
        }
    }
}

