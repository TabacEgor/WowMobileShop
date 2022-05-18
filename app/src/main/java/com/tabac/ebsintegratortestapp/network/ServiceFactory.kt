package com.tabac.ebsintegratortestapp.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Modifier
import java.util.concurrent.TimeUnit

private fun makeClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .readTimeout(DEFAULT_READ_TIMEOUT, TimeUnit.MILLISECONDS)
        .connectTimeout(DEFAULT_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
        .build()
}

internal val gson by lazy {
    GsonBuilder()
        .setPrettyPrinting()
        .excludeFieldsWithModifiers(Modifier.TRANSIENT, Modifier.ABSTRACT)
        .create()
}

fun <T> retrofitService(clazz: Class<T>): Lazy<T> = lazy { makeService(clazz) }

private fun <T> makeService(clazz: Class<T>): T {
    return Retrofit.Builder()
        .client(makeClient())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl(BASE_URL)
        .build()
        .create(clazz)
}

const val DEFAULT_READ_TIMEOUT: Long = 60_000L
const val DEFAULT_CONNECT_TIMEOUT: Long = 60_000L
const val BASE_URL = "http://mobile-shop-api.hiring.devebs.net"