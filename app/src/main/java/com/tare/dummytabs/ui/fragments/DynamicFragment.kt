package com.tare.dummytabs.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import com.tare.dummytabs.R
import com.tare.dummytabs.adapter.TabItemsAdapter
import com.tare.dummytabs.databinding.FragmentDynamicBinding
import com.tare.dummytabs.network.Services
import com.tare.dummytabs.pojo.entities.ProductItems
import com.tare.dummytabs.pojo.request.RequestGetTabItems
import com.tare.dummytabs.utils.Constants
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

private const val ARG_PARAM1 = "id"

@AndroidEntryPoint
class DynamicFragment : Fragment() {
    @Inject
    lateinit var services: Services
    private var id: String? = null
    private val data = MutableLiveData<List<ProductItems>>()
    private val adapter = TabItemsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getString(ARG_PARAM1)!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentDynamicBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_dynamic, container, false
        )
        binding.lifecycleOwner = this
        binding.recyclerView.adapter = adapter
        id?.let {
            fetchTabItems(
                RequestGetTabItems(
                    Constants.APIKEY,
                    it,
                    Constants.STOREID,
                    Constants.USERID
                )
            )
        }
        data.observe(viewLifecycleOwner) {
            adapter.update(it)
        }
        return binding.root
    }

    private fun fetchTabItems(requestGetTabItems: RequestGetTabItems) {
        id?.let {
            services.getTabItems(requestGetTabItems)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { res ->
                    val list = mutableListOf<ProductItems>()
                    for (i in res.data) {
                        list.add(i.value)
                    }
                    data.postValue(list)
                }
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(id: String) =
            DynamicFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, id)
                }
            }
    }
}