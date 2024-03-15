package com.example.quoteapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.quoteapp.Quote

@Composable
fun QuoteListScreen(data: Array<Quote>, onClick: (quote:Quote) -> Unit) {

    Column {
        Text(
            text = "My Quote App",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(1f).padding(8.dp,24.dp),
            style = MaterialTheme.typography.headlineSmall
        )
        QuoteLists(data = data,onClick)
    }
}