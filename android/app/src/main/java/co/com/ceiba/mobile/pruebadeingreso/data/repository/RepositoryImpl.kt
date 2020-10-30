package co.com.ceiba.mobile.pruebadeingreso.data.repository

import co.com.ceiba.mobile.pruebadeingreso.data.source.LocalDataSource
import co.com.ceiba.mobile.pruebadeingreso.data.source.RemoteDataSource
import co.com.ceiba.mobile.pruebadeingreso.domain.ResultData
import co.com.ceiba.mobile.pruebadeingreso.domain.model.User
import co.com.ceiba.mobile.pruebadeingreso.domain.model.UserWithPosts
import co.com.ceiba.mobile.pruebadeingreso.domain.repository.Repository

class RepositoryImpl(
        private val localDataSource: LocalDataSource,
        private val remoteDataSource: RemoteDataSource
): Repository{
    override suspend fun getUsers(): ResultData<List<User>> {
        if (localDataSource.isEmptyUsers()){
            when (val result = remoteDataSource.getUsers()) {
                is ResultData.Success -> localDataSource.insertUsers(result.data)
                is ResultData.Error -> return result
            }
        }
        return localDataSource.getUsers()
    }

    override suspend fun getUsersByName(name: String): ResultData<List<User>> {
        return localDataSource.searchUsersByName(name)
    }

    override suspend fun getUserWithPosts(userId: Int): ResultData<UserWithPosts> {
        if (localDataSource.isEmptyPosts(userId)){
            when (val result = remoteDataSource.getPostByUserId(userId)) {

                is ResultData.Success -> {
                    localDataSource.insertPosts(result.data)
                }
                is ResultData.Error -> {
                    return result
                }
            }
        }
        return localDataSource.getPostByUserId(userId)
    }

}