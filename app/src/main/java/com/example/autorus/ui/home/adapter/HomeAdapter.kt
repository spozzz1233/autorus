package com.example.autorus.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.autorus.domain.model.Part
import com.example.autorus.domain.model.parts
import com.example.playlistmaker.R

class HomeAdapter(
    private val clickListener: HomeClick,
): RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.HomeViewHolder {
        val cardMusicView =
            LayoutInflater.from(parent.context).inflate(R.layout.card_part, parent, false)
        return HomeAdapter.HomeViewHolder(cardMusicView)
    }
    override fun onBindViewHolder(holder: HomeAdapter.HomeViewHolder, position: Int) {
        holder.bind(parts[position])
        val part = parts[position]
        holder.itemView.setOnClickListener {
            clickListener.onClick(part)
        }

    }
    override fun getItemCount(): Int = parts.size
    class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val partName: TextView = itemView.findViewById(R.id.part_name)
        private val image: ImageView = itemView.findViewById(R.id.image)

        fun bind(part: Part) {
            partName.text = part.partName

            Glide.with(itemView.context)
                .load(R.drawable.pads)
                .transform(RoundedCorners(8))
                .into(image)
        }
    }
    fun interface HomeClick {
        fun onClick(parts: Part)
    }
    fun setItems(newParts: List<Part>) {
        parts = newParts
        notifyDataSetChanged()
    }

}
