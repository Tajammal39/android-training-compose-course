package com.example.quoteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.quoteapp.screens.QuoteDetail
import com.example.quoteapp.screens.QuoteList
import com.example.quoteapp.screens.QuoteListItem
import com.example.quoteapp.screens.QuoteListScreen
import com.example.quoteapp.ui.theme.QuoteAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadAssetsFromFile(applicationContext)
        }
        setContent {
            QuoteAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }

    @Preview
    @Composable
    fun App() {
        if (DataManager.isDataLoaded.value) {
            if (DataManager.isCurrentPage.value == Pages.LISTING) {
                QuoteListScreen(data = DataManager.data) {
                    DataManager.switchPages(it)
                }
            }
            else{
                DataManager.currentQuote?.let { QuoteDetail(quote = it) }
            }

        } else {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize(1f)) {
                Text(text = "Loading....", style = MaterialTheme.typography.headlineMedium)
            }
        }
    }

    enum class Pages {
        LISTING,
        DETAIL
    }
}
