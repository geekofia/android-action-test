package com.sanjayagavalgana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sanjayagavalgana.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example of a call to a native method
        binding.sampleText.text = stringFromJNI()
    }

    /**
     * A native method that is implemented by the 'sanjayagavalgana' native library,
     * which is packaged with this application.
     */
    private external fun stringFromJNI(): String

    companion object {
        // Used to load the 'sanjayagavalgana' library on application startup.
        init {
            System.loadLibrary("sanjayagavalgana")
        }
    }
}