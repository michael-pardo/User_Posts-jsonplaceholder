package co.com.ceiba.mobile.pruebadeingreso.di

import androidx.hilt.Assisted
import co.com.ceiba.mobile.pruebadeingreso.domain.usecases.FilterUsersByName
import co.com.ceiba.mobile.pruebadeingreso.domain.usecases.ListUsers
import co.com.ceiba.mobile.pruebadeingreso.domain.usecases.SeeUserPosts
import co.com.ceiba.mobile.pruebadeingreso.view.main.MainViewModel
import co.com.ceiba.mobile.pruebadeingreso.view.post.PostViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
class ViewModelModule {

    @Provides
    fun providesMainViewModel(
            listUsers: ListUsers,
            filterUsersByName: FilterUsersByName
    ) = MainViewModel(listUsers, filterUsersByName)

    @Provides
    fun providesPostViewModel(
            seeUserPosts: SeeUserPosts
    ) = PostViewModel(seeUserPosts)


}