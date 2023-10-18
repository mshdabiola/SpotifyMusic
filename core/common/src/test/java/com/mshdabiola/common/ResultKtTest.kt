/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mshdabiola.common

import app.cash.turbine.test
import com.mshdabiola.common.result.asResult
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class ResultKtTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun Result_catches_errors() = runTest {
        flow {
            emit(1)
            throw Exception("Test Done")
        }
            .asResult()
            .test {
                assertEquals(com.mshdabiola.common.result.Result.Loading, awaitItem())
                assertEquals(com.mshdabiola.common.result.Result.Success(1), awaitItem())

                when (val errorResult = awaitItem()) {
                    is com.mshdabiola.common.result.Result.Error -> assertEquals(
                        "Test Done",
                        errorResult.exception?.message,
                    )

                    com.mshdabiola.common.result.Result.Loading,
                    is com.mshdabiola.common.result.Result.Success,
                    -> throw IllegalStateException(
                        "The flow should have emitted an Error Result",
                    )
                }

                awaitComplete()
            }
    }
}
