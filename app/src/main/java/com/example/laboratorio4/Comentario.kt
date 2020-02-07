package com.example.laboratorio4


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.laboratorio4.databinding.FragmentComentarioBinding

/**
 * A simple [Fragment] subclass.
 */
class Comentario : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding3 = DataBindingUtil.inflate<FragmentComentarioBinding>(
            inflater, R.layout.fragment_comentario, container, false)

        val string: String? = arguments?.getString("comentario")
        binding3.comment.setText(string)
        // Inflate the layout for this fragment
        return binding3.root
    }


}
