package com.rival.muslim.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.rival.muslim.adapter.NewsAdapter
import com.rival.muslim.data.repository.NewsRepository
import com.rival.muslim.databinding.FragmentCommonBinding
import com.rival.muslim.ui.NewsViewModel
import com.rival.muslim.utils.NewsViewModelFactory


class CommonFragment : Fragment() {

    lateinit var binding: FragmentCommonBinding
    private val commonViewModel: NewsViewModel by viewModels {
        NewsViewModelFactory(NewsRepository())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCommonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mAdapter = NewsAdapter()

        if (commonViewModel.commonMuslimNews.value == null){
            commonViewModel.getCommonMuslimNews()
        }


        commonViewModel.commonMuslimNews.observe(viewLifecycleOwner) { dataNews ->
            mAdapter.setData(dataNews.articles)
            binding.rvCommonNews.apply {
                adapter = mAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
        }

        commonViewModel.isLoading.observe(viewLifecycleOwner){
            isLoading(it)
        }


    }

    private fun isLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.loadingView.root.visibility = View.VISIBLE
        } else {
            binding.loadingView.root.visibility = View.GONE
        }
    }
}