package com.example.mytest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mytest.databinding.FragmentMyBinding

class MyFragment: Fragment() {

    private var _binding: FragmentMyBinding? = null
    private val binding get() = _binding

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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}