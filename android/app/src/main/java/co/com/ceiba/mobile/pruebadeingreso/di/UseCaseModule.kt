package co.com.ceiba.mobile.pruebadeingreso.di


import co.com.ceiba.mobile.pruebadeingreso.domain.repository.Repository
import co.com.ceiba.mobile.pruebadeingreso.domain.usecases.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
class UseCaseModule {

    @Provides
    fun providesFilterUserByNameList(
            repository: Repository
    ) = FilterUsersByName(repository)

    @Provides
    fun providesListUsers(
            repository: Repository
    ) = ListUsers(repository)

    @Provides
    fun providesseeUserPosts(
            repository: Repository
    ) = SeeUserPosts(repository)


}