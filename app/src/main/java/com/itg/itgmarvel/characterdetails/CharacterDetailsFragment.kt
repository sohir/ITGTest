package com.itg.itgmarvel.characterdetails

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.itg.itgmarvel.databinding.FragmentCharacterDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailsFragment : Fragment() {

    private var _binding: FragmentCharacterDetailsBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<DetailsViewModel>()
    private lateinit var mAdapter: CharacterSubListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCharacterDetailsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        setHasOptionsMenu(true)
        mAdapter = CharacterSubListAdapter()
        binding.comicsRecycler.apply {
            adapter = mAdapter

        }
        observeSubListes()

        return binding.root
    }

    fun observeSubListes() {

        viewModel.responseModel.observe(viewLifecycleOwner, Observer {
            it?.let {
                mAdapter.updateDate(it.data.results)
                Log.v("comics", "its code from the fragment : ${it.code.toString()}")
                Log.v("comics", "its name from the fragment : ${it.data.results[1].title}")

            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}