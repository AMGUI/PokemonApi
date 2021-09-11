package com.example.pokerapi.model

import android.annotation.SuppressLint
import android.content.Context
import android.os.Parcelable
import android.widget.FrameLayout
import com.example.pokerapi.R
import kotlinx.android.parcel.Parcelize
import org.koin.core.component.getScopeId

@Parcelize
data class Tipo (
        val name:String,
        val url: String
        ): Parcelable
{
        fun getThumbnail(context: Context,frameLayout: FrameLayout ): Int {
                setColor(context.resources
                        .getIdentifier("ic_type_"+name+"_foreground","drawable",context.packageName) ,frameLayout)
                return context.resources
                        .getIdentifier(name,"drawable",context.packageName)
        }

        fun setColor(int:Int, frameLayout: FrameLayout) {
                frameLayout.setBackgroundResource(int)

        }
}