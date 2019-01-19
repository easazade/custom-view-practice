package ir.easazade.alireza.customview

import android.app.Application

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        CustomViewUtils.init(this)
    }
}