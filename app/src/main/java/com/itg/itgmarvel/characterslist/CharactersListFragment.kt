package com.itg.itgmarvel.characterslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.itg.itgmarvel.R
import com.itg.itgmarvel.databinding.FragmentCharactersListBinding


class CharactersListFragment : Fragment() {
private var _binding: FragmentCharactersListBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCharactersListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        setHasOptionsMenu(true)
        binding.testTv.setOnClickListener{
            it.findNavController().navigate(CharactersListFragmentDirections.actionCharactersListFragmentToCharacterDetailsFragment())
        }
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}