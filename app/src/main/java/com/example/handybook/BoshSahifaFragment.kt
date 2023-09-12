package com.example.handybook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.handybook.adapter.ProductPagerAdapter
import com.example.handybook.databinding.FragmentBoshSahifaBinding
import com.google.android.material.tabs.TabLayoutMediator

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class BoshSahifaFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private var productType = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadProductType()

        val binding = FragmentBoshSahifaBinding.inflate(inflater, container, false)
        binding.productPager.adapter = ProductPagerAdapter(requireActivity(), productType)
        TabLayoutMediator(binding.productTab, binding.productPager) { tab, position ->
            val view = LayoutInflater.from(container?.context).inflate(R.layout.tablayout,null,false)
            view.findViewById<TextView>(R.id.product_tab_title).text = productType[position]
            tab.setCustomView(view)
        }.attach()

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BoshSahifaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun loadProductType() {
        val list = mutableListOf<String>()
        productType.add("Barchasi")
        productType.add("Samsung")
        productType.add("Apple")
        productType.add("Honor")
        productType.add("Redmi")
        productType.add("Vivo")
        productType.add("Tecno")
        productType.add("Artel")
    }
}