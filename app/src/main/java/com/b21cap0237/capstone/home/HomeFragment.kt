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
import androidx.recyclerview.widget.RecyclerView
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.databinding.ActivityMainBinding
import com.b21cap0237.capstone.databinding.FragmentHomeBinding
import com.b21cap0237.capstone.home.adapter.MenuListAdapter
import com.b21cap0237.capstone.home.model.ListMenu


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var rvMenu: RecyclerView
    private var list: ArrayList<ListMenu> = arrayListOf()
    private lateinit var dataTitle: Array<String>
    private lateinit var dataIc: TypedArray
    private  lateinit var menuListAdapter: MenuListAdapter
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