package com.youthtech.rhythmify.kotlinplayground.coroutinescontext

import android.util.Log
import com.youthtech.rhythmify.RhythmifyApp
import com.youthtech.rhythmify.ui.activities.MainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext

object TestDispatchers {
    fun runMyFirstCoroutine(){
        GlobalScope.launch(Dispatchers.Default) {
            Log.d(MainActivity::class.java.simpleName, " Dispatcher Default run on ${Thread.currentThread().name}")
        }
        GlobalScope.launch(Dispatchers.IO) {
            Log.d(MainActivity::class.java.simpleName, " Dispatcher IO run on ${Thread.currentThread().name}")
        }
        GlobalScope.launch(Dispatchers.Main) {
            Log.d(MainActivity::class.java.simpleName, " Dispatcher Main run on ${Thread.currentThread().name}")
        }
        GlobalScope.launch(Dispatchers.Unconfined) {
            Log.d(MainActivity::class.java.simpleName, " Dispatcher Unconfined run on ${Thread.currentThread().name}")
        }
        GlobalScope.launch(newSingleThreadContext("My thread")) {
            Log.d(MainActivity::class.java.simpleName, " Dispatcher Unconfined run on ${Thread.currentThread().name}")
        }
    }
}