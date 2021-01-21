package com.itg.itgmarvel.characterslist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.itg.itgmarvel.databinding.FragmentCharactersListBinding
import com.itg.itgmarvel.models.CharactersListResponseModel
import com.itg.itgmarvel.utility.HelperClass
import dagger.hilt.android.AndroidEntryPoint
import java.math.BigInteger
import java.security.MessageDigest
import javax.inject.Inject

@AndroidEntryPoint
class CharactersListFragment : Fragment(),
    CharactersListAdapter.CharactersListActionsClickListener {
    private var _binding: FragmentCharactersListBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<CharactersListViewModel>()
    private lateinit var mAdapter: CharactersListAdapter
@Inject
lateinit var helper:HelperClass
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCharactersListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        setHasOptionsMenu(true)

        mAdapter = CharactersListAdapter(this)

        binding.recycler.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context)
        }
        Log.v("list","md5 is : ${helper.md5Encript("2049200b9bcdbca9d2ee0c149aef630c6eab7277f322fc34dbf9e1da7186fe9d067e45fb9")}")
        observeCharctersList()
        return binding.root
    }

    fun observeCharctersList() {
        viewModel.charactersListModel.observe(viewLifecycleOwner, Observer {
            it?.let {
                mAdapter.updateDate(it)
                Log.v("list", "its from the fragment : ${it.size}")
            }
        })
    }

    override fun onItemClicked(v: View, item: CharactersListResponseModel.Data.Result) {
        Log.v("list", "clicked item is : ${item.description}")
        findNavController().navigate(CharactersListFragmentDirections.actionCharactersListFragmentToCharacterDetailsFragment(item.name,item.description,"${item.thumbnail.path}.${item.thumbnail.extension}",item.id))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}