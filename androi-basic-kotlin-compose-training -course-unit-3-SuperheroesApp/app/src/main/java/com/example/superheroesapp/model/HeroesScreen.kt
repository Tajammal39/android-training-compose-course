package com.example.superheroesapp.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroesapp.R
import com.example.superheroesapp.model.HeroesRepository.heroes

@Preview
@Composable
fun SuperHeroesApp() {
    SuperHeroes()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperHeroes(modifier: Modifier = Modifier) {
    Scaffold(topBar = {
        TopAppBar()
    }) {
        LazyColumn(contentPadding = it) {
            itemsIndexed(heroes) { _, hero -> // Pass both index and hero
                SuperHeroesItem(
                    hero, modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }

        }
    }


}

@Composable
fun SuperHeroesItem(hero: Hero, modifier: Modifier = Modifier) {
    Card(modifier = modifier, elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .sizeIn(minHeight = 72.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = stringResource(hero.name),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(text = stringResource(hero.desc), style = MaterialTheme.typography.bodyLarge)
            }
            Spacer(Modifier.width(16.dp))
            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(8.dp))
            ) {
                Image(
                    painterResource(id = hero.image),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }
        }
    }

}

@Composable
fun TopAppBar() {
   Row(modifier = Modifier.fillMaxWidth().padding(top = 8.dp, bottom = 8.dp), horizontalArrangement = Arrangement.Center) {
       Text(
           text = stringResource(R.string.app_name),
           style = MaterialTheme.typography.displayLarge, textAlign = TextAlign.Center
       )
   }
}

