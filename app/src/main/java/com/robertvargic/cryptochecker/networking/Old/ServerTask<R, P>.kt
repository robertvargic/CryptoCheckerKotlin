package com.robertvargic.cryptochecker.networking.Old

interface ServerTask<R> {
    fun execute(listener: TaskListener<R>)
}