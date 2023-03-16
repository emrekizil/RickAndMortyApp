package com.example.emrekizil_usgstajyerchallenge.ui.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.emrekizil_usgstajyerchallenge.databinding.FragmentHomeBinding
import com.example.emrekizil_usgstajyerchallenge.domain.module.RickAndMortyEntity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel by viewModels<HomeViewModel> ()

    private lateinit var binding:FragmentHomeBinding

    private val adapter = LocationAdapter{
        locationHomeUiData -> adapterOnClick(locationHomeUiData)
    }

    private fun adapterOnClick(locationHomeUiData: LocationHomeUiData) {
        println(locationHomeUiData.residents)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater).apply {
            locationListRecyclerView.adapter = adapter
            locationListRecyclerView.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getLocations()
        observeUiState()
    }

    private fun observeUiState() {
        viewModel.locationResponse.observe(viewLifecycleOwner){
            when(it){
                is HomeUiState.Error->{
                    Toast.makeText(requireContext(),getString(it.message),Toast.LENGTH_SHORT).show()
                }
                is HomeUiState.Loading->{
                    Toast.makeText(requireContext(),"Loading Locations",Toast.LENGTH_SHORT).show()

                }
                is HomeUiState.Success->{
                    handleSuccessUiState(it.data)
                }
            }
        }
    }

    private fun handleSuccessUiState(data: List<LocationHomeUiData>) {
        adapter.updateItems(data)
    }


}