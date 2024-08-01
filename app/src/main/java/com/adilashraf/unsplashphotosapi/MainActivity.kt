
package com.adilashraf.unsplashphotosapi

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.adilashraf.unsplashphotosapi.adapter.PhotosAdapter
import com.adilashraf.unsplashphotosapi.api.ApiUtilities
import com.adilashraf.unsplashphotosapi.databinding.ActivityMainBinding
import com.adilashraf.unsplashphotosapi.model.PhotosItem
import com.tashila.pleasewait.PleaseWaitDialog

import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

 class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    lateinit var dialog: PleaseWaitDialog
    val photos = arrayListOf<PhotosItem>()
    var adapter: PhotosAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        dialog = PleaseWaitDialog(this@MainActivity)
        dialog.setTitle("Please wait")
        dialog.setMessage("Please wait")
        dialog.isCancelable = true
        dialog.show()

        getApiData()
        setAdapter()
    }

    private fun setAdapter() {
        adapter = PhotosAdapter(photos, this)
        binding.apply {
            recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)
//            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter = adapter
        }

    }


    private fun getApiData() {
         ApiUtilities.getInstance().getAllPhotos(1, 100)
            .enqueue(object : Callback, retrofit2.Callback<List<PhotosItem>> {
                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(
                    p0: Call<List<PhotosItem>>,
                    response: Response<List<PhotosItem>>,
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        response.body()!!.forEach {
                            photos.add(it)
                        }
                        adapter!!.notifyDataSetChanged()
                        dialog.dismiss()

                    }
                }

                override fun onFailure(p0: Call<List<PhotosItem>>, p1: Throwable) {
                 }

            })
    }



  }