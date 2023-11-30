package com.evanemran.crypto.presentation.coin_detail

import com.evanemran.crypto.domain.models.Coin
import com.evanemran.crypto.domain.models.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
