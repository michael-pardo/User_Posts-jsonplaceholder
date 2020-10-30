package co.com.ceiba.mobile.pruebadeingreso.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import co.com.ceiba.mobile.pruebadeingreso.domain.model.Post
import co.com.ceiba.mobile.pruebadeingreso.domain.model.User
import co.com.ceiba.mobile.pruebadeingreso.data.local.dao.PruebaDao
import co.com.ceiba.mobile.pruebadeingreso.data.local.entities.PostEntity
import co.com.ceiba.mobile.pruebadeingreso.data.local.entities.UserEntity

@Database(entities = [
    PostEntity::class,
    UserEntity::class,
],version = 1, exportSchema = false)
abstract class PruebaDB : RoomDatabase(){
    companion object {
        fun build(context: Context) = Room.databaseBuilder(
            context,
            PruebaDB::class.java,
            "prueba_db"
        ).build()
    }

    abstract val dao: PruebaDao
}