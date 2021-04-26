package com.example.mytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.mytest.databinding.ActivityMainBinding
import com.example.mytest.ui.MyFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.txtMain.setOnClickListener {
            supportFragmentManager.commit {
                add(R.id.fragment_container ,MyFragment::class.java ,null)
                setReorderingAllowed(true)
            }
        }

    }



}