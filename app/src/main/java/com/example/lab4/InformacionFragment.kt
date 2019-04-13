package com.example.lab4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.*
import androidx.databinding.DataBindingUtil.inflate
import androidx.navigation.findNavController
import com.example.lab4.databinding.FragmentInformacionBinding

class InformacionFragment : Fragment() {

    private val myInfo = MyInfo()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val binding : FragmentInformacionBinding = inflate(inflater, R.layout.fragment_informacion,container,false)
        val args = InformacionFragmentArgs.fromBundle(arguments!!)

        binding.myInfo = myInfo

        if(args.lugar == 1){
            binding.apply {
                myInfo?.title = R.string.info_title1.toString()
                myInfo?.subtitle = R.string.article_subtitle1.toString()
                myInfo?.text = R.string.info_text1.toString()
            }
        }
        if(args.lugar == 2){
            binding.apply {
                myInfo?.title = R.string.info_title2.toString()
                myInfo?.subtitle = R.string.article_subtitle2.toString()
                myInfo?.text = R.string.info_text2.toString()
            }
        }
        if(args.lugar == 3){
            binding.apply {
                myInfo?.title = R.string.info_title3.toString()
                myInfo?.subtitle = R.string.article_subtitle3.toString()
                myInfo?.text = R.string.info_text3.toString()
            }
        }

        binding.addComentario.setOnClickListener {
            it.findNavController().navigate(InformacionFragmentDirections.actionInformacionFragmentToComentarioFragment(binding.comentario.text.toString()))
        }

        setHasOptionsMenu(true)
        return binding.root
    }
}
