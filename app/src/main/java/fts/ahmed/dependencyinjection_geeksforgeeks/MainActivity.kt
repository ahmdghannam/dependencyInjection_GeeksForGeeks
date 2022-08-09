package fts.ahmed.dependencyinjection_geeksforgeeks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var cryptocurrencyList: RecyclerView

    // viewModels() delegate used to get
    // by view models will automatically construct the viewmodels using Hilt
    private val viewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cryptocurrencyList=findViewById<RecyclerView>(R.id.cryptocurrency_list)
        cryptocurrencyList.layoutManager=LinearLayoutManager(this)
        observeCryptoCurrency()

    }

    private fun observeCryptoCurrency() {
        viewModel.cryptoCurrency.observe(this){
            cryptocurrencyList.adapter=CryptocurrencyAdapter(it)
        }
    }

}