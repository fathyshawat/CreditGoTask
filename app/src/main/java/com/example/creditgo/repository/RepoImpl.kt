package com.example.creditgo.repository

import androidx.room.withTransaction
import com.example.creditgo.api.ApiService
import com.example.creditgo.model.DataResponseItem
import com.example.creditgo.utils.Resource
import com.example.creditgo.utils.networkBoundResource
import kotlinx.coroutines.flow.Flow
import xyz.teamgravity.offlinecaching.arch.database.UserDatabase
import javax.inject.Inject

class RepoImpl @Inject constructor(
    private val api: ApiService,
    private val db: UserDatabase
) : MainRepository {

    private val dao = db.userDao()

    override fun getUsers(page: Int): Flow<Resource<List<DataResponseItem>>> = networkBoundResource(
        query = {
            dao.getUsers()
        },
        fetch = {
            api.getUsers(page)
        },
        saveFetchResult = { restaurants ->
            db.withTransaction {
                dao.deleteAll()
                dao.insertAll(restaurants)
            }
        }
    )

}
