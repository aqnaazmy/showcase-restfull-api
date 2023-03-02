package com.plugin.showcaserestfullapi.helper

data class BaseResponse <T> (
    val code : Int,
    val status : String,
    val data : T
)