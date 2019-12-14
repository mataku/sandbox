package com.mataku.abstractapiclientsample.model

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

object APIClient {

    var client: Retrofit

    init {
        val okhttpClient = OkHttp3Client.builder().build()
        client = Retrofit.Builder()
            .client(okhttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    inline fun <reified T> get(): Flow<T?> {
        return flow {
            val response = client.create(APIService::class.java)
                .get<T>("way").await()
            if (response.isSuccessful) {
                emit(
                    response.body()
                )
            } else {
                emit(
                    null
                )
            }
        }
    }
}

interface APIService {
    @GET
    suspend fun <T> get(
        @Url url: String
    ): Deferred<Response<T>>
}

fun way() {
    val a = APIClient.get<String>()
}