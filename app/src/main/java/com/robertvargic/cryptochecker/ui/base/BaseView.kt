package com.robertvargic.cryptochecker.ui.base

interface BaseView<T> {
    fun setPresenter(presenter: T)
}