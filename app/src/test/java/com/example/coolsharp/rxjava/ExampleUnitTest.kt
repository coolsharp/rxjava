package com.example.coolsharp.rxjava

import io.reactivex.Observable
import io.reactivex.Observable.create
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import org.junit.Test

import org.junit.Assert.*
import org.reactivestreams.Subscriber

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun test_just() {
        Observable.just(1, 2, 3, 4, 5)
                .subscribe(System.out::println)
    }

    @Test
    fun test_create() {
        Observable.create(ObservableOnSubscribe<Int> { emitter ->
            emitter.onNext(100)
            emitter.onNext(200)
            emitter.onNext(300)
            emitter.onComplete()
        }
        ).subscribe(System.out::println)
    }

    @Test
    fun test_from_array() {
        val arr = intArrayOf(100, 200, 300)

        val source = Observable.fromArray(arr)
        source.subscribe(object: Consumer<IntArray?> {
            override fun accept(t: IntArray?) {
                for (x: Int in t!!) {
                    System.out.println(x)
                }
            }
        })
    }
}
