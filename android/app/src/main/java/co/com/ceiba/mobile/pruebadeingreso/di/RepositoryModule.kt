package co.com.ceiba.mobile.pruebadeingreso.di

import co.com.ceiba.mobile.pruebadeingreso.data.repository.RepositoryImpl
import co.com.ceiba.mobile.pruebadeingreso.data.source.LocalDataSource
import co.com.ceiba.mobile.pruebadeingreso.data.source.RemoteDataSource
import co.com.ceiba.mobile.pruebadeingreso.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun providesRepository(
            localDataSource: LocalDataSource,
            remoteDataSource: RemoteDataSource
    ): Repository = RepositoryImpl(localDataSource, remoteDataSource)
}