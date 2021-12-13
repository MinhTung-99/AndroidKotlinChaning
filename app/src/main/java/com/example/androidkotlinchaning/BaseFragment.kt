package com.example.androidkotlinchaning

import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {
    private val customProgressDialogFragment = CustomProgressDialogFragment()

    protected fun showProgressDialog(show: Boolean) {
        if (show) {
            if (!customProgressDialogFragment.isShowing) {
                customProgressDialogFragment.isShowing = true;
                activity?.let { customProgressDialogFragment.show(it?.supportFragmentManager, "") }
            }
        } else {
            if (customProgressDialogFragment.isShowing) {
                customProgressDialogFragment.dismiss()
                customProgressDialogFragment.isShowing = false
            }
        }
    }
}