package com.evanemran.crypto.domain.use_case.get_coins

import com.evanemran.crypto.commons.Resource
import com.evanemran.crypto.data.remote.dto.toCoin
import com.evanemran.crypto.domain.models.Coin
import com.evanemran.crypto.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke() : Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        }
        catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An Unexpected Error Occurred!"))
        }
        catch (e: IOException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "Couldn't reach server, Check Internet Connection!"))
        }
    }
}