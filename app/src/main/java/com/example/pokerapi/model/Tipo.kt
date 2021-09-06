package com.example.pokerapi.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Tipo (
        val name:String,
        val url: String
        ): Parcelable
