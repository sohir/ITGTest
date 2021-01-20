package com.itg.itgmarvel.characterslist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.itg.itgmarvel.R
import com.itg.itgmarvel.databinding.FragmentCharactersListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersListFragment : Fragment() {
private var _binding: FragmentCharactersListBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<CharactersListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCharactersListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        setHasOptionsMenu(true)
        binding.testTv.setOnClickListener{
            it.findNavController().navigate(CharactersListFragmentDirections.actionCharactersListFragmentToCharacterDetailsFragment())
        }
        observeCharctersList()
        return binding.root
    }

    fun observeCharctersList(){
        viewModel.responseModel.observe(viewLifecycleOwner, Observer {
            it?.let {
                Log.v("list","its code from the fragment : ${it.code.toString()}")
            }
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}