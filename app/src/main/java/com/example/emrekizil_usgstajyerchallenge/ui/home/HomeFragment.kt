package com.example.emrekizil_usgstajyerchallenge.ui.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.emrekizil_usgstajyerchallenge.databinding.FragmentHomeBinding

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel by viewModels<HomeViewModel> ()

    private lateinit var binding: FragmentHomeBinding

    private val adapter = LocationAdapter{
        locationHomeUiData -> adapterOnClickLocation(locationHomeUiData)
    }

    private val characterAdapter = CharacterAdapter{
        characterHomeUiData -> adapterOnClickCharacter(characterHomeUiData)
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
        binding.characterListRecyclerView.adapter = characterAdapter
        binding.characterListRecyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        viewModel.getLocations()
        observeLocationUiState()
        observeCharacterUiState()
    }


    private fun observeLocationUiState() {
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

    private fun observeCharacterUiState() {
        viewModel.characterResponse.observe(viewLifecycleOwner){
            when(it){
                is HomeUiState.Error->{
                    Toast.makeText(requireContext(),getString(it.message),Toast.LENGTH_SHORT).show()
                }
                is HomeUiState.Loading->{
                    Toast.makeText(requireContext(),"Loading Characters",Toast.LENGTH_SHORT).show()
                }
                is HomeUiState.Success->{
                    handleSuccessCharacterUiState(it.data)
                }
            }
        }
    }

    private fun handleSuccessCharacterUiState(data: List<CharacterHomeUiData>) {
        characterAdapter.updateItems(data)
    }


    private fun handleSuccessUiState(data: List<LocationHomeUiData>) {
        adapter.updateItems(data)
    }

    private fun adapterOnClickLocation(locationHomeUiData: LocationHomeUiData) {
        viewModel.getCharactersById(locationHomeUiData.residents)
    }
    private fun adapterOnClickCharacter(characterHomeUiData: CharacterHomeUiData) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(characterHomeUiData)
        findNavController().navigate(action)
    }


}