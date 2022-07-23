package com.example.creditgo.ui

import androidx.lifecycle.*
import com.example.creditgo.model.DataResponseItem

import com.example.creditgo.repository.MainRepository
import com.example.creditgo.utils.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.distinctUntilChanged

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    fun getData(page: Int): Flow<Resource<List<DataResponseItem>>> {

        return mainRepository.getUsers(page)
    }
}