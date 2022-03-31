package com.orbitalsonic.appslanguagechange

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.orbitalsonic.appslanguagechange.SharedPreferencesUtils.getLanguagePosition
import com.orbitalsonic.appslanguagechange.SharedPreferencesUtils.setLanguageCode
import com.orbitalsonic.appslanguagechange.SharedPreferencesUtils.setLanguagePosition
import com.orbitalsonic.appslanguagechange.databinding.ActivityMainBinding


/***
 * if you don't want to change layout direction
 * go in AndroidManifest and change android:supportsRtl="false"
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)

        changeRadioButtonViews(getLanguagePosition(this))

        binding.languageRadioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            onRadioButtonClicked(radio)
        }
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(LocaleHelper.setLocale(newBase!!))
    }


   private fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.radio_english ->
                    if (checked) {
                        // English language selected
                        setLanguageCode(this, "en")
                        setLanguagePosition(this, 0)
                        recreate()

                    }
                R.id.radio_urdu ->
                    if (checked) {
                        // Urdu language selected
                        setLanguageCode(this, "ur")
                        setLanguagePosition(this, 1)
                        recreate()
                    }

                R.id.radio_hindi ->
                    if (checked) {
                        // Hindi language selected
                        setLanguageCode(this, "hi")
                        setLanguagePosition(this, 2)
                        recreate()
                    }

                R.id.radio_bangla ->
                    if (checked) {
                        // Bangali language selected
                        setLanguageCode(this, "bn")
                        setLanguagePosition(this, 3)
                        recreate()
                    }

                R.id.radio_arabic ->
                    if (checked) {
                        // Arabic language selected
                        setLanguageCode(this, "ar")
                        setLanguagePosition(this, 4)
                        recreate()
                    }


            }
        }
    }

    private fun changeRadioButtonViews(position:Int){
        when(position){
            0 -> binding.radioEnglish.isChecked = true
            1 -> binding.radioUrdu.isChecked = true
            2 -> binding.radioHindi.isChecked = true
            3 -> binding.radioBangla.isChecked = true
            4 -> binding.radioArabic.isChecked = true
        }
    }
}