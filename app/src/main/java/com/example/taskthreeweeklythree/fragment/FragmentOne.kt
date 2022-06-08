package com.example.taskthreeweeklythree.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.taskthreeweeklythree.databinding.FragmentOneBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import java.math.BigDecimal


class FragmentOne : Fragment() {
    private var resultOne = BigDecimal(3)
    private var resultTwo = BigDecimal(4)
    private var counterOne: Double = 0.0
    private var counterTwo: Double = 0.0
    private var showOne = ""
    private var showTwo = ""
    private var formula: Double = 0.0
    private var countTwo = 0
    private var divider = 1

    private lateinit var binding: FragmentOneBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOneBinding.inflate(inflater, container, false)
        main()
        return binding.root
    }

    private fun main() {
        GlobalScope.launch {
            val coroutineFlow = oneFlow()
            coroutineFlow.collect {}
        }
        GlobalScope.launch {
            val coroutineFlow2 = twoFlow()
            coroutineFlow2.collect {}
        }
    }

    private fun oneFlow() = flow {
        emit(100)
        while (true) {
            counterOne += 1
            if (counterOne % 2 == 1.0) {
                formula = counterOne * 2 * (counterOne * 2 + 1) * (counterOne * 2 + 2)
                resultOne += (BigDecimal(4).divide(BigDecimal(formula), 300, 0))

            } else {
                formula = counterOne * 2 * (counterOne * 2 + 1) * (counterOne * 2 + 2)
                resultOne -= (BigDecimal(4).divide(BigDecimal(formula), 300, 0))
            }

            showOne = resultOne.toString()
            if (counterOne % 10000 == 0.0) {
                binding.tvOne.text = showOne
            }
        }

    }.flowOn(Dispatchers.IO)

    private fun twoFlow() = flow {
        emit(100)
        while (true) {
            counterTwo += 1
            if (countTwo % 2 == 0) {
                resultTwo -= (BigDecimal(4).divide(BigDecimal(divider + 2), 300, 0))

            } else {
                resultTwo += (BigDecimal(4).divide(BigDecimal(divider + 2), 300, 0))
            }
            showTwo = resultTwo.toString()
            divider += 2

            if (counterTwo % 10000 == 0.0) {
                binding.tvTwo.text = showTwo
            }
            countTwo++
        }

    }.flowOn(Dispatchers.IO)

    companion object {
        @JvmStatic
        fun newInstance() = FragmentOne()
    }
}