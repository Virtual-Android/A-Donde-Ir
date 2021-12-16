package com.virtual_android.a_donde_ir

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide


class DetailFragment : Fragment() {

    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textViewName: TextView = view.findViewById(R.id.nombreView)
        val textViewDescription: TextView = view.findViewById(R.id.destination_description)
        val imgView: ImageView = view.findViewById(R.id.image_lugar_View)
        val temperatureView : TextView = view.findViewById(R.id.temperaturaView)
        val ubicacionView : TextView = view.findViewById(R.id.ciudadView)
        val btnRegresar: ImageButton = view.findViewById(R.id.regreso_Button)
        val btnMaps: ImageButton = view.findViewById(R.id.iconoMapa)

        textViewName.text = args.destination.name
        textViewDescription.text = args.destination.description
        temperatureView.text = args.destination.temperature
        ubicacionView.text = args.destination.ubicacion
        Glide.with(this)
            .load(args.destination.imageUrl)
            .into(imgView)

        btnRegresar.setOnClickListener{
            navigateToList()
        }

        btnMaps.setOnClickListener{
            launchMap(args.destination.latitude,  args.destination.longitude)
        }
    }

    private fun navigateToList() {
        findNavController().navigate(R.id.action_detailFragment_to_listFragment)
    }

    private fun launchMap(lat: String, lon: String)
    {
        val geo = "geo:$lat,$lon"
        val gmmIntentUri = Uri.parse(geo)
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        activity?.let {
            mapIntent.resolveActivity(it.packageManager)?.let {
                startActivity(mapIntent)
            }
        }
    }
}