package co.com.ceiba.mobile.pruebadeingreso.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PostEntity(
        @PrimaryKey
        val id:Int,
        val userId: Int,
        val title: String,
        val body: String,
){

}