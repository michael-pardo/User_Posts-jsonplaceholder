package co.com.ceiba.mobile.pruebadeingreso.di

import android.content.Context
import co.com.ceiba.mobile.pruebadeingreso.data.local.PruebaDB
import co.com.ceiba.mobile.pruebadeingreso.data.local.RoomDataSource
import co.com.ceiba.mobile.pruebadeingreso.data.remote.RemoteApiDataSource
import co.com.ceiba.mobile.pruebadeingreso.data.remote.rest.ApiService
import co.com.ceiba.mobile.pruebadeingreso.data.source.LocalDataSource
import co.com.ceiba.mobile.pruebadeingreso.data.source.RemoteDataSource
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
class DataModule {
    @Singleton
    @Provides
    fun providesApi() : RemoteDataSource{
        val retrofit =Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                val api = retrofit.create(ApiService::class.java)
        return RemoteApiDataSource(api)

    }

    @Singleton
    @Provides
    fun provideRoomDataSource(@ApplicationContext appContext: Context) : LocalDataSource {
        val db = PruebaDB.build(appContext).dao
        return RoomDataSource(db)
    }

}