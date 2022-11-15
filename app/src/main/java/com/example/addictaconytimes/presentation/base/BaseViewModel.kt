package com.example.addictaconytimes.presentation.base

import androidx.lifecycle.ViewModel
import com.example.addictaconytimes.utils.SingleLiveEvent

abstract class BaseViewModel : ViewModel() {
    val isLoading: SingleLiveEvent<Boolean> = SingleLiveEvent()
    val showToast: SingleLiveEvent<String> = SingleLiveEvent()
}