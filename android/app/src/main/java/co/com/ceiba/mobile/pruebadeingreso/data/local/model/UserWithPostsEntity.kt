package co.com.ceiba.mobile.pruebadeingreso.data.local.model

import androidx.room.Embedded
import androidx.room.Relation
import co.com.ceiba.mobile.pruebadeingreso.data.local.entities.PostEntity
import co.com.ceiba.mobile.pruebadeingreso.data.local.entities.UserEntity
import co.com.ceiba.mobile.pruebadeingreso.domain.model.Post
import co.com.ceiba.mobile.pruebadeingreso.domain.model.User

data class UserWithPostsEntity(
        @Embedded val user: UserEntity,
        @Relation(
                parentColumn = "id",
                entityColumn = "userId"
        )
        val posts: List<PostEntity>
)