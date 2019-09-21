package com.app.weatherforcast.data.remote.weatherdata

import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class Rx<T> : DisposableObserver<T>() {

    lateinit var restCallback: RestCallback<T>
    lateinit var disposable: CompositeDisposable

    fun setObservable(observable: Observable<T>): Rx<T> {
        val observable = observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
        observable.subscribeWith(this)
        return this
    }


    private fun handleOtherException(exceptionTye: String?): String? {
        Log.d("otherExceptionm",exceptionTye)
        return exceptionTye
    }


    fun excute(): Rx<T> {
        disposable = CompositeDisposable()
        disposable.add(this)
        Log.d("Before","" + disposable.size())
        return this
    }

    fun disposable() {
        disposable.dispose()
    }


    fun setCallback(restCallback: RestCallback<T>): Rx<T> {
        this.restCallback = restCallback
        return this
    }

    override fun onComplete() {
        disposable()
        Log.d("After","" + disposable.size())
    }

    override fun onNext(t: T) = restCallback.onsuccess(t)


    override fun onError(throwableError: Throwable) {
            restCallback.onfailure()
    }
}

    interface RestCallback<T> {
        fun onsuccess(t: T)
        fun onfailure()
    }
