package com.sanjayagavalgana

import android.os.Build
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
//        binding.sampleText.text = stringFromJNI()

        // check the shared preference value
        val processorType = Utils.getSharedPrefInt(this, PROCESSOR_TYPE_KEY)
        val execMode = Utils.getSharedPrefString(this, EXEC_MODE_KEY)

        // set the radio button checked for processor type
        if (processorType == 32) {
            binding.radio32Bit.isChecked = true
        } else if (processorType == 64) {
            binding.radio64Bit.isChecked = true
        }

        // set the radio button checked for exec mode
        if (execMode == "root") {
            binding.radioExecModeRoot.isChecked = true
        } else if (execMode == "non-root") {
            binding.radioExecModeNonRoot.isChecked = true
        }

        // set app version in text view
        binding.tvAppVersion.text = "v${BuildConfig.VERSION_NAME} (${BuildConfig.VERSION_CODE})"
        binding.tvPhoneDetails.text = "${Build.MANUFACTURER} - ${Build.MODEL} - API ${Build.VERSION.SDK_INT}"

        // set on checked change listener for radio buttons and save the value in shared preference

        // for processor type
        binding.radio32Bit.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Utils.saveSharedPrefInt(this, PROCESSOR_TYPE_KEY, 32)
            }
        }

        binding.radio64Bit.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Utils.saveSharedPrefInt(this, PROCESSOR_TYPE_KEY, 64)
            }
        }

        // for exec mode
        binding.radioExecModeRoot.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Utils.saveSharedPrefString(this, EXEC_MODE_KEY, "root")
            }
        }

        binding.radioExecModeNonRoot.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Utils.saveSharedPrefString(this, EXEC_MODE_KEY, "non-root")
            }
        }

        // set on click listener for start button
        binding.btnStart.setOnClickListener {
            val pType = Utils.getSharedPrefInt(this, PROCESSOR_TYPE_KEY)
            val eMode = Utils.getSharedPrefString(this, EXEC_MODE_KEY)
            // TODO: Remove this text view and add the logic to execute the native code
            binding.tvLog.text = "Processor Type: $pType\nExec Mode: $eMode"
            // TODO: Start the ESP service
        }

        // set on click listener for stop button
        binding.btnStop.setOnClickListener {
            // TODO: Remove this text view and add the logic to execute the native code
            binding.tvLog.text = ""
            // TODO: Stop the ESP service
        }
    }

    /**
     * A native method that is implemented by the 'sanjayagavalgana' native library,
     * which is packaged with this application.
     */
    private external fun stringFromJNI(): String

    companion object {
        private const val PROCESSOR_TYPE_KEY = "PROCESSOR_TYPE"
        private const val EXEC_MODE_KEY = "EXEC_MODE"

        // Used to load the 'sanjayagavalgana' library on application startup.
        init {
            System.loadLibrary("sanjayagavalgana")
        }
    }
}