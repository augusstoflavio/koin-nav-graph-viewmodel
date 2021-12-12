package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentFormPage2Binding
import org.koin.androidx.navigation.koinNavGraphViewModel

class FormPage2Fragment: Fragment() {

    val formViewModel: FormViewModel by koinNavGraphViewModel(R.id.nav_form)
    private var _binding: FragmentFormPage2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFormPage2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.iptCurrentValue.setText(formViewModel.currentValue.value)
        setupActions()
    }

    private fun setupActions() {
        with(binding) {
            btnBack.setOnClickListener {
                findNavController().popBackStack()
            }

            iptCurrentValue.doOnTextChanged { text, _, _, _ ->
                formViewModel.setValue(text.toString())
            }
        }
    }
}