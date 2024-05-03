package com.youthtech.rhythmify.kotlinplayground.exception_handling

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//fun main(){
//    runBlocking {
//        val handler = CoroutineExceptionHandler{
//            _, exception -> println("Error here: ${exception.toString()}")
//        }
//        val job = GlobalScope.launch(handler + Dispatchers.Default) {
//            try {
//                println("Throw exception from launch")
//                throw NullPointerException()
//            }catch (e: NullPointerException){
//                println(e.toString())
//            }
//
//        }
//        job.join()
//        //hàm join sẽ chờ cho coroutine thực hiện xong, rồi mới tới tác vụ khác.
//
//        val deferred = GlobalScope.async(handler) {
//            println("Throw Exception from async")
//            throw IndexOutOfBoundsException()
//        }
////        try {
////            deferred.await()
////        }catch (e : IndexOutOfBoundsException){
////            println(e.toString())
////        }
//        deferred.await()
//
//    }
//}



// khi có nhiều exception coroutine con bên trong coroutine cha thì coroutine quăng lỗi đầu tiên sẽ hiện ra

fun main(){
    runBlocking {
        val superVisorJob = SupervisorJob()
        with(CoroutineScope(coroutineContext + superVisorJob)){
            val firstChild = launch {
                println("Print from First Child")
                throw NullPointerException()
            }
            val secondChild = launch {
                firstChild.join()
                println("Print from second child. First child is active : ${firstChild.isActive}")
                try {
                 delay(1000)
                }finally {
                    println("Second child cancel")

                }
            }
            firstChild.join()
            println("Cancelling supervisorJob")
            superVisorJob.cancel()
            secondChild.join()
        }
    }
    runBlocking {
        val firstChild = launch {
            println("Print from First Child")
            throw NullPointerException()
        }
        val secondChild = launch {
            firstChild.join()
            println("Print from second child. First child is active : ${firstChild.isActive}")
            try {
                delay(1000)
            }finally {
                println("Second child cancel")

            }
        }
        firstChild.join()
        println("Cancelling supervisorJob")

        secondChild.join()
    }
}