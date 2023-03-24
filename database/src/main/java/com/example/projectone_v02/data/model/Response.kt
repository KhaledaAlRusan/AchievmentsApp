package com.example.projectone_v02.data.model


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("data")
    val `data`: List<Data>
)