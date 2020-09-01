package com.axiaworks.viewpager2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.axiaworks.viewpager2.databinding.FragmentColorBinding

class ColorFragment: Fragment() {
    companion object {
        private const val ARGS_POSITION = "position"
        fun newInstance (position: Int) = ColorFragment().apply {
            arguments = Bundle().apply {
                putInt(ARGS_POSITION, position)
            }
        }
    }

    private lateinit var binding: FragmentColorBinding

    private val position: Int by lazy {
        arguments?.let {
            it[ARGS_POSITION] as Int
        }?:0
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_color, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.apply {
            when(position) {
                0 -> {
                    tabTextView.setText(R.string.text_red)
                    fragmentColor.setBackgroundResource(R.color.red)
                }
                1 -> {
                    tabTextView.setText(R.string.text_blue)
                    fragmentColor.setBackgroundResource(R.color.blue)
                }
                2 -> {
                    tabTextView.setText(R.string.text_green)
                    fragmentColor.setBackgroundResource(R.color.green)
                }
                else -> {
                    tabTextView.setText(R.string.text_yellow)
                    fragmentColor.setBackgroundResource(R.color.yellow)
                }
            }
        }
    }
}
