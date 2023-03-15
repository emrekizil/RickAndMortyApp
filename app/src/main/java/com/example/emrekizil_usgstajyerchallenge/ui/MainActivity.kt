package com.example.emrekizil_usgstajyerchallenge.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.emrekizil_usgstajyerchallenge.R
import com.example.emrekizil_usgstajyerchallenge.domain.module.RickAndMortyEntity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainViewModel> ()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("kekod")
        viewModel.getLocations()
        observeUiState()

    }

    private fun observeUiState() {
       viewModel.locationResponse.observe(this){
           println("yes")
            when(it){
                is UiState.Success->{
                    println("no")
                    handleSuccessUiState(it.data)
                }
                is UiState.Error->{
                    println("erer")
                }
                is UiState.Loading->{
                    println("dğpfğpdsfdsf")
                }
            }
       }
    }

    private fun handleSuccessUiState(data: List<RickAndMortyEntity>) {
        println(data[0].name+"sdasdasd")

    }
}