package co.com.ceiba.mobile.pruebadeingreso.domain.repository

import co.com.ceiba.mobile.pruebadeingreso.domain.ResultData
import co.com.ceiba.mobile.pruebadeingreso.domain.model.User
import co.com.ceiba.mobile.pruebadeingreso.domain.model.UserWithPosts

interface Repository {
    suspend fun getUsers(): ResultData<List<User>>
    suspend fun getUsersByName(name: String): ResultData<List<User>>
    suspend fun getUserWithPosts(userId: Int): ResultData<UserWithPosts>
}