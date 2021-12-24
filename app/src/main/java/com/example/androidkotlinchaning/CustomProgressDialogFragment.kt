package com.example.androidkotlinchaning

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

class CustomProgressDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.custom_dialog_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDialog()
    }

    private fun setupDialog() {
        if (dialog != null) {
            dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
            dialog?.setCancelable(false)
            dialog?.setCanceledOnTouchOutside(false)
        }
    }

    companion object {
        private val customProgressDialogFragment = CustomProgressDialogFragment()
        private var isShowing = false

        fun show(activity: BaseActivity) {
            if (!isShowing) {
                isShowing = true
                customProgressDialogFragment.show(activity.supportFragmentManager, "")
            }
        }

        fun hide() {
            isShowing = true
            customProgressDialogFragment.dismiss()
        }
    }
}