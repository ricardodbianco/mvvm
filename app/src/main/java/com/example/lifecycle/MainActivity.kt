package com.example.lifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.activity.viewModels
import com.example.lifecycle.databinding.ActivityMainBinding
import com.example.lifecycle.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

       val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            // TODO
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}

/* O que é MVVM (Model-View-ViewModel)? É um padrão de projetos criado por arquitetos
da Microsoft, que é utilizado para separar a lógica do software e os controles de interface
do usuário. MVVM ajuda a organizar o código, quebrando o software em camadas, fazendo com que
a manutenção e reuso do código sejam mais fácil e rápido.

- Model: é onde fica a lógica do software, é a dependência da ViewModel que recebe e envia dados
para que ela trate e interaja com a View e entrada do usuário.

- View: View são os elementos visíveis e que podem receber interação com as entradas do usuário.
No Android, geralmente nos referimos à Activty, Fragments e os componentes que estendem a classe
android.view.View (exemplo: TextView, EditText, ImageView, etc).

- ViewModel: fica entre as camadas View e Model, é onde estão os controles para interagir com a View
e expões controles para que a viu possa interagir com ela também. */
