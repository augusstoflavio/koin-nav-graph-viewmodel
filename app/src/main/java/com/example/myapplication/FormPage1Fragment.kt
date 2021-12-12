package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentFormPage1Binding
import org.koin.androidx.navigation.koinNavGraphViewModel

class FormPage1Fragment: Fragment() {

    val formViewModel: FormViewModel by koinNavGraphViewModel(R.id.nav_form)
    private var _binding: FragmentFormPage1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFormPage1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupActions()
        setupObservers()
    }

    private fun setupObservers() {
        formViewModel.currentValue.observe(viewLifecycleOwner) {
            binding.txtCurrentValue.text = it
        }
    }

    private fun setupActions() {
        with(binding) {
            btnChangeValue.setOnClickListener {
                findNavController().navigate(FormPage1FragmentDirections.actionFormPage1FragmentToFormPage2Fragment())
            }

            btnExit.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }
}