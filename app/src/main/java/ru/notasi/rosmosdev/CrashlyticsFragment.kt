package ru.notasi.rosmosdev

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.notasi.rosmosdev.databinding.FragmentCrashlyticsBinding
import ru.notasi.rosmosdev.utils.Debugger

class CrashlyticsFragment : BaseFragment<FragmentCrashlyticsBinding>() {

    companion object {
        private val className = CrashlyticsFragment::class.java.simpleName
        fun newInstance() = CrashlyticsFragment()
    }

    override fun inflateLayout(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentCrashlyticsBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonCrash.setOnClickListener { crash() }
        debug()
        debugMessage()
        catchCrash()
    }

    private fun crash(): Nothing = throw RuntimeException("Test crash")

    private fun debug() = Debugger.log(
        threadName = Thread.currentThread().name,
        className = className,
        methodName = object {}.javaClass.enclosingMethod?.name,
        message = "Test debug"
    )

    private fun debugMessage() = Debugger.log(message = "Test debug message")

    private fun catchCrash() = Debugger.log(
        threadName = Thread.currentThread().name,
        className = className,
        methodName = object {}.javaClass.enclosingMethod?.name,
        message = "Test debug",
        throwable = RuntimeException("Test throwable runtime exception")
    )

}