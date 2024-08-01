package com.adilashraf.unsplashphotosapi.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adilashraf.unsplashphotosapi.ImageShowActivity
import com.adilashraf.unsplashphotosapi.databinding.PhotosLayoutBinding
import com.adilashraf.unsplashphotosapi.model.PhotosItem
import com.bumptech.glide.Glide

class PhotosAdapter(private val photosList: ArrayList<PhotosItem>, private val context: Context) : RecyclerView.Adapter<PhotosAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosAdapter.ViewHolder {
        val vh = PhotosLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(vh)
    }

    override fun onBindViewHolder(holder: PhotosAdapter.ViewHolder, position: Int) {
        val pos = photosList[position]
         val uri = Uri.parse(pos.urls.regular)
        holder.binding.apply {
            Glide.with(context).load(uri).into(image)

            imageCard.setOnClickListener {
                val i = Intent(context, ImageShowActivity::class.java )
                i.putExtra("image", pos.urls.regular)
                context.startActivity(i)
            }
        }
    }

    override fun getItemCount(): Int = photosList.size

    class ViewHolder(val binding: PhotosLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}