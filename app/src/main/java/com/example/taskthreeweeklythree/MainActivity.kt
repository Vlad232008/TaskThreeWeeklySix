package com.example.taskthreeweeklythree

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.taskthreeweeklythree.fragment.FragmentOne
import com.example.taskthreeweeklythree.fragment.FragmentTwo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frOne, FragmentOne.newInstance())
        transaction.commit()
        val transaction1 = this.supportFragmentManager.beginTransaction()
        transaction1.replace(R.id.frTwo, FragmentTwo.newInstance())
        transaction1.commit()
    }
}