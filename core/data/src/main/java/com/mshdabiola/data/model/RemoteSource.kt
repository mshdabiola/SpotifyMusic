package com.mshdabiola.data.model

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator

@OptIn(ExperimentalPagingApi::class)
class RemoteSource : RemoteMediator<Int, Unit>() {
    override suspend fun load(loadType: LoadType, state: PagingState<Int, Unit>): MediatorResult {
        return MediatorResult.Success(endOfPaginationReached = false)
    }

    override suspend fun initialize(): InitializeAction {
        return super.initialize()
    }
}