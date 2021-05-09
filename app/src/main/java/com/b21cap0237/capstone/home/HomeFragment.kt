package com.b21cap0237.capstone.home

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.databinding.ActivityMainBinding
import com.b21cap0237.capstone.databinding.FragmentHomeBinding
import com.b21cap0237.capstone.home.adapter.MenuListAdapter
import com.b21cap0237.capstone.home.adapter.NotifListAdapter
import com.b21cap0237.capstone.home.model.ListMenu
import com.b21cap0237.capstone.home.model.Notif


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var rvMenu: RecyclerView
    private var list: ArrayList<ListMenu> = arrayListOf()
    private var listNotif: ArrayList<Notif> = arrayListOf()
    private lateinit var dataTitle: Array<String>
    private lateinit var dataIc: TypedArray
    private lateinit var dataid:Array<String>
    private lateinit var datatitleNotif:Array<String>
    private lateinit var dataimgUrl:Array<String>
    private lateinit var datadateNotif:Array<String>
    private lateinit var datalocationNotif:Array<String>
    private  lateinit var menuListAdapter: MenuListAdapter
    private lateinit var notifListAdapter: NotifListAdapter
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
        rvMenu.layoutManager = GridLayoutManager(context,4)
        menuListAdapter = MenuListAdapter(list)
        list.addAll(getListMenu())
        rvMenu.adapter = menuListAdapter
        menuListAdapter.setOnItemClickCallback(object :MenuListAdapter.OnItemClickCallback{
            override fun onItemClicked(data: ListMenu) {
                val intent: Intent
                when(data.title){
                    getString(R.string.bangunan_rusak)->{
                        Toast.makeText(context, getString(R.string.bangunan_rusak), Toast.LENGTH_SHORT).show()
                    }
                    getString(R.string.jalur_cepat)->{
                        Toast.makeText(context, getString(R.string.jalur_cepat), Toast.LENGTH_SHORT).show()
                    }
                    getString(R.string.lapor)->{
                        Toast.makeText(context, getString(R.string.lapor), Toast.LENGTH_SHORT).show()
                    }
                    getString(R.string.info_detail)->{
                        Toast.makeText(context, getString(R.string.info_detail), Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

        binding.rvNotif.setHasFixedSize(true)
        binding.rvNotif.layoutManager=LinearLayoutManager(context)
        notifListAdapter = NotifListAdapter(listNotif)
        listNotif.addAll(getListNotif())
        binding.rvNotif.adapter=notifListAdapter
    }
    private fun getListNotif(): ArrayList<Notif> {
        val listData= ArrayList<Notif>()
        dataid = resources.getStringArray(R.array.id_notif)
        datatitleNotif = resources.getStringArray(R.array.title_notif)
        dataimgUrl = resources.getStringArray(R.array.URL_notif)
        datadateNotif = resources.getStringArray(R.array.date_notif)
        datalocationNotif = resources.getStringArray(R.array.location_notif)
        for(position in dataTitle.indices){
            val notif=Notif(
                dataid[position],
                datatitleNotif[position],
                dataimgUrl[position],
                datadateNotif[position],
                datalocationNotif[position]
            )
            listData.add(notif)
        }
        return listData
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