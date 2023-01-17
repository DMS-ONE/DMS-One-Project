package com.yongjincompany.data.remote.response.age

import com.google.gson.annotations.SerializedName

data class AgeResponse(
    @SerializedName("age") val age: Int,
    @SerializedName("count") val count: Int,
    @SerializedName("country_id") val countryId: Int,
    @SerializedName("name") val name: String,
)
