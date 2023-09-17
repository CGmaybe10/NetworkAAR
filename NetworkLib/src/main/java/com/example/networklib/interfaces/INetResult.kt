package com.example.networklib.interfaces

interface INetResult<T> {
    fun onFailed(errCode: String, errMsg: String)
    fun onSuccess(result: T)
}