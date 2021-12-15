package com.example.androidkotlinchaning

import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {
    private var customProgressDialogFragment: CustomProgressDialogFragment? = null

    protected fun showProgress () {
        customProgressDialogFragment = CustomProgressDialogFragment()
        activity?.let { customProgressDialogFragment?.show(it?.supportFragmentManager, "") }
    }

    protected fun hideProgress () {
        customProgressDialogFragment?.dismiss()
        customProgressDialogFragment = null
    }
}