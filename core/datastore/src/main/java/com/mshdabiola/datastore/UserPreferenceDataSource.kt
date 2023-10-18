package com.mshdabiola.datastore

import androidx.datastore.core.DataStore
import com.mshdabiola.model.BrandTheme
import com.mshdabiola.model.ThemeConfig
import com.mshdabiola.model.UserData
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserPreferenceDataSource @Inject constructor(
    private val userPreferences: DataStore<UserPreferences>,
) {
    val userData = userPreferences.data
        .map {
            UserData(
                topicIds = it.topicIdsList,
                integer = it.integer,
                maps = it.mapIdsMap,
                yes = it.yes,
                names = it.nameList,
                brandTheme = when (it.themeBrand) {
                    ThemeBrandProto.THEME_BRAND_UNSPECIFIED,
                    ThemeBrandProto.UNRECOGNIZED,
                    ThemeBrandProto.THEME_BRAND_DEFAULT,
                    -> BrandTheme.ThemeDefault

                    ThemeBrandProto.THEME_BRAND_ANDROID -> BrandTheme.ThemeAndroid
                    else -> BrandTheme.ThemeAndroid
                },
                themeConfig = when (it.darkThemeConfig) {
                    DarkThemeConfigProto.DARK_THEME_CONFIG_DARK -> ThemeConfig.Dark
                    else -> ThemeConfig.Light
                },
            )
        }

    suspend fun addTopic(ids: Int) {
        userPreferences.updateData {
            it.copy {
                topicIds.add(ids)
            }
        }
    }

    suspend fun remove(ids: Int) {
        userPreferences.updateData {
            it.copy {
                val t = topicIds.toMutableList()
                val re = t.removeIf { it == ids }
                if (re) {
                    topicIds.clear()
                    topicIds.addAll(t)
                }
            }
        }
    }

    suspend fun setInteger(int: Int) {
        userPreferences.updateData {
            it.copy {
                this.integer = int
            }
        }
    }
}
