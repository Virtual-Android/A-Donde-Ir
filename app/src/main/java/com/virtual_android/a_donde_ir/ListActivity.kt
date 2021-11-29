package com.virtual_android.a_donde_ir

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException

class ListActivity : AppCompatActivity() {

    private lateinit var mDestinations: ArrayList<Destination>
    private lateinit var mAdapter: DestinationAdapter
    private lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_activity)

        recycler = findViewById(R.id.destination_list)
        setupRecyclerView()
        initDataFromFile()
    }

    private fun setupRecyclerView() {
        mDestinations = arrayListOf()
        recycler.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        mAdapter = DestinationAdapter(mDestinations, this) { destination ->
            contactOnClick(destination)
        }

        recycler.adapter = mAdapter
    }

    private fun contactOnClick(destination: Destination?) {
        Log.d(TAG, "Click on: $destination")
        destination?.let {
            navigateToDetail(it)
        }
    }

    private fun navigateToDetail(destination: Destination) {
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(KEY_NAME, destination.name)
            putExtra(KEY_DESCRIPTION, destination.description)
            putExtra(KEY_IMAGE, destination.imageUrl)
            putExtra(KEY_UBICACION, destination.location)
            putExtra(KEY_TEMPERATURE, destination.temepature)
        }

        startActivity(intent)
    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
        const val KEY_NAME = "nombreView"
        const val KEY_DESCRIPTION = "destination_description"
        const val KEY_IMAGE = "image_lugar_View"
        const val KEY_TEMPERATURE = "temperaturaView"
        const val KEY_UBICACION = "ciudadView"
    }

    private fun initDataFromFile() {
        val destinationString = readDestinationsJsonFile()
        try {
            val destinationsJson = JSONArray(destinationString)
            for (i in 0 until destinationsJson.length()) {
                val destinationJson = destinationsJson.getJSONObject(i)
                val destination = Destination(
                    destinationJson.getString("imageUrl"),
                    destinationJson.getString("name"),
                    destinationJson.getString("description"),
                    destinationJson.getInt("rate"),
                    destinationJson.getString("temperature"),
                    destinationJson.getString("ubicacion")
                )
                Log.d(TAG, "generateDestinations: $destination")
                mDestinations.add(destination)
            }

            mAdapter.notifyDataSetChanged()
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    private fun readDestinationsJsonFile(): String? {
        var destinationsString: String? = null
        try {
            val inputStream = assets.open("mock_destinations.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            destinationsString = String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return destinationsString
    }

}