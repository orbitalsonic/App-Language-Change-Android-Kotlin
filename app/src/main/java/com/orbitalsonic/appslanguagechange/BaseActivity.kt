package com.orbitalsonic.appslanguagechange

import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.orbitalsonic.appslanguagechange.SharedPreferencesUtils.getLanguageCode

open class BaseActivity : AppCompatActivity() {

    private lateinit var rsContext: Context
    lateinit var mResources: Resources

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        rsContext = LocaleHelper.setLocale(this,getLanguageCode(this)!!)!!
        mResources = rsContext.resources

    }

    fun showMessage(message: String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
}