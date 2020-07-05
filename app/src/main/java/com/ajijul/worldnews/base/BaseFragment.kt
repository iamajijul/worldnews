package com.ajijul.worldnews.base

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.ajijul.givemeforcast.utils.base.MessageHandlerImp
import com.ajijul.worldnews.ui.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
open class BaseFragment constructor(layoutId : Int) : Fragment(layoutId) {

    protected val viewModel by activityViewModels<NewsViewModel>()
    @Inject
    lateinit var messageHandlerImp: MessageHandlerImp

    protected val mainView: View by lazy {
        requireView()

    }
}