package com.example.core_common

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val googleBookDispatcher: GoogleBookDispatchers)

enum class GoogleBookDispatchers {
    IO
}
