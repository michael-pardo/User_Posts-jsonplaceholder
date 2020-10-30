package co.com.ceiba.mobile.pruebadeingreso.data.local.dao

import androidx.room.*
import co.com.ceiba.mobile.pruebadeingreso.data.local.entities.PostEntity
import co.com.ceiba.mobile.pruebadeingreso.data.local.entities.UserEntity
import co.com.ceiba.mobile.pruebadeingreso.data.local.model.UserWithPostsEntity

@Dao
interface PruebaDao {

    @Query("SELECT * FROM userentity")
    fun getUsers(): List<UserEntity>

    @Transaction
    @Query("SELECT * FROM userentity WHERE id=:id")
    fun getUserWithPostByUserId(id:Int): UserWithPostsEntity

    @Query("SELECT COUNT(*) FROM postentity WHERE userId=:id")
    fun countPosts(id:Int): Int

    @Transaction
    @Insert
    fun insertPosts(posts: List<PostEntity>)

    @Transaction
    @Insert
    fun insertUsers(users: List<UserEntity>)

    @Query("SELECT COUNT(*) FROM userentity")
    fun countUsers(): Int

    @Query("SELECT * FROM userentity WHERE name LIKE '%'||:name||'%'")
    fun searchUsersByName(name: String): List<UserEntity>
}