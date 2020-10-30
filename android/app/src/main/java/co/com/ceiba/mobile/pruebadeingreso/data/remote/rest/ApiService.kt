package co.com.ceiba.mobile.pruebadeingreso.data.remote.rest


import co.com.ceiba.mobile.pruebadeingreso.data.remote.response.PostResponse
import co.com.ceiba.mobile.pruebadeingreso.data.remote.response.UserResponse
import co.com.ceiba.mobile.pruebadeingreso.domain.model.Post
import co.com.ceiba.mobile.pruebadeingreso.domain.model.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService{
    @GET("/users")
    suspend fun fetchPosts(

    ): Response<List<UserResponse>>

    @GET("/posts")
    suspend fun fetchPostByUserId(
            @Query("userId") id:Int
    ): Response<List<PostResponse>>
}