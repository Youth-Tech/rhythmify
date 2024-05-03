package com.youthtech.rhythmify.kotlinplayground.coroutinescontext

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
//    runBlocking {
//        val a = doSomething()
//        val b = doSomething2()
//        println(a+b)
//    }
    runBlocking {
//        val time = measureTimeMillis {
//            val a = doSomething()
//            val b = doSomething2()
//            println(a+b)
//        }
//    println("Time: $time")
        val time = measureTimeMillis {
            val a: Deferred<Int> = async { doSomething() }
            val b: Deferred<Int> = async { doSomething2() }
            println(a.await()+b.await())
        }
        println("Time = $time")
    }
// Chạy 2 coroutines song song với nhau tính toán nhanh hơn
}
suspend fun doSomething(): Int{
    delay(1000)
    return 10
}
suspend fun doSomething2(): Int{
    delay(1000)
    return 20
}
