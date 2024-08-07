package com.example.practice.ui.song

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practice.data.local.SongDatabase
import com.example.practice.data.entity.Album
import com.example.practice.databinding.FragmentSelectSongBinding

class SelectSong : Fragment() {
    private var selectDatas = ArrayList<Album>()
    lateinit var selectAdapter : SongRVAdapter
    private lateinit var binding : FragmentSelectSongBinding
    lateinit var albumDB: SongDatabase
    private var albumDatas = ArrayList<Album>()
    private var one = 1
    override fun onPause() {
        super.onPause()
//        save()
    }
    override fun onResume() {
        super.onResume()
//        val sharedPreferences = requireActivity().getSharedPreferences("album", MODE_PRIVATE)
//        val jsonText = sharedPreferences.getString("albumList", null)
//        val gson = Gson()
//        if (jsonText != null) {
//            val type = object : TypeToken<ArrayList<Album>>() {}.type
//            selectDatas = gson.fromJson(jsonText, type)
//        }
//        selectAdapter.setData(selectDatas)
//        Log.d("start굿",selectAdapter.itemCount.toString())
    }
//    private fun save(){
//        val sharedPreferences = requireActivity().getSharedPreferences("album", MODE_PRIVATE)
//        val editor = sharedPreferences.edit()
//        val gson = Gson()
//        val jsonText = gson.toJson(selectDatas)
//        editor.putString("albumList", jsonText)
//        editor.apply()
//        Log.d("pause굿",selectAdapter.itemCount.toString())
//    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelectSongBinding.inflate(inflater, container, false)
        albumDB = SongDatabase.getInstance(requireContext())!!
        albumDatas.addAll(albumDB.albumDao().getAlbums())

//        selectDatas.apply {
//            add(Album("Butter", "방탄소년단 (BTS)", R.drawable.img_album_exp))
//            add(Album("Lilac", "아이유 (IU)", R.drawable.img_album_exp2))
//            add(Album("AESPA", "에스파 (AESPA)", R.drawable.img_album_exp3))
//            add(Album("Boy with Luv", "방탄소년단 (BTS)", R.drawable.img_album_exp4))
//            add(Album("BBoom BBoom", "모모랜드 (MOMOLAND)", R.drawable.img_album_exp5))
//            add(Album("Weekend", "태연 (Tae Yeon)", R.drawable.img_album_exp6))
//            add(Album("Butter", "방탄소년단 (BTS)", R.drawable.img_album_exp))
//            add(Album("Lilac", "아이유 (IU)", R.drawable.img_album_exp2))
//            add(Album("Lilac", "에스파 (AESPA)", R.drawable.img_album_exp3))
//            add(Album("Boy with Luv", "방탄소년단 (BTS)", R.drawable.img_album_exp4))
//            add(Album("BBoom BBoom", "모모랜드 (MOMOLAND)", R.drawable.img_album_exp5))
//            add(Album("Weekend", "태연 (Tae Yeon)", R.drawable.img_album_exp6))
//        }
        selectAdapter = SongRVAdapter(selectDatas)
        binding.rvSelect.adapter = selectAdapter
        binding.rvSelect.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        Log.d("create굿",selectAdapter.itemCount.toString())
        selectAdapter.setMyItemClickListener(object : SongRVAdapter.MyItemClickListener {
            override fun onItemClick(item: Album) {
                TODO("Not yet implemented")
            }
            override fun onRemoveAlbum(position: Int) {
                selectAdapter.removeItem(position)
            }
            override fun onToggle(position: Int) {
                selectAdapter.toggleItem(position)
//                save()

            }
        })
        return binding.root
    }

//    private fun playLikeState(state: Boolean) {
//        songs[nowPos].isLike = !state
//        songDB.songDao().updateIsLikeById(!state, songs[nowPos].id)
//        with(binding) {
//            if (!state) {
//                binding.songLikeBtn.setImageResource(R.drawable.ic_my_like_on)
//            } else {
//                binding.songLikeBtn.setImageResource(R.drawable.ic_my_like_off)
//            }
//        }
//    }
}
