package com.example.mytestapplication.ui.gallery

import android.util.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.*

class Operators {

    var mList = mutableListOf<Int>(1,2,3,4,5,6,7,8,9,10,11,12,13)
    var mListarray = arrayOf<Int>(1,2,3,4,5,6,7,8,9,10,11,12,13)

    fun fromOperator(){


        val observable = Observable.fromArray(mListarray) // From oprator


        var observer = object : Observer<Array<Int>> {
            override fun onSubscribe(d: Disposable) {

                Log.e("onSubscribe","$d")
            }



            override fun onError(e: Throwable) {
                Log.e("onError","$e")
            }

            override fun onComplete() {
                Log.e("onComplete","")
            }

            override fun onNext(t: Array<Int>) {
                Log.e("onNextFromOprator","${Arrays.toString(t)}")
            }

        }

        observable.subscribe(observer)
    }
}