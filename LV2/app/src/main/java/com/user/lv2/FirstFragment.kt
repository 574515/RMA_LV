package com.user.lv2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.user.lv2.databinding.FragmentFirstBinding
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ffBtn.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        val imgMoney = R.drawable.money
        val imgNoMoney = R.drawable.no_money
        ffIV.setImageResource(imgNoMoney)

        ffSwitch.setOnCheckedChangeListener { _, isChecked ->
            ffIV.setImageResource(if(isChecked) imgMoney else imgNoMoney)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}