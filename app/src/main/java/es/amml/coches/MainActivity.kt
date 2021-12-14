package es.amml.coches

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.amml.coches.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope

class MainActivity : AppCompatActivity() {
    private val coroutineScope = MainScope()
    private val viewModel: MainViewModel = MainViewModel(
        GetCarsUseCase(Dispatchers.IO)
    )
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.state.observe(this) { state ->
            when (state) {
                MainViewModel.State.Loading -> {
                    binding.textView.text = "Loading"
                }
                is MainViewModel.State.Loaded -> {
                    binding.textView.text = "${state.items.count()}Item loaded"
                    //setupIncidenceList(state.items)
                }
                is MainViewModel.State.Error -> {
                    binding.textView.text = "Error: ${state.error.message}"
                }
            }
        }

//        coroutineScope.launch {
//            viewModel.initialState()
//        }
    }
}