package com.evanemran.crypto.presentation.coin_list

import com.evanemran.crypto.domain.models.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
