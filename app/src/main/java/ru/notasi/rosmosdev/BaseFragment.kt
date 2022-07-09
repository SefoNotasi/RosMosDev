package ru.notasi.rosmosdev

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * https://stackoverflow.com/a/68498896
 * How using ViewBinding with an abstract base class.
 */

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    // This property is only valid between onCreateView and onDestroyView.
    private var _binding: VB? = null
    protected val binding get() = _binding!!

    abstract fun inflateLayout(inflater: LayoutInflater, container: ViewGroup?): VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflateLayout(inflater = inflater, container = container)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}