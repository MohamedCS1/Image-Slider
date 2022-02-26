package com.example.imageslider

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

private const val ARG_PARAM1 = "param1"

class ImageFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var Img: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            Img = it.getInt(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_image, container, false)

        val  imageview =  view.findViewById<ImageView>(R.id.fragmentimageview)

        imageview.setBackgroundResource(Img!!)

        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(Img: Int) =
            ImageFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, Img)
                }
            }
    }
}