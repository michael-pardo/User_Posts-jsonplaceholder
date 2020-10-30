package co.com.ceiba.mobile.pruebadeingreso.data.source

import co.com.ceiba.mobile.pruebadeingreso.data.local.model.UserWithPostsEntity
import co.com.ceiba.mobile.pruebadeingreso.data.remote.response.PostResponse
import co.com.ceiba.mobile.pruebadeingreso.domain.ResultData
import co.com.ceiba.mobile.pruebadeingreso.domain.model.User
import co.com.ceiba.mobile.pruebadeingreso.data.remote.response.UserResponse
import co.com.ceiba.mobile.pruebadeingreso.domain.model.UserWithPosts

interface LocalDataSource {
    suspend fun getUsers(): ResultData<List<User>>
    suspend fun isEmptyUsers(): Boolean
    suspend fun isEmptyPosts(userId: Int): Boolean
    suspend fun insertUsers(users: List<UserResponse>)
    suspend fun getPostByUserId(userId: Int): ResultData<UserWithPosts>
    suspend fun insertPosts(posts: List<PostResponse>)
    suspend fun searchUsersByName(name: String): ResultData<List<User>>
}