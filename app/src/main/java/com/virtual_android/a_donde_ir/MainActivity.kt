package com.virtual_android.a_donde_ir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = intent.getStringExtra(ListActivity.KEY_NAME)
        val description = intent.getStringExtra(ListActivity.KEY_DESCRIPTION)
        val imageUrl = intent.getStringExtra(ListActivity.KEY_IMAGE)

        var textViewName: TextView = findViewById(R.id.nombreView)
        var textViewDescription: TextView  = findViewById(R.id.destination_description)
        var imgView: ImageView = findViewById(R.id.image_lugar_View)

        var imgButton: ImageButton = findViewById(R.id.regreso_Button)

        textViewName.text = name
        textViewDescription.text = description
        Glide.with(this)
            .load(imageUrl)
            .into(imgView)

        imgButton.setOnClickListener {
            navigateToList()
        }
    }

    private fun navigateToList() {
        val intent = Intent(this, ListActivity::class.java)
        startActivity(intent)
    }
}