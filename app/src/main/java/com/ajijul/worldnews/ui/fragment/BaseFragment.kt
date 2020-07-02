package com.ajijul.worldnews.ui.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.ajijul.worldnews.ui.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class BaseFragment constructor(layoutId : Int) : Fragment(layoutId) {

    protected val viewModel by activityViewModels<NewsViewModel>()

}