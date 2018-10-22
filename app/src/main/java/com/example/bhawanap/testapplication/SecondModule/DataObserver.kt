package com.example.bhawanap.testapplication.SecondModule

import io.reactivex.observers.DisposableObserver

/**
 * **  Created by home on 21-Oct-18.
 */

class DataObserver(private val secondView:SecondView) : DisposableObserver<List<Model>>() {

    override fun onComplete() {
        this.dispose()
    }

    override fun onNext(t: List<Model>) {
        secondView.updateData(t)
    }

    override fun onError(e: Throwable) {

    }

}
