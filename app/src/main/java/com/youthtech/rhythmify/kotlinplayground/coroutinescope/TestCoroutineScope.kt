package com.youthtech.rhythmify.kotlinplayground.coroutinescope

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

fun main(){
    runBlocking {
//        launch {
//
//        }
//        async {
//
//        }
//    }
//    CoroutineScope(Dispatchers.Default).launch {
//        launch {  }
//        launch {  }
//        async {  }
//        // 3 coroutines này đc quản lý vòng đời bởi coroutinescope cha
//    }
//    runBlocking {
//       val job1 = launch {
//            launch {
//                delay(100)
//                println("Coroutine 1: Hello")
//                delay(1000)
//                println("Coroutine 1 : Goodbye")
//            }
//           launch {
//               delay(100)
//               println("Coroutine 2: Hello")
//               delay(1000)
//               println("Coroutine 2 : Goodbye")
//           }
//           GlobalScope.launch {
//               delay(100)
//               println("Coroutine 3 : Hello")
//               delay(2000)
//               println("Coroutine 3 : Goodbye")
//           }
//        }
//        delay(500)
//        job1.cancel()
//        delay(2500)
//
      val job =   launch {
            repeat(3){
                launch {
                    delay(100)
                    println("Coroutine $it")
                }
            }
          println("Print from parent")
        }
        job.join()
        delay(1000)
    }

}
class MyCoroutineScope() : CoroutineScope{
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main
}