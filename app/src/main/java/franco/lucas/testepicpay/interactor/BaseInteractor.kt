package com.picpay.desafio.android.interactor

interface BaseInteractor<in PARAM, out RESPONSE> {
    suspend fun execute(param: PARAM): RESPONSE
}