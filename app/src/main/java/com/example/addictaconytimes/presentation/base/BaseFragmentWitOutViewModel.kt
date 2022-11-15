package com.example.addictaconytimes.presentation.base

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragmentWitOutViewModel<DataBinding : ViewDataBinding>(
    @LayoutRes layoutId: Int,
) : Fragment(layoutId) {


    private var onBackPressedCallback: OnBackPressedCallback? = null


    private var internalDataBinding: DataBinding? = null
    protected val dataBinding: DataBinding
        get() {
            return internalDataBinding ?: throw IllegalStateException(
                "data binding should not be requested before onViewCreated is called"
            )
        }

    fun addOnBackPressed(
        isEnabled: Boolean = false,
        onBackPressed: () -> Unit = { requireActivity().finish() },
    ) {
        onBackPressedCallback?.isEnabled = isEnabled

        if (onBackPressedCallback == null) {
            onBackPressedCallback =
                object : OnBackPressedCallback(isEnabled /* disabled by default */) {
                    override fun handleOnBackPressed() {
                        onBackPressed.invoke()
                    }
                }
            requireActivity().onBackPressedDispatcher.addCallback(this, onBackPressedCallback!!)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        internalDataBinding = DataBindingUtil.bind<DataBinding>(view)?.apply {
            lifecycleOwner = this@BaseFragmentWitOutViewModel
        }



    }





    override fun onDestroyView() {
        // Scoped to the lifecycle of the fragment's view (between onCreateView and onDestroyView)
        internalDataBinding = null
        super.onDestroyView()
    }

}