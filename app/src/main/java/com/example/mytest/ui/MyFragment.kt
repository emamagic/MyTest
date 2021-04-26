package com.example.mytest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mytest.databinding.FragmentMyBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
class MyFragment: Fragment() {

    private var _binding: FragmentMyBinding? = null
    private val binding get() = _binding
    private val list: ArrayList<String> by lazy { ArrayList() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyBinding.inflate(inflater ,container ,false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btnSubmit?.setOnClickListener {
            val name = binding?.edtName?.text.toString()
            val family = binding?.edtFamily?.text.toString()
            Toast.makeText(requireContext(), "$name  $family", Toast.LENGTH_SHORT).show()
            binding?.txtResult?.text = "Successfully"
        }

        runBlocking {
            val list = foo1()
            for (x in list) println(x)

            // when we called channel is activated
            val channel = foo2()
            for (x in channel) println(x)

            // when we called collect is activated
            val flow = foo3()
            flow.collect { x -> println(x) }

        }
    }

    private suspend fun foo1(): List<String> = buildList {
        list.add("a")
        list.add("b")
        list.add("c")
    }

    private fun CoroutineScope.foo2(): ReceiveChannel<String> = produce {
        send("a")
        send("b")
        send("c")
    }

    private fun foo3(): Flow<String> = flow {
        emit("a")
        emit("b")
        emit("v")
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}