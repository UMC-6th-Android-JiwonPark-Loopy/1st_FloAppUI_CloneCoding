package com.example.practice

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.practice.databinding.FragmentAlbumBinding

class AlbumFragment : Fragment() {
    private lateinit var binding: FragmentAlbumBinding
    private var isState = false
    private var isSelected = false
    private var isLike = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAlbumBinding.inflate(inflater, container, false)
        with(binding) {
            Log.d("값", "arguments: $arguments")
            Log.d("값", "${arguments?.getString("title")} ${arguments?.getString("singer")}")
            albumTitleTv.text = arguments?.getString("title")
            albumSingerTv.text = arguments?.getString("singer")
            when (albumTitleTv.text.toString()) {
                "LILAC" -> {
                    setAlbumImage(R.drawable.img_album_exp2)
                }

                "NEXT LEVEL" -> {
                    setAlbumImage(R.drawable.img_album_exp3)
                }

                "Map Of The Soul" -> {
                    setAlbumImage(R.drawable.img_album_exp4)
                }

                "BAAM" -> {
                    setAlbumImage(R.drawable.img_album_exp5)
                }

                "Weekend" -> {
                    setAlbumImage(R.drawable.img_album_exp6)
                }
            }
        }
        onClickBackButton()
        return binding.root
    }

    private fun setAlbumImage(drawable: Int) {
        binding.albumPreviewIv.setImageResource(drawable)
    }

    private fun onClickBackButton() {
        with(binding) {
            albumArrowBackIb.setOnClickListener {
                (context as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.fr_main, HomeFragment()).commitAllowingStateLoss()
            }
            albumMyTasteToggleIv.setOnClickListener {
                if (isState) {
                    isState = false
                    it.setBackgroundResource(R.drawable.btn_toggle_on)
                } else {
                    isState = true
                    it.setBackgroundResource(R.drawable.btn_toggle_off)
                }
            }
            albumSelectToggleIv.setOnClickListener {
                if (isSelected) {
                    isSelected = false
                    it.setBackgroundResource(R.drawable.btn_playlist_select_off)
                } else {
                    isSelected = true
                    it.setBackgroundResource(R.drawable.btn_playlist_select_on)
                }
            }

            albumMyLike.setOnClickListener {
                if (isLike) {
                    isLike = false
                    it.setBackgroundResource(R.drawable.ic_my_like_off)
                } else {
                    it.setBackgroundResource(R.drawable.ic_my_like_on)
                }
            }

        }
    }
}