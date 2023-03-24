package com.example.projectone_v02.data.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("id")
    val id: Int,
    @SerializedName("label")
    val label: String,
    @SerializedName("records")
    val records: List<Record>,
    @SerializedName("title")
    val title: String
)