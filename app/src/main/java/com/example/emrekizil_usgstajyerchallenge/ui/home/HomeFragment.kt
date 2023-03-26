package com.example.emrekizil_usgstajyerchallenge.ui.home


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.emrekizil_usgstajyerchallenge.R
import com.example.emrekizil_usgstajyerchallenge.databinding.ActivityMainBinding
import com.example.emrekizil_usgstajyerchallenge.databinding.FragmentHomeBinding
import com.example.emrekizil_usgstajyerchallenge.ui.MainActivity

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

    var isLoading = false
    var isLastPage = false
    var isScrolling = false

    var pageNumber = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater).apply {
            locationListRecyclerView.adapter = adapter
            locationListRecyclerView.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
            locationListRecyclerView.addOnScrollListener(this@HomeFragment.scrollListener)
        }
        (activity as MainActivity).homeFragment()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.characterListRecyclerView.adapter = characterAdapter
        binding.characterListRecyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        viewModel.getLocations(pageNumber)
        observeLocationUiState()
        observeCharacterUiState()
    }


    private fun observeLocationUiState() {
        viewModel.locationResponse.observe(viewLifecycleOwner){
            when(it){
                is HomeUiState.Error->{
                    Toast.makeText(requireContext(),getString(it.message),Toast.LENGTH_SHORT).show()
                    isLoading = false
                }
                is HomeUiState.Loading->{
                    Toast.makeText(requireContext(),"Loading Locations",Toast.LENGTH_SHORT).show()
                    isLoading = true
                }
                is HomeUiState.Success->{
                    isLoading = false
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

    val scrollListener = object : RecyclerView.OnScrollListener(){
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            val layoutManager = recyclerView.layoutManager as LinearLayoutManager
            val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
            val visibleItemCount = layoutManager.childCount
            val totalItemCount = layoutManager.itemCount

            val isNotLoadingAndNotLastPage = !isLoading && !isLastPage
            val isAtLastItem = firstVisibleItemPosition + visibleItemCount >= totalItemCount
            val isNotAtBeginning = firstVisibleItemPosition >= 0
            val isTotalMoreThanVisible = totalItemCount >= 20 //Total Response Item
            val shouldPaginate = isNotLoadingAndNotLastPage && isAtLastItem && isNotAtBeginning &&
                    isTotalMoreThanVisible && isScrolling
            if(shouldPaginate){
                isScrolling= false
                pageNumber++
                viewModel.getLocations(pageNumber)
                recyclerView.scrollToPosition(0)
            }
            if (!recyclerView.canScrollVertically(-1) && isScrolling ) {
                Log.d("-----","start");

            }
        }

        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                isScrolling = true
            }
        }
    }


}