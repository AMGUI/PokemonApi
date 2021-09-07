package com.example.pokerapi.model

import android.content.Context
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Tipo (
        val name:String,
        val url: String
        ): Parcelable
{
        fun getThumbnail(context: Context): Int {
                return context.resources
                        .getIdentifier(name,"drawable",context.packageName)
        }
}