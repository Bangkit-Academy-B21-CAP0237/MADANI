package com.b21cap0237.capstone.kondisiLapangan.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.b21cap0237.capstone.R
import com.b21cap0237.capstone.databinding.FragmentKondisiLapBinding
import com.b21cap0237.capstone.kondisiLapangan.KondisiDetailActivity
import com.b21cap0237.capstone.kondisiLapangan.adapter.KondisiListAdapter
import com.b21cap0237.capstone.kondisiLapangan.model.Kondisi
import com.b21cap0237.capstone.kondisiLapangan.viewmodel.KondisiViewModel
import com.b21cap0237.capstone.notif.NotifDetailActivity


class KondisiLapFragment : Fragment() {
    private lateinit var binding: FragmentKondisiLapBinding
    private lateinit var rvNotif: RecyclerView
    private lateinit var kondisiViewModel: KondisiViewModel
    private lateinit var kondisiListAdapter: KondisiListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kondisi_lap, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentKondisiLapBinding.bind(view)
        kondisiViewModel= ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            KondisiViewModel::class.java)
        showKondisi()
    }
    private fun showKondisi(){
        kondisiViewModel.setKondisi()
        kondisiViewModel.getKondisi().observe(viewLifecycleOwner,{data->
            showLoading(false)
            binding.rvKondisi.setHasFixedSize(true)
            binding.rvKondisi.layoutManager= LinearLayoutManager(context)
            kondisiListAdapter = KondisiListAdapter(data)
            binding.rvKondisi.adapter=kondisiListAdapter

            kondisiListAdapter.setOnItemClickCallback(object :KondisiListAdapter.OnItemClickCallback{
                override fun onItemClicked(data: Kondisi) {
                    Log.d("showKondisi", data.toString())
                    Toast.makeText(context, data.kondisiJudul, Toast.LENGTH_SHORT).show()
                    val intent= Intent(context, KondisiDetailActivity::class.java)
                    intent.putExtra(KondisiDetailActivity.EXTRA_KONDISI,data)
                    startActivity(intent)
                }
            })
        })
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}