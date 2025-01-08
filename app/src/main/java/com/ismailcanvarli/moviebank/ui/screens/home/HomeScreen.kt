//Created by canVarli on 1/2/2025

package com.ismailcanvarli.moviebank.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel) {
    // StateFlow'dan gelen veriyi dinliyoruz
    val movieList by viewModel.movieList.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(movieList) { movie ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = movie.name)
                    Text(text = "Director: ${movie.director}")
                    Text(text = "Year: ${movie.year}")

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = {
                        navController.navigate("movieDetailScreen/${movie.id}")
                    }) {
                        Text("View Details")
                    }
                }
            }
        }
    }
}