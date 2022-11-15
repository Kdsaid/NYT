package com.example.addictaconytimes.presentation.main

import androidx.lifecycle.ViewModelProvider
import com.example.addictaconytimes.ViewModelProviderFactory
import com.example.addictaconytimes.databinding.ActivityMainBinding

import com.example.addictaconytimes.R
import com.example.addictaconytimes.BR
import com.example.addictaconytimes.presentation.base.BaseActivity
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(),
    HasAndroidInjector {
    @Inject
    lateinit var factory: ViewModelProviderFactory

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_main

    override val viewModel: MainViewModel
        get() = ViewModelProvider(this, factory).get(MainViewModel::class.java)
}