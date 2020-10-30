package co.com.ceiba.mobile.pruebadeingreso.data.remote

import co.com.ceiba.mobile.pruebadeingreso.data.remote.response.PostResponse
import co.com.ceiba.mobile.pruebadeingreso.data.remote.response.UserResponse
import co.com.ceiba.mobile.pruebadeingreso.data.remote.rest.ApiService
import co.com.ceiba.mobile.pruebadeingreso.data.source.RemoteDataSource
import co.com.ceiba.mobile.pruebadeingreso.domain.ResultData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class RemoteApiDataSource(private val apiService: ApiService): RemoteDataSource {
    override suspend fun getUsers(): ResultData<List<UserResponse>> = withContext(Dispatchers.IO) {
        return@withContext try {
            val response = apiService.fetchPosts()
            val users = response.body()
            users?.let {
                ResultData.Success(it)
            } ?: run {
                ResultData.Error(response.errorBody().toString())
            }
        }catch (e: Exception){
            ResultData.Error(e.localizedMessage)
        }
    }

    override suspend fun getPostByUserId(userId: Int): ResultData<List<PostResponse>> = withContext(Dispatchers.IO) {
        return@withContext try {
            val response = apiService.fetchPostByUserId(userId)
            val users = response.body()
            users?.let {
                ResultData.Success(it)
            } ?: run {
                ResultData.Error(response.errorBody().toString())
            }
        }catch (e: Exception){
            ResultData.Error(e.localizedMessage)
        }
    }

}
