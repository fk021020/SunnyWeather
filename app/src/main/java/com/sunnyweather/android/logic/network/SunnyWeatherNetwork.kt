package com.sunnyweather.android.logic.network

import android.telecom.Call
import okhttp3.Response
import retrofit2.Callback
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object SunnyWeatherNetwork {

    private val weatherService = ServiceCreator.create(WeatherService::class.java)

    suspend fun getDailyWeather(lng: String, lat: String) = weatherService.getDailyWeather(lng, lat).await()

    suspend fun getRealtimeWeather(lng: String, lat: String) = weatherService.getRealtimeWeather(lng, lat).await()

    private val placeService = ServiceCreator.create(PlaceService::class.java)

    suspend fun searchPlace(query: String) = placeService.searchPlaces(query).await()


    private suspend fun <T> retrofit2.Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onResponse(call: retrofit2.Call<T>, response: retrofit2.Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(RuntimeException("response body is null"))
                }
                override fun onFailure(call: retrofit2.Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })
        }

    }
}