package com.youthtech.rhythmify.kotlinplayground.coroutinescontext

import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

//fun main() {
//    val job: Job = GlobalScope.launch {
//        delay(2000)
//        println("Hello Kotlin")
//    }
//    val job2: Job = GlobalScope.launch {
//        job.join()
//        delay(1000)
//        println("I'm Coroutines")
//    }
//    Thread.sleep(4000)
//}

//fun main(){
//    runBlocking {
//        val job =  launch(Dispatchers.Default) {
//            repeat(1000){
//                delay(500)
//                println("I'm sleeping ${it} ...")
//            }
//        }
//        delay(1500)
//        job.cancel()
//        println("Cancelled coroutines")
//    }
//}


//fun main() {
//    runBlocking {
//        val job = launch {
//            try {
//                repeat(1000) {
//                    delay(100)
//                    println("Hello Coroutine")
//                }
//            } finally {
//                println("Print from finally")
//                delay(100)
//                //delay sẽ check xem coroutine còn sống ko nên dòng sau ko đc in ra
//                println("Please print me last time")
//            }
//        }
//        delay(800)
//        println("i want to stop couroutine")
//        job.cancel()
//
//    }
//}

fun main(){
        runBlocking {
        val job = launch {
            try {
                repeat(1000) {
                    delay(100)
                    println("Hello Coroutine")
                }
            } finally {
                println("Print from finally")
                //Tạo ra một thread ko thể cancel
                withContext(NonCancellable){
                    repeat(10){
                        delay(100)
                        println("Print from noncancellable")
                    }
                }
            }
        }
        delay(800)
        println("i want to stop couroutine")
        job.cancel()

    }
}
