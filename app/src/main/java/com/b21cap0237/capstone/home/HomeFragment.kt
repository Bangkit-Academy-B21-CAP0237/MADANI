package com.b21cap0237.capstone.home

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.b21cap0237.capstone.MainActivity
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.databinding.ActivityMainBinding
import com.b21cap0237.capstone.databinding.FragmentHomeBinding
import com.b21cap0237.capstone.home.adapter.MenuListAdapter
import com.b21cap0237.capstone.home.adapter.NotifListAdapter
import com.b21cap0237.capstone.home.model.ListMenu
import com.b21cap0237.capstone.home.model.Notif
import com.b21cap0237.capstone.home.viewmodel.HomeViewModel
import com.b21cap0237.capstone.infodetail.InfoDetailActivity
import com.b21cap0237.capstone.lapor.LaporActivity
import com.b21cap0237.capstone.mapBangunan.ListBangunanActivity
import com.b21cap0237.capstone.mapBangunan.MapBangunan
import com.b21cap0237.capstone.mapBangunan.viewmodel.BangunanViewModel
import com.b21cap0237.capstone.mapJalur.ListJalurActivity
import com.b21cap0237.capstone.mapJalur.MapJalurActivity
import com.b21cap0237.capstone.notif.NotifDetailActivity
import com.b21cap0237.capstone.notif.NotifDetailActivity.Companion.EXTRA_NOTIF


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var rvMenu: RecyclerView
    private var list: ArrayList<ListMenu> = arrayListOf()

    private lateinit var dataTitle: Array<String>
    private lateinit var dataIc: TypedArray


    private lateinit var menuListAdapter: MenuListAdapter
    private lateinit var notifListAdapter: NotifListAdapter

    private lateinit var homeViewModel: HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentHomeBinding.bind(view)
        rvMenu=binding.rvMenu
        rvMenu.setHasFixedSize(true)
        rvMenu.layoutManager = GridLayoutManager(context,3)
        menuListAdapter = MenuListAdapter(list)
        list.addAll(getListMenu())
        rvMenu.adapter = menuListAdapter

        homeViewModel= ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(HomeViewModel::class.java)
        menuListAdapter.setOnItemClickCallback(object :MenuListAdapter.OnItemClickCallback{
            override fun onItemClicked(data: ListMenu) {
                when(data.title){
                    getString(R.string.bangunan_rusak)->{
                        Toast.makeText(context, getString(R.string.bangunan_rusak), Toast.LENGTH_SHORT).show()
                        startActivity(Intent(context, ListBangunanActivity::class.java))
                    }
                    getString(R.string.jalur_cepat)->{
                        Toast.makeText(context, getString(R.string.jalur_cepat), Toast.LENGTH_SHORT).show()
                        startActivity(Intent(context, ListJalurActivity::class.java))
                    }
                    getString(R.string.lapor)->{
                        Toast.makeText(context, getString(R.string.lapor), Toast.LENGTH_SHORT).show()
                        startActivity(Intent(context, LaporActivity::class.java))
                    }
                    getString(R.string.info_detail)->{
                        Toast.makeText(context, getString(R.string.info_detail), Toast.LENGTH_SHORT).show()
                        startActivity(Intent(context, InfoDetailActivity::class.java))
                    }
                }
            }
        })

        showNotif()
    }
    private fun  showNotif(){
        homeViewModel.setNotif()
        homeViewModel.getNotif().observe(viewLifecycleOwner,{data->
            binding.rvNotif.setHasFixedSize(true)
            binding.rvNotif.layoutManager=LinearLayoutManager(context)
            notifListAdapter = NotifListAdapter(data)
            binding.rvNotif.adapter=notifListAdapter

            notifListAdapter.setOnItemClickCallback(object :NotifListAdapter.OnItemClickCallback{
                override fun onItemClicked(data: Notif) {
                    Log.d("showNotif", data.toString())
                    Toast.makeText(context, data.title, Toast.LENGTH_SHORT).show()
                    val intent= Intent(context, NotifDetailActivity::class.java)
                    intent.putExtra(EXTRA_NOTIF,data)
                    startActivity(intent)
                }
            })
        })

    }

    private fun getListMenu(): ArrayList<ListMenu> {
        val listMenu= ArrayList<ListMenu>()
        dataTitle = resources.getStringArray(R.array.data_title)
        dataIc = resources.obtainTypedArray(R.array.data_ic)
        for(position in dataTitle.indices){
            val menu=ListMenu(
                dataTitle[position],
                dataIc.getResourceId(position, -1)
            )
            listMenu.add(menu)
        }
        return listMenu
    }
}