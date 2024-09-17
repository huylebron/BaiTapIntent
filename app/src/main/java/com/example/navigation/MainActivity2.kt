package com.example.navigation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.navigation.databinding.InfoBinding

class MainActivity2 : AppCompatActivity() {
    lateinit var  bind: InfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        bind = InfoBinding.inflate(layoutInflater)
        setContentView(bind.root)


       val tt5 = intent.getStringExtra("tt5")
        val tt2 = intent.getStringExtra("tt2")
        val tt3 = intent.getStringExtra("tt3")
        val tt4 = intent.getStringExtra("tt4")
        val tt6 = intent.getStringExtra("tt6")


        bind.tt1.text = tt5
        bind.tt2.text = tt2
        bind.tt3.text = tt3
        bind.tt4.text = tt4
        bind.tt6.text = tt6

        bind.btBack.setOnClickListener {
            finish()
        }

    }
}