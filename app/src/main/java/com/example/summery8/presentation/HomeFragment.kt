package com.example.summery8.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.summery8.databinding.FragmentHomeBinding
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.viewpager2.widget.ViewPager2


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var imageAdapter: ImageAdapter
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageAdapter = ImageAdapter()
        binding.viewPager2.adapter = imageAdapter

        viewModel.images.observe(viewLifecycleOwner) { images ->
            imageAdapter.submitList(images)
        }
        viewModel.fetchImages()
    }
}
