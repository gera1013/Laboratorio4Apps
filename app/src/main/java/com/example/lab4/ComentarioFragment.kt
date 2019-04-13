package com.example.lab4


import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.ShareCompat
import android.view.*
import androidx.navigation.findNavController
import com.example.lab4.databinding.FragmentComentarioBinding

class ComentarioFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val binding : FragmentComentarioBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_comentario, container, false)
        binding.nextMatchButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_comentarioFragment_to_informacionFragment)
        }
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.share_menu, menu)
        if(null == getShareIntent().resolveActivity(activity!!.packageManager)){
            menu?.findItem(R.id.share)?.isVisible = false
        }
    }

    private fun getShareIntent(): Intent {
        var args = ComentarioFragmentArgs.fromBundle(arguments!!)
        return ShareCompat.IntentBuilder.from(activity).setText(args.comentario).setType("text/plain").intent
    }

    private fun shareSuccess(){
        startActivity(getShareIntent())
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }
}
