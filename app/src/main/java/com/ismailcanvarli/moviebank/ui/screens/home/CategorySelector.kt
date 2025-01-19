//Created by canVarli on 1/19/2025

package com.ismailcanvarli.moviebank.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CategorySelector(
    categories: Map<String, String>, selectedCategory: String, onCategorySelected: (String) -> Unit
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        items(categories.keys.toList()) { key ->
            val categoryText = categories[key] ?: ""
            Text(text = categoryText,
                modifier = Modifier
                    .clickable { onCategorySelected(key) }
                    .background(if (selectedCategory == key) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface)
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                color = if (selectedCategory == key) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface)
        }
    }
}