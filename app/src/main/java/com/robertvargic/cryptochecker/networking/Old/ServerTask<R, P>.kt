package com.robertvargic.cryptochecker.networking.Old

interface ServerTask<R, P> {
    fun execute(listener: TaskListener<R>, params: P)
}