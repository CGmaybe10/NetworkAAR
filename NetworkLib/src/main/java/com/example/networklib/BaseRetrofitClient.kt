package com.dorice.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class BaseRetrofitClient private constructor() {
    private val mRetrofit: Retrofit

    init {
        val builder = Retrofit.Builder()
        val okHttpClient: OkHttpClient = BaseOkHttpClient.getInstance()
        builder.client(okHttpClient)
        builder.addConverterFactory(GsonConverterFactory.create())
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        builder.baseUrl(BaseDataManager.BASE_URL)
        mRetrofit = builder.build()
    }

    companion object {
        fun getInstance() = BaseRetrofitClientHolder.instance
    }

    private object BaseRetrofitClientHolder {
        val instance = BaseRetrofitClient().mRetrofit
    }
}