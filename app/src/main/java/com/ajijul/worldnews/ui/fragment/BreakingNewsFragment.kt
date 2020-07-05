package com.ajijul.worldnews.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ajijul.givemeforcast.utils.base.MessageHandlerImp
import com.ajijul.worldnews.R
import com.ajijul.worldnews.adapters.NewsAdapter
import com.ajijul.worldnews.base.BaseFragment
import com.ajijul.worldnews.network.ResponseWrapper
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_breaking_news.*
import javax.inject.Inject

class BreakingNewsFragment : BaseFragment(R.layout.fragment_breaking_news) {

    lateinit var newsAdapter: NewsAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpOurRecyclerView()
        observeOurData()

    }

    private fun observeOurData() {
        viewModel.getBreakingNews("us")
        viewModel.observeBreakingNews().observe(viewLifecycleOwner, Observer {
            when (it) {
                is ResponseWrapper.Success -> {
                    handleProgress(false)
                    it.data?.let {
                        newsAdapter.differList.submitList(it.articles)
                    }
                    messageHandlerImp.showSnackSuccess(mainView,R.string.successMessage,true)
                }
                is ResponseWrapper.Error -> {
                    handleProgress(false)
                    messageHandlerImp.showSnackErrorWithAction(mainView,R.string.errorMessage){
                        viewModel.getBreakingNews("us")
                    }

                }
                is ResponseWrapper.Loading -> {
                    handleProgress(true)
                }
            }
        })
    }


    private fun setUpOurRecyclerView() {
        newsAdapter = NewsAdapter()
        rvBreakingNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

    }

    private fun handleProgress(isShow: Boolean) {
        if (isShow) {
            paginationProgressBar.visibility = View.VISIBLE
        } else {
            paginationProgressBar.visibility = View.GONE
        }
    }
}