package com.virtual_android.a_donde_ir

import android.os.Bundle
import android.util.Log
import android.view.PointerIcon
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.lifecycle.ViewModelProvider

class ListActivity : AppCompatActivity() {

    // private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_activity)

        // viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // observeLiveData()

    }

    /* private fun observeLiveData() {
        viewModel.getPois().observe(this, {
            Log.d("POIS", it.toString())
        })

    } */


}