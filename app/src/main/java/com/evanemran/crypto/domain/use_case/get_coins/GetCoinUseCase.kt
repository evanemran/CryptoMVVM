package com.evanemran.crypto.domain.use_case.get_coins

import com.evanemran.crypto.commons.Resource
import com.evanemran.crypto.data.remote.dto.toCoin
import com.evanemran.crypto.data.remote.dto.toCoinDetail
import com.evanemran.crypto.domain.models.Coin
import com.evanemran.crypto.domain.models.CoinDetail
import com.evanemran.crypto.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String) : Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        }
        catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An Unexpected Error Occurred!"))
        }
        catch (e: IOException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "Couldn't reach server, Check Internet Connection!"))
        }
    }
}