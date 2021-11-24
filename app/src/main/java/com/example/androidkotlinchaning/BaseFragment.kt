package com.example.androidkotlinchaning

import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {

    fun replaceFragment (fragment: Fragment) {
        activity?.supportFragmentManager!!
            .beginTransaction()
            .replace(R.id.fragment, fragment, "tag")
            .addToBackStack("")
            .commit()
    }
}