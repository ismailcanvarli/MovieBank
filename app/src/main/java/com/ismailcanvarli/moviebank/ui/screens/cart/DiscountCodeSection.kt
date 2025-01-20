//Created by canVarli on 1/9/2025

package com.ismailcanvarli.moviebank.ui.screens.cart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ismailcanvarli.moviebank.R
import com.ismailcanvarli.moviebank.common.Constants

/**
 * Kullanıcının indirim kodu girmesini ve uygulamasını sağlayan bileşen.
 *
 * @param onApplyDiscount Girilen indirim kodunu işleyen callback.
 * @param isEnabled İndirim kodu giriş alanının etkin olup olmadığını belirleyen değer.
 */
@Composable
fun DiscountCodeSection(
    onApplyDiscount: (String) -> Boolean,
    isEnabled: Boolean
) {
    var discountCode by remember { mutableStateOf("") }
    var discountMessage by remember { mutableStateOf<String?>(null) }
    val discountAppliedMessage = stringResource(R.string.discount_applied_message)
    val invalidDiscountMessage = stringResource(R.string.invalid_discount_message)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = discountCode,
                    onValueChange = { if (isEnabled) discountCode = it },
                    label = { Text(stringResource(R.string.enter_discount_code)) },
                    modifier = Modifier.weight(1f),
                    enabled = isEnabled,
                    singleLine = true,
                    shape = MaterialTheme.shapes.small
                )
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = {
                        if (isEnabled) {
                            val isValid = onApplyDiscount(discountCode)
                            if (isValid) {
                                discountMessage = "$discountAppliedMessage (%${Constants.DISCOUNT_CODES[discountCode]})"
                                discountCode = ""
                            } else {
                                discountMessage = invalidDiscountMessage
                            }
                        }
                    },
                    enabled = isEnabled,
                    colors = ButtonDefaults.buttonColors()
                ) {
                    Text(stringResource(R.string.apply_button))
                }
            }

            discountMessage?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodySmall,
                    color = if (it.contains(discountAppliedMessage)) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        MaterialTheme.colorScheme.error
                    },
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .align(Alignment.Start)
                )
            }
        }
    }
}