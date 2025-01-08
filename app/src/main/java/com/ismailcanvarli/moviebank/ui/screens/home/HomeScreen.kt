//Created by canVarli on 1/2/2025

package com.ismailcanvarli.moviebank.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ismailcanvarli.moviebank.data.model.Movie

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel) {

}

@Composable
fun MovieItem(movie: Movie, navController: NavController) {
    Card(modifier = Modifier
        .padding(4.dp)
        .clickable { navController.navigate("movieDetailScreen/${movie.id}") }) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            // Placeholder for movie image
            Box(
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text("Movie Image")
            }
            Text(text = movie.name)
        }
    }
}

