package xyz.teamgravity.offlinecaching.arch.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.creditgo.model.DataResponseItem
import com.example.creditgo.utils.Constants
import kotlinx.coroutines.flow.Flow


@Dao
interface UsersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(restaurants: List<DataResponseItem>)

    @Query("DELETE FROM ${Constants.USERS_TABLE}")
    suspend fun deleteAll()

    @Query("SELECT * FROM ${Constants.USERS_TABLE}")
    fun getUsers(): Flow<List<DataResponseItem>>


}