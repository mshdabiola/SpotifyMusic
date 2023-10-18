package com.mshdabiola.data.repository

interface UserDataRepository {

    suspend fun setTopic(id: Int)

    suspend fun remove(id: Int)
}
