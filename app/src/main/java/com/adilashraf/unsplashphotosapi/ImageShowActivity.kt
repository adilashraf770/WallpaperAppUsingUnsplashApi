package com.adilashraf.unsplashphotosapi

  import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
 import com.adilashraf.unsplashphotosapi.databinding.ActivityImageShowBinding
import com.bumptech.glide.Glide

 class ImageShowActivity : AppCompatActivity() {
    private val binding: ActivityImageShowBinding by lazy {
        ActivityImageShowBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
         val image = intent.getStringExtra("image")
        binding.apply {
            Glide.with(this@ImageShowActivity).load(Uri.parse(image)).into(zoomageView)

        }




    }
}