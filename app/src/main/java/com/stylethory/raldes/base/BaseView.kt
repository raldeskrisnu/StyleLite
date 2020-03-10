package com.stylethory.raldes.base

interface BaseView {

    fun showLoadingState()

    fun hideLoadingState()

    fun erroState(throwable: Throwable)
}