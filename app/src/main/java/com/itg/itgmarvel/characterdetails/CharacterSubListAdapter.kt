package com.itg.itgmarvel.characterdetails

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.itg.itgmarvel.R
import com.itg.itgmarvel.databinding.CharactersListItemBinding
import com.itg.itgmarvel.databinding.CharactersSubListItemBinding
import com.itg.itgmarvel.models.CharactersListResponseModel
import com.itg.itgmarvel.models.ComicsResponseModel

class CharacterSubListAdapter(private val actionsInterface: CharactersListActionsClickListener? = null) :
    RecyclerView.Adapter<CharacterSubListAdapter.ViewHolder>() {
    val Diff_CallBack = object : DiffUtil.ItemCallback<ComicsResponseModel.Data.Result>() {
        override fun areItemsTheSame(
            oldItem: ComicsResponseModel.Data.Result,
            newItem: ComicsResponseModel.Data.Result
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ComicsResponseModel.Data.Result,
            newItem: ComicsResponseModel.Data.Result
        ): Boolean {
            return oldItem == newItem
        }

    }
    private val differ = AsyncListDiffer(this, Diff_CallBack)
    fun updateDate(newList: List<ComicsResponseModel.Data.Result>) {
        differ.submitList(newList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val rootView = DataBindingUtil.inflate<CharactersSubListItemBinding>(
            inflater,
            R.layout.characters_sub_list_item, parent, false
        )
        return ViewHolder(rootView, actionsInterface)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.data = differ.currentList[position]
        Log.v(
            "comics",
            " adapter items size: ${differ.currentList[position].thumbnail.extension} for the position ${position}}"
        )
        holder.bind(differ.currentList[position])
    }

    class ViewHolder(
        var view: CharactersSubListItemBinding,
        private val characterActions: CharactersListActionsClickListener?
    ) :
        RecyclerView.ViewHolder(view.root) {
        fun bind(item: ComicsResponseModel.Data.Result) {
            view.data = item
            //view.listener = characterActions
            view.executePendingBindings()
        }
    }

    interface CharactersListActionsClickListener {
        fun onItemClicked(v: View, item: ComicsResponseModel.Data.Result)
    }

}