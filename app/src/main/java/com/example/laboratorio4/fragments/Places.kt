package com.example.laboratorio4.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.laboratorio4.models.Modelo
import com.example.laboratorio4.R
import com.example.laboratorio4.databinding.FragmentPlacesBinding

/**
 * @author Bryann Alfaro
 * @since February 29, 2020
 */
class Places : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding2 = DataBindingUtil.inflate<FragmentPlacesBinding>(
            inflater, R.layout.fragment_places, container, false)
        //Make the models for the buttons
        val prueba = Modelo(
            getString(R.string.tikal),
            getString(R.string.phrase1),
            getString(
                R.string.descripcion1
            )
        )
        val prueba1= Modelo(
            getString(R.string.antigua),
            getString(R.string.phrase2),
            getString(
                R.string.descripcion2
            )
        )
        val prueba2= Modelo(
            getString(R.string.semuc),
            getString(R.string.phrase3),
            getString(
                R.string.descripcion3
            )
        )

        //Comment button
        binding2.button5.setOnClickListener {

            var comment:String=binding2.editText.text.toString()
            binding2.editText.setText("")
            var bundle1= bundleOf("comentario" to comment)
            view!!.findNavController().navigate(R.id.action_places_to_comentario,bundle1)

        }
        //Get the data from the other activity
        val string: String? = arguments?.getString("lugar")


        //Evaluates the data
        if (string.equals("Tikal")){
            binding2.modelo=prueba

        }else if (string.equals("Antigua")){
            binding2.modelo=prueba1
        }else if(string.equals("Semuc")){
            binding2.modelo=prueba2
        }

        return binding2.root
    }


}
