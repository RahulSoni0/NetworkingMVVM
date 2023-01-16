package com.rahulsoni0.networkingmvvm.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rahulsoni0.networkingmvvm.R
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}