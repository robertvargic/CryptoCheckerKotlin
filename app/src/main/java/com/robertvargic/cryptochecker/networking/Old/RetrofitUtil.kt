package com.robertvargic.cryptochecker.networking.Old

import android.content.Context
import com.google.gson.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class RetrofitUtil {

    private val DATE_JSON_SERIALIZER = JsonSerializer<Date> { src, typeOfSrc, context -> if (src == null) null else JsonPrimitive(src.time) }
    private val DATE_JSON_DESERIALIZER = JsonDeserializer<Date> { json, typeOfT, context -> if (json == null) null else Date(json.asLong) }

    fun createRetrofitForUrl(context: Context): Retrofit {
        return createRetrofit(context)
    }

    private fun createRetrofit(context: Context): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://api.coinmarketcap.com/")
                .addConverterFactory(GsonConverterFactory.create(getGson()))
                .build()
    }

    private fun getGson(): Gson {
        return getCommonBuilder()
                .create()
    }

    private fun getCommonBuilder(): GsonBuilder {
        return GsonBuilder()
                .registerTypeAdapter(Date::class.java, DATE_JSON_SERIALIZER)
                .registerTypeAdapter(Date::class.java, DATE_JSON_DESERIALIZER)
                .excludeFieldsWithoutExposeAnnotation()
    }
}