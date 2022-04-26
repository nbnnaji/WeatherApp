package com.nkechinnaji.simpleweatherapp.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

open class BaseViewModel: ViewModel() {
    /***
     * Makes LiveDate to be of type MutableLiveData
     */

    protected fun <T> createMutableLiveData(): LiveData<T> = MutableLiveData()
    val isLoading: LiveData<LoadingState> = createMutableLiveData()

    /***
     * Extension function to LiveData to allow posting value to live data
     * @param value of decalred type
     */

    protected fun <T> LiveData<T>.postValue(value: T){
        when(this){
            is MutableLiveData<T> -> postValue(value)
            else -> throw Exception("Not using createMutableLiveData() to create live data")
        }
    }

    /***
     * Extension function to LiveData to allow setting value to live data
     * @param value of decalred type
     */

    protected fun <T> LiveData<T>.setValue(value: T){
        when(this){
            is MutableLiveData<T> -> setValue(value)
            else -> throw Exception("Not using createMutableLiveData() to create live data")
        }
    }

    fun <T> runSuspendFunction(block: suspend CoroutineScope.() -> T, errorCallback: ((ApiResult.Error) -> Unit)? = null) {

        val coroutineExceptionHanlder = CoroutineExceptionHandler { _, throwable ->
            throwable.printStackTrace()
            isLoading.postValue(LoadingState.LOADED)
            errorCallback?.invoke(ApiResult.Error(throwable))
        }
        viewModelScope.launch(coroutineExceptionHanlder) {
            val asyncJob = async {
                block()
            }
            isLoading.postValue(LoadingState.LOADING)
            asyncJob.await()
            isLoading.postValue(LoadingState.LOADED)
        }
    }
}