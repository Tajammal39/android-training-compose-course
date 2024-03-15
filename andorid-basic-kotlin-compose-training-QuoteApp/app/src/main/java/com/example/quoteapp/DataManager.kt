package com.example.quoteapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import java.nio.charset.Charset

object DataManager {
    var data = emptyArray<Quote>()
    var isDataLoaded = mutableStateOf(false)
    var isCurrentPage = mutableStateOf(MainActivity.Pages.LISTING)
    var currentQuote: Quote? = null

    fun loadAssetsFromFile(context: Context) {
        val inputStream = context.assets.open("quote.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)
        isDataLoaded.value = true

    }

    fun switchPages(quote: Quote?) {
        if (isCurrentPage.value == MainActivity.Pages.LISTING) {
            currentQuote = quote
            isCurrentPage.value = MainActivity.Pages.DETAIL
        } else {
            isCurrentPage.value = MainActivity.Pages.LISTING
        }
    }
}