package com.dorice.network

class BaseDataManager {
    companion object {
        var BASE_URL = ""

        fun init(baseUrl: String) {
            BASE_URL = baseUrl
        }
    }
}