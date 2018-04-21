package com.robertvargic.cryptochecker.networking.Old

public interface TaskListener<T> {
    fun onPreExecute()
    fun onSuccess(result: T)
    fun onError(error: Throwable)
}