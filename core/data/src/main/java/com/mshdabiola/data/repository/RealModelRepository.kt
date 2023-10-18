package com.mshdabiola.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.map
import com.mshdabiola.database.dao.ModelDao
import com.mshdabiola.database.model.asModel
import com.mshdabiola.database.model.asModelEntity
import com.mshdabiola.model.Model
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RealModelRepository @Inject constructor(
    private val modelDao: ModelDao,
) : ModelRepository {
    override suspend fun insertModel(model: Model) {
        modelDao.upsert(model.asModelEntity())
    }

    override fun getModels(): Flow<List<Model>> {
        return modelDao.getModel().map { modelEntities -> modelEntities.map { it.asModel() } }
    }


    override fun getModelPaging() =
        Pager(config = PagingConfig(pageSize = 10))
        {
            modelDao.getNewModel()
        }
            .flow
            .map {
                it.map { it.asModel() }
            }

}
