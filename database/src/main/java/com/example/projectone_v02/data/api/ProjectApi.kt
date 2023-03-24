package com.example.projectone_v02.data.api

import com.example.projectone_v02.data.model.Data
import com.example.projectone_v02.data.model.Response
import retrofit2.http.GET

interface ProjectApi {

    @GET("/Achievements")
    suspend fun getAchievements():Response

}