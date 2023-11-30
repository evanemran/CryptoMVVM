package com.evanemran.crypto.domain.repository

import com.evanemran.crypto.data.remote.dto.CoinDetailDto
import com.evanemran.crypto.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String) : CoinDetailDto
}