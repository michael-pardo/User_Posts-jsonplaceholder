package co.com.ceiba.mobile.pruebadeingreso.data.source

import co.com.ceiba.mobile.pruebadeingreso.data.remote.response.PostResponse
import co.com.ceiba.mobile.pruebadeingreso.data.remote.response.UserResponse
import co.com.ceiba.mobile.pruebadeingreso.domain.ResultData
import co.com.ceiba.mobile.pruebadeingreso.domain.model.Post
import co.com.ceiba.mobile.pruebadeingreso.domain.model.User

interface RemoteDataSource {
    suspend fun getUsers(): ResultData<List<UserResponse>>
    suspend fun getPostByUserId(userId: Int): ResultData<List<PostResponse>>
}