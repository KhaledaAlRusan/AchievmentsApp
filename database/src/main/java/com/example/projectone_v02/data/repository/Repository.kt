package com.example.projectone_v02.data.repository

import com.example.projectone_v02.data.api.ProjectApi
import com.example.projectone_v02.data.model.Data
import com.example.projectone_v02.data.model.Response
import com.example.projectone_v02.data.network.RetrofitBuilder

class Repository (private val projectApi:ProjectApi){

    suspend fun getAchievements(): List<Data>{
        return projectApi.getAchievements().data
    }

}