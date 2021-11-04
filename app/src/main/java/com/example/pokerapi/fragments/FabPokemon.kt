package com.example.pokerapi.fragments

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import com.example.pokerapi.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.jar.Attributes

class FabPokemon (view:View): Fragment() {
        var isFABOpen: Boolean = false
        var fab : FloatingActionButton = view.findViewById(R.id.fab)
        var fab1 : FloatingActionButton = view.findViewById(R.id.fab1)
        var fab2 : FloatingActionButton = view.findViewById(R.id.fab2)
        var fab3 : FloatingActionButton = view.findViewById(R.id.fab3)
        var fab4 : FloatingActionButton = view.findViewById(R.id.fab4)


        fun recebendoView(){
            fab.setOnClickListener {
                if(!isFABOpen){
                    showFABMenu()
                }else{
                    closeFABMenu()

                }

            }


        }
        fun showFABMenu(){

            isFABOpen=true
            fab1.animate().translationY(-getResources().getDimension(R.dimen.standard_55))
            fab2.animate().translationY(-getResources().getDimension(R.dimen.standard_105));
            fab3.animate().translationY(-getResources().getDimension(R.dimen.standard_155));
            fab4.animate().translationY(-getResources().getDimension(R.dimen.standard_205));

        }

        fun closeFABMenu(){
            isFABOpen=false;
            fab1.animate().translationY(1000f)
            fab2.animate().translationY(1000f)
            fab3.animate().translationY(1000f)
            fab4.animate().translationY(1000f)
            fab1.isGone
            fab2.isGone
            fab3.isGone
            fab4.isGone
        }

}