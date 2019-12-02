package android.example.myapplication

import android.app.Application
import android.example.myapplication.di.ApplicationComponent
import android.example.myapplication.di.DaggerApplicationComponent
import android.example.myapplication.di.modules.ApplicationModule
import timber.log.Timber

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
        initDi()
    }

    private fun initTimber() {
        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initDi() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
            .also { it.inject(this) }
    }

    companion object {
        lateinit var applicationComponent: ApplicationComponent
    }
}
