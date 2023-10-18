package com.example.rapidapi

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.rapidapi.databinding.ActivitySpliceBinding

class SpliceActivity : AppCompatActivity() {
    lateinit var binding : ActivitySpliceBinding
    lateinit var myViewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splice)

        var factory=MyViewModelFactory(this)

        myViewModel = ViewModelProvider(this,factory)[MyViewModel::class.java]

        val intent = Intent(this, MainActivity::class.java)

        if (myViewModel.sharedPreferences.getBoolean("check",false)==true){

            var temp=myViewModel.temp()
            intent.putExtra("arrayList", temp as ArrayList<String>)
            startActivity(intent)
        }
        else{
            myViewModel.getCurrency().observe(this) {
                intent.putExtra("arrayList", it as ArrayList<String>)
                startActivity(intent)
            }
        }





//        myViewModel.isloading.observe(this, Observer {
//            if (it) {
//                binding.progress.visibility = View.VISIBLE
//            } else {
//                binding.progress.visibility = View.INVISIBLE
//                startActivity(intent)
//            }
//        })

    }


    }
