package com.virtual_android.a_donde_ir

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_activity)
    }

    companion object {
        const val KEY_NAME = "nombreView"
        const val KEY_DESCRIPTION = "destination_description"
        const val KEY_IMAGE = "image_lugar_View"
        const val KEY_TEMPERATURE = "temperaturaView"
        const val KEY_UBICACION = "ciudadView"
    }

}