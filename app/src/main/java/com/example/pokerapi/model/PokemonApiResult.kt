package com.example.pokerapi.model
import android.content.Context
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PokemonApiResult(

    @SerializedName("name")
     val name: String,
    @SerializedName("id")
    val id: String



): Parcelable {

  //  val id: String get() = url.split("/".toRegex()).dropLast(1).last()

    fun getnameImg():String{
        return "p"+id
    }

    fun getThumbnail(context: Context): Int {
        return context.resources
                .getIdentifier(getnameImg(),"drawable",context.packageName)
    }

}
