package com.phuong.jniandroid

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.phuong.jniandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example of a call to a native method
        binding.sampleText.text = stringFromJNI()
        val sum = sumFromJNI(10, 5)
        Log.d(TAG, "onCreate: $sum")
    }

    /**
     * A native method that is implemented by the 'jniandroid' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String
    external fun sumFromJNI(a: Int, b : Int) : Int

    companion object {
        // Used to load the 'jniandroid' library on application startup.
        init {
            System.loadLibrary("jniandroid")
        }

        private const val TAG = "MainActivity"
    }
}