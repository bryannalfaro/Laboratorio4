package com.example.laboratorio4.fragments


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.os.bundleOf

import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.laboratorio4.R
import com.example.laboratorio4.databinding.FragmentPrincipalBinding
/**
 * @author Bryann Alfaro
 * @since February 29, 2020
 */
class Principal : Fragment() {

    private var tester:Boolean?=true//Evaluate if the FloatingButton is selected


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {var place:String="Tikal"

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

        binding1.tikalButton
        binding1.tikalButton.setOnClickListener {
            //val intent = Intent(activity, Places::class.java)
            //intent.putExtra("boton6","Tikal")
            var placess:String="Tikal"
            var bundle= bundleOf("lugar" to placess)
            view!!.findNavController().navigate(R.id.action_principal_to_places,bundle)

        }
        binding1.antiguaButton
        binding1.antiguaButton.setOnClickListener {
            //val intent = Intent(activity, Places::class.java)
           // intent.putExtra("boton7","Antigua")
            var places2:String="Antigua"
            var bundle= bundleOf("lugar" to places2)
            view!!.findNavController().navigate(R.id.action_principal_to_places,bundle)


        }
        binding1.semucButton
        binding1.semucButton.setOnClickListener {

            //val intent = Intent(activity, Places::class.java)
            //intent.putExtra("boton8","Semuc")
            //startActivity(intent)
            var places3:String="Semuc"
            var bundle= bundleOf("lugar" to places3)
            view!!.findNavController().navigate(R.id.action_principal_to_places,bundle)


        }
        setHasOptionsMenu(true)
        return binding1.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,view!!.findNavController())||
        super.onOptionsItemSelected(item)
    }
}
