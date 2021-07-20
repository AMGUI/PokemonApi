package com.example.pokerapi.model
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PokemonApiResult(
    @SerializedName("name")
     val name: String,
    @SerializedName("url")
    val url: String

): Parcelable
