package com.example.laboratorio4.fragments


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import com.example.laboratorio4.R
import com.example.laboratorio4.databinding.FragmentComentarioBinding

/**
 * A simple [Fragment] subclass.
 */
class Comentario : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Inflate the fragment
        val binding3 = DataBindingUtil.inflate<FragmentComentarioBinding>(
            inflater, R.layout.fragment_comentario, container, false)

        val string: String? = arguments?.getString("comentario")
        binding3.comment.setText(string)
        //Get the options for the menu
        setHasOptionsMenu(true)


        // Inflate the layout for this fragment
        return binding3.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.share,menu)
    }

    //Share the intent
    private fun getShareIntent():Intent{
        val string1: String? = arguments?.getString("comentario")

        val shareIntent=Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT,string1)

        return shareIntent
    }

    private fun shareSuccess(){
        startActivity(getShareIntent())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item!!.itemId){
            R.id.shareButton ->shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }
}
