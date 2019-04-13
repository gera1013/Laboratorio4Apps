package com.example.lab4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.*
import androidx.databinding.DataBindingUtil.inflate
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.lab4.databinding.FragmentInicioBinding

class InicioFragment : Fragment() {

    private var mostrar = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val binding : FragmentInicioBinding = inflate(inflater, R.layout.fragment_inicio, container, false)

        binding.button1.setOnClickListener {
            it.findNavController().navigate(InicioFragmentDirections.actionInicioFragmentToInformacionFragment(1))

        }
        binding.button2.setOnClickListener {
            it.findNavController().navigate(InicioFragmentDirections.actionInicioFragmentToInformacionFragment(2))
        }
        binding.button3.setOnClickListener {
            it.findNavController().navigate(InicioFragmentDirections.actionInicioFragmentToInformacionFragment(3))
        }

        binding.starButton.setOnClickListener{
            if(mostrar){
                binding.textIngresado.visibility = View.VISIBLE
                binding.editText.visibility = View.GONE
                binding.textView.visibility = View.GONE
            } else{
                binding.textIngresado.visibility = View.GONE
                binding.editText.visibility = View.VISIBLE
                binding.textView.visibility = View.VISIBLE
            }
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController())
        || super.onOptionsItemSelected(item)
    }
}
