//Created by canVarli on 1/19/2025

package com.ismailcanvarli.moviebank.ui.screens.home

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ismailcanvarli.moviebank.R

@Composable
fun SearchBar(
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = searchQuery,
        onValueChange = onSearchQueryChange,
        placeholder = { Text(text = stringResource(R.string.search_placeholder)) },
        singleLine = true,
        modifier = modifier
    )
}