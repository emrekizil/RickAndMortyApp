package com.example.emrekizil_usgstajyerchallenge.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.emrekizil_usgstajyerchallenge.R
import com.example.emrekizil_usgstajyerchallenge.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.customToolbar)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
    fun homeFragment(){
        binding.actionbarImageView.visibility = View.VISIBLE
        binding.actionbarTextView.visibility= View.GONE
        binding.customToolbar.setBackgroundColor(ContextCompat.getColor(this,R.color.load1))
    }
    fun detailFragment(characterName:String){
        binding.actionbarImageView.visibility = View.GONE
        binding.actionbarTextView.visibility = View.VISIBLE
        binding.actionbarTextView.text = characterName
        binding.customToolbar.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
    }


}