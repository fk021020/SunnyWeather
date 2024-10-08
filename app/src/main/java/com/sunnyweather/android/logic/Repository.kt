package com.example.sunnyweather.logic

import androidx.lifecycle.liveData
import com.sunnyweather.android.logic.dao.PlaceDao
import com.sunnyweather.android.logic.model.Place
import com.sunnyweather.android.logic.model.Weather
import com.sunnyweather.android.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlin.coroutines.CoroutineContext

object Repository {

    fun searchPlaces(query:String) = /*liveData*/fire(Dispatchers.IO) {
//        val result = try {
        val placeResponse = SunnyWeatherNetwork.searchPlace(query)
        if (placeResponse.status == "ok"){
            val places = placeResponse.places
            Result.success(places)
        }else{
            Result.failure(RuntimeException("response status is ${placeResponse.status}"))
        }
//        }catch (e:Exception){
//            Result.failure<List<Place>>(e)
//        }
//        emit(result)
    }


    fun  refreshWeather(lng:String,lat:String) = fire(Dispatchers.IO) {
//        val result = try {
        coroutineScope {
            val deferredRealtime = async {
                SunnyWeatherNetwork.getRealtimeWeather(lng,lat)
            }
            val deferredDaily = async {
                SunnyWeatherNetwork.getDailyWeather(lng, lat)
            }

            val realtimeResponse  = deferredRealtime.await()
            val dailyResponse  = deferredDaily.await()

            if (realtimeResponse.status == "ok" && dailyResponse.status == "ok"){
                val weather = Weather(realtimeResponse.result.realtime,
                    dailyResponse.result.daily)

                Result.success(weather)
            }else{
                Result.failure(
                    RuntimeException(
                        "realtime response status is ${realtimeResponse.status} " +
                                "daily response status is ${dailyResponse.status}"
                    )
                )
            }

        }
//        }catch (e:Exception){
//            Result.failure<Weather>(e)
//        }
//        emit(result)
    }

    private fun <T> fire(context:CoroutineContext ,block:suspend()->Result<T>) =
        liveData<Result<T>>(context){
            val result = try {
                block()
            }catch (e:Exception){
                Result.failure<T>(e)
            }
            emit(result)
        }


    fun savePlace(place: Place) = PlaceDao.savePlace(place)

    fun getSavePlace() = PlaceDao.getSavePlace()

    fun isPlaceSaved() = PlaceDao.isPlaceSaved()
}