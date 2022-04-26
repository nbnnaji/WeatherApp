package com.nkechinnaji.simpleweatherapp.base

sealed class ApiResultWrapper<out Result> {
    /***
     * Successful API Response
     */
    data class Success<out T : Any?>(val data: T?, val msg: String? = null) : ApiResultWrapper<T>()

    /***
     * Api Error Response
     */
    sealed class Error(
        val message: String? = null,
        val Throwable: Throwable? = null,
        val data: Any? = null
    ) : ApiResultWrapper<Nothing>() {

        /***
         * Api Errors that can result in successful retry or context changes.
         */
        class RecoverableError(
            message: String? = null,
            throwable: Throwable? = null,
            data: Any? = null
        ) : Error(message, throwable, data)

        /***
         * Api Errors that cannot be recovered without code changes.
         */
        class NonRecoverableError(
            message: String? = null,
            throwable: Throwable? = null,
            data: Any? = null
        ) : Error(message, throwable, data)
    }

    object InProgress : ApiResultWrapper<Nothing>()
}