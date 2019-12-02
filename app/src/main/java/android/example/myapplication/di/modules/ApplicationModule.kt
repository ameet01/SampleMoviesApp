package android.example.myapplication.di.modules

import android.content.Context
import android.example.myapplication.common.ViewModelFactory
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val context: Context) {

    @Provides
    fun provideContext(): Context = context
}
