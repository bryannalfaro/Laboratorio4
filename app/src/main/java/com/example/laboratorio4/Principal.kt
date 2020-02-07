package com.example.laboratorio4


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.laboratorio4.databinding.FragmentPrincipalBinding

/**
 * A simple [Fragment] subclass.
 */
class Principal : Fragment() {

    private var tester:Boolean?=true//Evaluate if the FloatingButton is selected


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding1 = DataBindingUtil.inflate<FragmentPrincipalBinding>(
            inflater, R.layout.fragment_principal, container, false)

        binding1.star
        binding1.star.setOnClickListener{
            if(tester==true){
                var name=binding1.editText2.text.toString()

                binding1.nameSet.setText(name)
                binding1.editText2.setText("")
                binding1.editText2.visibility= View.GONE
                binding1.textView3.visibility= View.GONE
                binding1.nameSet.visibility= View.VISIBLE
                tester=false
            }else{
                binding1.editText2.visibility= View.VISIBLE
                binding1.textView3.visibility= View.VISIBLE
                binding1.nameSet.visibility= View.GONE
                tester=true
            }
        }
        return binding1.root



//        binding.tikalButton
//        binding.tikalButton.setOnClickListener {
//            val intent = Intent(this, Places::class.java)
//            intent.putExtra("boton6","Tikal")
//
//            startActivity(intent)
//
//        }
//        binding.antiguaButton
//        binding.antiguaButton.setOnClickListener {
//            val intent = Intent(this, Places::class.java)
//            intent.putExtra("boton7","Antigua")
//
//            startActivity(intent)
//
//        }
//        binding.semucButton
//        binding.semucButton.setOnClickListener {
//
//            val intent = Intent(this, Places::class.java)
//            intent.putExtra("boton8","Semuc")
//
//            startActivity(intent)
//
//        }


    }




}
