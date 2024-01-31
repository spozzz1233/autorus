package com.example.autorus.ui.cart

import com.example.autorus.domain.model.Part
import com.example.autorus.domain.model.cart
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.autorus.ui.home.adapter.HomeAdapter
import com.example.playlistmaker.R


class CartAdapter(
    private val clickListener: HistoryClick
) : RecyclerView.Adapter<CartAdapter.HistoryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val cardMusicView =
            LayoutInflater.from(parent.context).inflate(R.layout.card_part_mini, parent, false)
        return HistoryViewHolder(cardMusicView)
    }

    override fun getItemCount(): Int = cart.size

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val historyCart = cart[position]
        holder.bind(historyCart)
        holder.itemView.setOnClickListener {
            clickListener.onClick(historyCart)
        }
    }

    class HistoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val partName: TextView = itemView.findViewById(R.id.partName)
        private val price: TextView = itemView.findViewById(R.id.price)
        private val image: ImageView = itemView.findViewById(R.id.image)

        fun bind(part: Part) {
            partName.text = part.partName
            price.text = part.stockQuantity.toString()

            Glide.with(itemView.context)
                .load(R.drawable.pads)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .transform(RoundedCorners(8))
                .into(image)
        }
    }

    fun interface HistoryClick {
        fun onClick(part: Part)
    }
    fun updateData() {
        notifyDataSetChanged()
    }

}
