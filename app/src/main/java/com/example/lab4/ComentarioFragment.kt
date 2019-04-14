package com.example.lab4


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.core.app.ShareCompat
import android.view.*
import androidx.databinding.DataBindingUtil.inflate
import androidx.navigation.findNavController
import com.example.lab4.databinding.FragmentComentarioBinding


class ComentarioFragment : Fragment() {

    private val myComment : MyComment = MyComment()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val binding : FragmentComentarioBinding = inflate(inflater, R.layout.fragment_comentario, container, false)
        val args = ComentarioFragmentArgs.fromBundle(arguments!!)

        myComment.comment = args.comentario

        binding.myComment = myComment

        binding.nextMatchButton.setOnClickListener {
            it.findNavController().navigate(ComentarioFragmentDirections.actionComentarioFragmentToInformacionFragment(0))
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
        val args = ComentarioFragmentArgs.fromBundle(arguments!!)
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
