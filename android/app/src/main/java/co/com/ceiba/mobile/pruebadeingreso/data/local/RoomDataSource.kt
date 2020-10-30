package co.com.ceiba.mobile.pruebadeingreso.data.local


import co.com.ceiba.mobile.pruebadeingreso.data.local.dao.PruebaDao
import co.com.ceiba.mobile.pruebadeingreso.data.source.LocalDataSource
import co.com.ceiba.mobile.pruebadeingreso.domain.ResultData
import co.com.ceiba.mobile.pruebadeingreso.domain.model.User
import co.com.ceiba.mobile.pruebadeingreso.data.mappers.toDomain
import co.com.ceiba.mobile.pruebadeingreso.data.mappers.toLocal
import co.com.ceiba.mobile.pruebadeingreso.data.remote.response.PostResponse
import co.com.ceiba.mobile.pruebadeingreso.data.remote.response.UserResponse
import co.com.ceiba.mobile.pruebadeingreso.domain.model.UserWithPosts
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomDataSource(private val dao: PruebaDao): LocalDataSource {
    override suspend fun getUsers(): ResultData<List<User>> = withContext(Dispatchers.IO) {
        return@withContext ResultData.Success(dao.getUsers().map { it.toDomain() })
    }

    override suspend fun isEmptyUsers(): Boolean  = withContext(Dispatchers.IO) {
        return@withContext dao.countUsers() <= 0
    }

    override suspend fun isEmptyPosts(userId: Int): Boolean = withContext(Dispatchers.IO)  {
        return@withContext dao.countPosts(userId) <= 0
    }

    override suspend fun insertUsers(users: List<UserResponse>) = withContext(Dispatchers.IO) {
        dao.insertUsers(users.map { it.toLocal() })
    }

    override suspend fun getPostByUserId(userId: Int): ResultData<UserWithPosts> = withContext(Dispatchers.IO) {
        return@withContext ResultData.Success(dao.getUserWithPostByUserId(userId).toDomain())
    }

    override suspend fun insertPosts(posts: List<PostResponse>) = withContext(Dispatchers.IO) {
        dao.insertPosts(posts.map { it.toLocal() })
    }

    override suspend fun searchUsersByName(name: String): ResultData<List<User>>  = withContext(Dispatchers.IO) {
        return@withContext ResultData.Success(dao.searchUsersByName(name).map { it.toDomain() })
    }


}



