package com.robertvargic.cryptochecker.networking.Old

import retrofit2.Call
import retrofit2.Retrofit

abstract class BaseTask<S, T> {
    val mService: S
    lateinit var mActiveCall: Call<T>

    constructor(retrofit: Retrofit, serviceClass: Class<S>) {
        mService = retrofit.create(serviceClass)
    }

    public fun cancel() {
        if (mActiveCall != null)
            mActiveCall.cancel()
    }
}