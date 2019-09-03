package br.com.marcussouza.easyinvest.di.config

import br.com.marcussouza.easyinvest.BuildConfig
import br.com.marcussouza.easyinvest.data.api.Api
import com.squareup.moshi.Moshi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

fun provideOkHttpClientBuilder(interceptors: Set<@JvmSuppressWildcards Interceptor>): OkHttpClient {
    val builder = OkHttpClient.Builder()
    interceptors.forEach { builder.addInterceptor(it) }
    if (BuildConfig.DEBUG) {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        builder.addInterceptor(httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        })
    }
    return builder.build()
}

fun provideInterceptor(): Set<@JvmSuppressWildcards Interceptor> = setOf(Interceptor { chain ->
    val request = chain.request()
    chain.proceed(request)
})

fun provideMoshi(): Moshi = Moshi.Builder().build()

fun provideApi():
        Api {
    return Retrofit.Builder()
        .client(provideOkHttpClientBuilder(provideInterceptor()))
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(provideMoshi()))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
        .build()
        .create(Api::class.java)
}

