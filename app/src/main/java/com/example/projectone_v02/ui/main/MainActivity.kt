package com.example.projectone_v02.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.example.projectone_v02.R
import com.example.projectone_v02.databinding.ActivityMainBinding
import com.example.projectone_v02.databinding.RowMedalBinding
import com.example.projectone_v02.ui.main.adapter.AchievementAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initObserver()
    }

    private fun initObserver() {

        viewModel.getAchievementsSuccessLiveData.observe(this){response->
            binding.rvAchievements.adapter = AchievementAdapter(response)
        }
        viewModel.getAchievementsErrorLiveData.observe(this){e->
            Toast.makeText(this,"error: "+e.message.toString(),Toast.LENGTH_SHORT).show()
        }
        viewModel.getAchievementsLoadingLiveData.observe(this){e->
            binding.progressCircular.isVisible = e
        }
    }
}