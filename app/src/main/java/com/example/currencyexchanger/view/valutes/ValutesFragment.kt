package com.example.currencyexchanger.view.valutes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyexchanger.databinding.ValutesFragmentBinding
import com.example.currencyexchanger.presenter.valutes.MyAdapter
import com.example.currencyexchanger.presenter.valutes.CurrencyPresenter
import com.example.currencyexchanger.presenter.valutes.CurrencyPresenterInterface

class ValutesFragment: Fragment(), ValuteViewInterface {

    private var _binding: ValutesFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var presenter: CurrencyPresenterInterface
    private lateinit var lastUpdateTime: TextView
    private lateinit var dateFiled: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ValutesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        lastUpdateTime = binding.lastUpdateTimeFiled
        dateFiled = binding.dateField

        presenter = CurrencyPresenter(this)

        binding.refreshBtn.setOnClickListener { presenter.refreshData() }
    }

    override fun getActivityLifecycle(): Lifecycle {
        return lifecycle
    }

    override fun setAdapter(adapter: MyAdapter) {
        recyclerView.adapter = adapter
    }

    override fun displayTime(time: String) {
        lastUpdateTime.text = time
    }

    override fun displayDate(date: String) {
        dateFiled.text = date
    }

    override fun toString(): String {
        return "Список"
    }
}