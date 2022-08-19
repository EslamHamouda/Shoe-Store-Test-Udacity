package com.example.shoestore.ui

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentShowDetailBinding
import com.example.shoestore.shoe.ShoeModel
import com.example.shoestore.viewmodel.ViewModel
import java.lang.NumberFormatException


class ShowDetailFragment : Fragment() {
    lateinit var binding: FragmentShowDetailBinding
    val viewModel by activityViewModels<ViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_show_detail,container,false)
        binding.cancel.setOnClickListener{
            view?.findNavController()?.navigate(ShowDetailFragmentDirections.actionShowDetailFragmentToShoeListFragment())
        }

        with(binding){
            viewModels=viewModel
            lifecycleOwner=requireActivity()
            save.setOnClickListener{
                viewModel.addShoe()
                Toast.makeText(requireContext(), "Done", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }



}