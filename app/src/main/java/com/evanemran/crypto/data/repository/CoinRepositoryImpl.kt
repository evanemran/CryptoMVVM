package com.evanemran.crypto.data.repository

import com.evanemran.crypto.data.remote.CoinPaprikaApi
import com.evanemran.crypto.data.remote.dto.CoinDetailDto
import com.evanemran.crypto.data.remote.dto.CoinDto
import com.evanemran.crypto.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}