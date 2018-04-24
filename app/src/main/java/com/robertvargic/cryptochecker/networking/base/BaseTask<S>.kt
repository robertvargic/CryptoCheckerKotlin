package com.robertvargic.cryptochecker.networking.base

import com.robertvargic.cryptochecker.networking.ApiService
import retrofit2.Retrofit

abstract class BaseTask(retrofit: Retrofit) {
    var mService: ApiService = retrofit.create(ApiService::class.java)

}