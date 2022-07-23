package xyz.teamgravity.offlinecaching.arch.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.creditgo.model.DataResponseItem
import com.example.creditgo.utils.Constants


@Database(entities = [DataResponseItem::class], version = Constants.DATABASE_VERSION)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UsersDao
}