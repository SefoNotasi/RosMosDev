package ru.notasi.rosmosdev

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.notasi.rosmosdev.databinding.FragmentMainBinding

class MainFragment : BaseFragment<FragmentMainBinding>() {

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun inflateLayout(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentMainBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonCrash.setOnClickListener { crash() }
    }

    private fun crash(): Nothing = throw RuntimeException("Test crash")

}