package com.dorice.network

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

class BaseOkHttpClient private constructor() {
    private val TAG = "BaseOkHttpClient"

    private val mOkHttpClient: OkHttpClient

    init {
        val builder = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(getLogInterceptor())
        mOkHttpClient = builder.build()
    }

    private fun getLogInterceptor(): HttpLoggingInterceptor {
        val logger = HttpLoggingInterceptor { message: String ->
            val threadId = "(" + Thread.currentThread().id + ") "
            Log.d(TAG, threadId + message)
        }
        logger.level = HttpLoggingInterceptor.Level.BODY
        return logger
    }

    companion object {
        fun getInstance() = BaseOkHttpClientHolder.instance
    }

    private object BaseOkHttpClientHolder {
        val instance = BaseOkHttpClient().mOkHttpClient
    }
}