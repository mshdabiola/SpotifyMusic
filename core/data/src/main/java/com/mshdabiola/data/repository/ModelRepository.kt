package com.mshdabiola.data.repository

import androidx.paging.PagingData
import com.mshdabiola.model.Model
import kotlinx.coroutines.flow.Flow

interface ModelRepository {
    suspend fun insertModel(model: Model)
    fun getModels(): Flow<List<Model>>

    fun getModelPaging(): Flow<PagingData<Model>>
}
