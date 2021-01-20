package com.itg.itgmarvel.characterslist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.itg.itgmarvel.databinding.FragmentCharactersListBinding
import com.itg.itgmarvel.models.CharactersListResponseModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersListFragment : Fragment(),
    CharactersListAdapter.CharactersListActionsClickListener {
    private var _binding: FragmentCharactersListBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<CharactersListViewModel>()
    private lateinit var mAdapter: CharactersListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCharactersListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        mAdapter = CharactersListAdapter(this)
        setHasOptionsMenu(true)
        binding.recycler.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context)
        }
        observeCharctersList()
        return binding.root
    }

    fun observeCharctersList() {
        viewModel.responseModel.observe(viewLifecycleOwner, Observer {
            it?.let {
                mAdapter.updateDate(it.data.results)
                Log.v("list", "its code from the fragment : ${it.code.toString()}")
            }
        })
    }

    override fun onItemClicked(v: View, item: CharactersListResponseModel.Data.Result) {
        Log.v("list", "clicked item is : ${item.name}")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}