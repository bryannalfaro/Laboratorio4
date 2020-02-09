package com.example.laboratorio4.actividades

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.laboratorio4.R
import com.example.laboratorio4.databinding.ActivityMainBinding
import com.example.laboratorio4.fragments.Places

/**
 * @author Bryann Alfaro
 * @since 29, February 2020
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,
            R.layout.activity_main
        )
        //Create the intent for the deeplink
        var intent:Intent=intent

        //Comprobate if the intent is not null or the data
        if (intent!=null && intent.data!=null){
            val params = intent.data!!.getPathSegments()//get the params
            val first = params[0]//Get the first param
            if (first.equals("Antigua")){
                var places2:String="Antigua"
                var bundle= bundleOf("lugar" to places2)
                this.findNavController(R.id.myNavHostFragment).navigate(R.id.action_principal_to_places,bundle)
            }
        }

        //Controller for the nav
        val Controllernav=this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this,Controllernav)//support for the back button

    }

    override fun onSupportNavigateUp(): Boolean {
        val Controllernav=this.findNavController(R.id.myNavHostFragment)
        return Controllernav.navigateUp()
    }

}
