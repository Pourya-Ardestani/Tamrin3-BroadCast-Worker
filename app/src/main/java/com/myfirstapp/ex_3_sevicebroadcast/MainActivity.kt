package com.myfirstapp.ex_3_sevicebroadcast

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.myfirstapp.ex_3_sevicebroadcast.ui.theme.EX3SeviceBroadCastTheme

import android.content.IntentFilter
import android.bluetooth.BluetoothAdapter


class MainActivity : ComponentActivity() {

    private val bluetoothStatusReceiver = BluetoothStatusReceiver() // Use BluetoothStatusReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerReceiver(bluetoothStatusReceiver, IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED))
        setContent {
            EX3SeviceBroadCastTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Text(" Bluetooth Status Broadcast Receiver ")
                }
            }
        }
    }
    override fun onDestroy()
    {
        super.onDestroy()
        unregisterReceiver(bluetoothStatusReceiver)
    }
}


