package com.itg.itgmarvel.characterslist

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
import com.itg.itgmarvel.models.CharactersListResponseModel

class CharactersListAdapter (private val actionsInterface:CharactersListActionsClickListener ?=null) : RecyclerView.Adapter<CharactersListAdapter.ViewHolder>() {
    val Diff_CallBack = object : DiffUtil.ItemCallback<CharactersListResponseModel.Data.Result> (){
        override fun areItemsTheSame(oldItem: CharactersListResponseModel.Data.Result, newItem: CharactersListResponseModel.Data.Result): Boolean {
            return oldItem.id== newItem.id
        }

        override fun areContentsTheSame(oldItem: CharactersListResponseModel.Data.Result, newItem: CharactersListResponseModel.Data.Result): Boolean {
            return oldItem==newItem
        }

    }
    private val differ = AsyncListDiffer(this,Diff_CallBack)
   fun updateDate(newList:List<CharactersListResponseModel.Data.Result>){
       differ.submitList(newList)
   }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val rootView = DataBindingUtil.inflate<CharactersListItemBinding>(inflater,
            R.layout.characters_list_item, parent,false)
        return ViewHolder(rootView,actionsInterface)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.data = differ.currentList[position]
        Log.v("list"," adapter items size: ${differ.currentList[position]} for the position ${position}}")
        holder.bind(differ.currentList[position])
    }

    class ViewHolder (var view:CharactersListItemBinding,private val characterActions: CharactersListActionsClickListener?):
        RecyclerView.ViewHolder(view.root){
        fun bind(itemL1: CharactersListResponseModel.Data.Result){
            view.data = itemL1
            view.listener = characterActions
            view.executePendingBindings()
        }
    }

    interface CharactersListActionsClickListener {
        fun onItemClicked(v: View,item: CharactersListResponseModel.Data.Result)
    }

}