package com.example.shoestore.ui

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding
    var isFirstRun:Boolean?=true
    val args:LoginFragmentArgs by navArgs()
    var flag=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_login,container,false)
        binding.loginbutton.setOnClickListener{
            view?.findNavController()?.navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        flag=args.flag
        if (flag==0) {
            moveToLogin()
        }
    }

    private fun moveToLogin() {
        isFirstRun = requireActivity().getSharedPreferences("PREFERENCE", AppCompatActivity.MODE_PRIVATE)
            .getBoolean("isFirstRun",true)

        if(isFirstRun==false) {
            Toast.makeText(requireActivity(),"Welcome back",Toast.LENGTH_SHORT).show()
            requireView().findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToShoeListFragment())

        }
        requireActivity().getSharedPreferences("PREFERENCE", AppCompatActivity.MODE_PRIVATE).edit()
            .putBoolean("isFirstRun", false).apply()

    }
}