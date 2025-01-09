package com.ismailcanvarli.moviebank.data.model

/**
 * API işlemlerinden dönen yanıt modelini temsil eder.
 *
 * @property success İşlemin başarılı olup olmadığını belirtir.
 * @property message İşlemle ilgili dönen mesaj.
 */
data class CrudResponse(
    val success: Int,
    val message: String
)