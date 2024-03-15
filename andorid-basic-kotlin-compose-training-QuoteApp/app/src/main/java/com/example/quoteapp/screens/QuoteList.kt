package com.example.quoteapp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.example.quoteapp.Quote

@Composable
fun QuoteLists(data: Array<Quote>, onClick: (quote:Quote) -> Unit) {
    LazyColumn {
        items(data.size) { index ->
            QuoteListItem(quote = data[index],onClick)
        }
    }
}