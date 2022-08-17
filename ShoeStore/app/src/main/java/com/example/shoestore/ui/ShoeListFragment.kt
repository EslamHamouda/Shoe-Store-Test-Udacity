package com.example.shoestore.ui

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentShoeListBinding
import com.example.shoestore.viewmodel.ViewModel


class ShoeListFragment : Fragment() {
    lateinit var binding: FragmentShoeListBinding
    lateinit var viewModel: ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list,container,false)

        binding.toolbar.inflateMenu(R.menu.menu)
        binding.toolbar.setOnMenuItemClickListener{
            when(it.itemId){
                R.id.item1->
                    view?.findNavController()?.navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
            }
            true
        }

        binding.fab.setOnClickListener{
            view?.findNavController()?.navigate(ShoeListFragmentDirections.actionShoeListFragmentToShowDetailFragment())
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel= ViewModelProvider(requireActivity())[ViewModel::class.java]
        viewModel.getAllShoe().observe(viewLifecycleOwner){
            for (shoe in it) {
                createText(shoe.name, shoe.company, shoe.size, shoe.description)
            }

        }
    }

    @SuppressLint("SetTextI18n")
    fun createText(name:String, company:String, size:Int, description:String){
        val text = TextView(requireContext())
        text.setPadding(20, 5, 5, 5)
        val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(25, 10, 25, 10)
        val builder = Typeface.Builder("font/inter.ttf")
        val typeface = builder.build()
        text.typeface = typeface
        text.layoutParams = params
        text.textSize = 16F
        text.background = ContextCompat.getDrawable(requireContext(), R.drawable.textstyle)
        text.text = "Shoe name: $name\nShoe company: $company\nShoe size: $size\nShoe description: $description"
        binding.linear.addView(text)
    }
}