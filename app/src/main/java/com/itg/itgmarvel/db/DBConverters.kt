package com.itg.itgmarvel.db

import androidx.room.TypeConverter
import com.itg.itgmarvel.models.CharactersListResponseModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class DBConverters {
/*
    @TypeConverter
    public   fun fromCharactersItems(list: List<CharactersListResponseModel.Data.Result.Thumbnail>):String{
        //   return Gson().toJson(itemL2)
        val moshi: Moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, CharactersListResponseModel.Data.Result.Thumbnail::class.java)
        val adapter = moshi.adapter<List<CharactersListResponseModel.Data.Result.Thumbnail>>(type)
        return adapter.toJson(list)
    }
    @TypeConverter
    public   fun toCharactersItems(list:String): List<CharactersListResponseModel.Data.Result.Thumbnail>? {
            val moshi: Moshi = Moshi.Builder().build()
            val type = Types.newParameterizedType(List::class.java, CharactersListResponseModel.Data.Result.Thumbnail::class.java)
            val adapter = moshi.adapter<List<CharactersListResponseModel.Data.Result.Thumbnail>>(type)
            return adapter.fromJson(list)
    }
*/

/*    @TypeConverter
    public   fun fromProductsList(list: List<ProductResponseModel.Item.ExtensionAttributes.Specification>):String{
        //   return Gson().toJson(itemL2)
        val moshi: Moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, ProductResponseModel.Item.ExtensionAttributes.Specification::class.java)
        val adapter = moshi.adapter<List<ProductResponseModel.Item.ExtensionAttributes.Specification>>(type)
        return adapter.toJson(list)
    }
    @TypeConverter
    public   fun toProductsList(list:String): List<ProductResponseModel.Item.ExtensionAttributes.Specification>? {
        val moshi: Moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, ProductResponseModel.Item.ExtensionAttributes.Specification::class.java)
        val adapter = moshi.adapter<List<ProductResponseModel.Item.ExtensionAttributes.Specification>>(type)
        return adapter.fromJson(list)
    }*/
}