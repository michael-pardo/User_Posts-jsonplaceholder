package co.com.ceiba.mobile.pruebadeingreso.data.mappers

import co.com.ceiba.mobile.pruebadeingreso.data.local.entities.PostEntity
import co.com.ceiba.mobile.pruebadeingreso.data.local.entities.UserEntity
import co.com.ceiba.mobile.pruebadeingreso.data.local.model.UserWithPostsEntity
import co.com.ceiba.mobile.pruebadeingreso.data.remote.response.PostResponse
import co.com.ceiba.mobile.pruebadeingreso.data.remote.response.UserResponse
import co.com.ceiba.mobile.pruebadeingreso.domain.model.Post
import co.com.ceiba.mobile.pruebadeingreso.domain.model.User
import co.com.ceiba.mobile.pruebadeingreso.domain.model.UserWithPosts

fun UserEntity.toDomain(): User =
        User(
            id = id,
            name = name,
            email = email,
            phone = phone
        )

fun UserResponse.toLocal(): UserEntity =
        UserEntity(
            id = id,
            name = name,
            email = email,
            phone = phone
        )

fun PostEntity.toDomain(): Post =
        Post(
                id = id,
                userId = userId,
                title = title,
                body = body
        )

fun PostResponse.toLocal(): PostEntity =
        PostEntity(
                id = id,
                userId = userId,
                title = title,
                body = body
        )

fun UserWithPostsEntity.toDomain(): UserWithPosts =
        UserWithPosts(
                user = user.toDomain(),
                posts = posts.map { it.toDomain() }
        )