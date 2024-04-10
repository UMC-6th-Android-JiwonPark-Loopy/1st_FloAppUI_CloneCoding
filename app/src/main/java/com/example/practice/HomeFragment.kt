package com.example.practice

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practice.databinding.FragmentAlbumBinding
import com.example.practice.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        onButtonClick()
        return binding.root
    }

    private fun onButtonClick() {
        with(binding) {
            val fragment = AlbumFragment()
            val bundle = Bundle()
            ivAlbum1.setOnClickListener {
                putBundle(fragment,bundle,tvAlbumName1.text.toString(), tvAlbumTitle1.text.toString())
            }
            ivAlbum2.setOnClickListener {
                putBundle(fragment,bundle,tvAlbumName2.text.toString(), tvAlbumTitle2.text.toString())
            }
            ivAlbum3.setOnClickListener {
                putBundle(fragment,bundle,tvAlbumName3.text.toString(), tvAlbumTitle3.text.toString())
            }
            ivAlbum4.setOnClickListener {
                putBundle(fragment,bundle,tvAlbumName4.text.toString(), tvAlbumTitle4.text.toString())
            }
            ivAlbum5.setOnClickListener {
                putBundle(fragment, bundle,tvAlbumName5.text.toString(), tvAlbumTitle5.text.toString())
            }
        }
    }
    private fun goNextPage(fr : Fragment, bundle: Bundle){
        fr.arguments = bundle
        activity?.supportFragmentManager!!.beginTransaction()
            .replace(R.id.fr_main, fr)
            .commitAllowingStateLoss()
    }
    private fun putBundle(fr : Fragment ,bundle : Bundle , title : String, singer : String){
        Log.d("putBundle 값","$title $singer")
        bundle.putString("title", title)
        bundle.putString("singer", singer)
        goNextPage(fr,bundle)
    }

}