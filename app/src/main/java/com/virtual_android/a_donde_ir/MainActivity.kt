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
        setContentView(R.layout.fragment_detail)

        val name = intent.getStringExtra(ListActivity.KEY_NAME)
        val description = intent.getStringExtra(ListActivity.KEY_DESCRIPTION)
        val imageUrl = intent.getStringExtra(ListActivity.KEY_IMAGE)
        val temperature = intent.getStringExtra(ListActivity.KEY_TEMPERATURE)
        val ubicacion = intent.getStringExtra(ListActivity.KEY_UBICACION)


        val textViewName: TextView = findViewById(R.id.nombreView)
        val textViewDescription: TextView  = findViewById(R.id.destination_description)
        val imgView: ImageView = findViewById(R.id.image_lugar_View)
        val temperatureView : TextView = findViewById(R.id.temperaturaView)
        val ubicacionView : TextView = findViewById(R.id.ciudadView)

        val imgButton: ImageButton = findViewById(R.id.regreso_Button)
        val imgLogo: ImageView = findViewById(R.id.image_logo_View)

        textViewName.text = name
        textViewDescription.text = description
        temperatureView.text = temperature
        ubicacionView.text = ubicacion
        Glide.with(this)
            .load(imageUrl)
            .into(imgView)

        imgLogo.setImageResource(R.drawable.logo_app)

        imgButton.setOnClickListener {
            navigateToList()
        }
    }

    private fun navigateToList() {
        val intent = Intent(this, ListActivity::class.java)
        startActivity(intent)
    }
}