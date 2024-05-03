package com.youthtech.rhythmify.kotlinplayground.coroutinescontext

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull

fun main() {
    runBlocking {
//        withTimeout(1800){
//            repeat(1000){
//                println("I'm sleeping $it")
//                delay(500L)
//            }
//        }
     val result =   withTimeoutOrNull(1800){
            repeat(1000){
                println("I'm sleeping $it")
                delay(500L)
            }
            "Done"
        }
        println("Result = $result")
    }
}