package com.virtual_android.a_donde_ir

import retrofit2.http.GET

interface ApiServices {

    @GET("/Virtual-android/poi_a_donde_ir/poi")
        fun requestPois() : List<Poi>
}