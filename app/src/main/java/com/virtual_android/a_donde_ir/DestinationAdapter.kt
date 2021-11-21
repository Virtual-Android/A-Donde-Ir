package com.virtual_android.a_donde_ir

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class DestinationAdapter(
    private val mDestinations: ArrayList<Destination>,
    private val context: Context,
    private val onClick: (Destination?) -> Unit
) : RecyclerView.Adapter<DestinationAdapter.DestinationViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DestinationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.element_layout, parent, false)
        return DestinationViewHolder(view)
    }

    override fun onBindViewHolder(holderDestination: DestinationViewHolder, position: Int) {
        val destination = mDestinations[position]
        holderDestination.bind(destination = destination)
    }

    override fun getItemCount(): Int {
        return mDestinations.size
    }

    inner class DestinationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var nameLabel: TextView = itemView.findViewById(R.id.name_destination)
        private var descriptionLabel: TextView = itemView.findViewById(R.id.short_description)
        private var imageView: ImageView = itemView.findViewById(R.id.image_item)
        private var rateLabel: TextView = itemView.findViewById(R.id.text_rate)
        private var currentDestination: Destination? = null

        init {
            itemView.setOnClickListener {
                Log.d(TAG, "itemView OnClick")
                onClick(currentDestination)
            }
        }

        /* Bind Contact name and image. */
        fun bind(destination: Destination) {
            currentDestination = destination

            nameLabel.text = destination.name
            descriptionLabel.text = destination.description
            rateLabel.text = destination.rate.toString()

            Glide.with(context)
                .load(destination.imageUrl)
                .into(imageView)
        }
    }

    companion object{
        private const val TAG = "DestinationAdapter"
    }
}