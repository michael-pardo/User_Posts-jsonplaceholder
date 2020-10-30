package co.com.ceiba.mobile.pruebadeingreso.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
        @PrimaryKey
        val id:Int,
        val name:String,
        val email:String,
        val phone:String
) {
}