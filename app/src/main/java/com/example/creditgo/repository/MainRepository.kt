package com.example.creditgo.repository

import com.example.creditgo.model.DataResponseItem
import com.example.creditgo.utils.Resource
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun getUsers(page: Int): Flow<Resource<List<DataResponseItem>>>
}