package com.udacoding.pagingnewsmentoring.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ResApi {


    companion object {
        val baseUrl  = "http://newsapi.org/v2/"

        fun restApi(): NewsService {

            //step 1 configurasi interceptor
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            val okHttp = OkHttpClient().newBuilder().addInterceptor(interceptor).build()

            //step 2 retrofit
            val retrofit = Retrofit.Builder().baseUrl(baseUrl)
                .client(okHttp)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()

            //step 3 include configurasi retrofit ke interface
            return retrofit.create(NewsService::class.java)
        }
    }
}