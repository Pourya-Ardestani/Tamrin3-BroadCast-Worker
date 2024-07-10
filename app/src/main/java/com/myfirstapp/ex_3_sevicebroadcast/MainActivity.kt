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

import android.os.Build
import android.content.IntentFilter
import android.bluetooth.BluetoothAdapter
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Alignment
import androidx.core.app.ActivityCompat
import android.Manifest


class MainActivity : ComponentActivity() {

    private val bluetoothStatusReceiver = BluetoothStatusReceiver() // Use BluetoothStatusReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerReceiver(bluetoothStatusReceiver, IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED))

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.POST_NOTIFICATIONS), 0 )
        }
        setContent {
            EX3SeviceBroadCastTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                )
                    { Text(" Bluetooth Status Broadcast Receiver ") }
            }
        }
    }
    override fun onDestroy()
    {
        super.onDestroy()
        unregisterReceiver(bluetoothStatusReceiver)
    }
}


