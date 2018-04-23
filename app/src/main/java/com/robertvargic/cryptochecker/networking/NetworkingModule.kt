package com.robertvargic.cryptochecker.networking

import com.google.gson.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class NetworkingModule {

    private val DATE_JSON_SERIALIZER = JsonSerializer<Date> { src, typeOfSrc, context -> if (src == null) null else JsonPrimitive(src.time) }
    private val DATE_JSON_DESERIALIZER = JsonDeserializer<Date> { json, typeOfT, context -> if (json == null) null else Date(json.asLong) }
//    @Provides
//    fun baseUrl(context: Context): String = context.getString(R.string.backend_base_url)

//    @Provides
//    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
//            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

//    @Provides
//    fun authenticationInterceptor(preferences: PreferencesHelperInterface) = Interceptor {
//        val authentication = it.request().newBuilder().apply {
//            val apiKey = preferences.getApiKey()
//            if (apiKey.isNotBlank()) addHeader(KEY_AUTHORIZATION, apiKey)
//        }.build()
//        it.proceed(authentication)
//    }
//
//    @Provides
//    fun converterFactory(): JacksonConverterFactory = JacksonConverterFactory.create(ObjectMapper().registerModule(KotlinModule()))
//
//    @Provides
//    fun okHttpClient(logging: HttpLoggingInterceptor, interceptor: Interceptor): OkHttpClient =
//            OkHttpClient.Builder().apply {
//                if (BuildConfig.DEBUG) {
//                    addInterceptor(logging)
//                }
//                addInterceptor(interceptor)
//            }.build()

    fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://api.coinmarketcap.com/")
                .addConverterFactory(GsonConverterFactory.create(getGson()))
                .build()
    }

    companion object Factory {
        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.coinmarketcap.com/")
                    .addConverterFactory(GsonConverterFactory.create(NetworkingModule().getGson()))
                    .build()
            return retrofit.create(ApiService::class.java)
        }
    }


    fun getGson(): Gson {
        return getCommonBuilder()
                .create()
    }

    private fun getCommonBuilder(): GsonBuilder {
        return GsonBuilder()
                .registerTypeAdapter(Date::class.java, DATE_JSON_SERIALIZER)
                .registerTypeAdapter(Date::class.java, DATE_JSON_DESERIALIZER)
                .excludeFieldsWithoutExposeAnnotation()
    }
//    @Provides
//    fun apiService(retrofit: Retrofit): InstalogApiService = retrofit.create(InstalogApiService::class.java)
}