package com.sys1yagi.android.prpl.data.cachestore

import android.arch.persistence.room.Room
import com.google.gson.Gson
import com.sys1yagi.android.prpl.data.entity.User
import com.sys1yagi.android.prpl.extension.genericType
import com.sys1yagi.android.prpl.util.DefaultTimeProvider
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class CacheControllerTest {
    lateinit var cacheController: CacheController

    @Before
    fun setUp() {
        val database = Room
                .databaseBuilder(RuntimeEnvironment.application, CacheDatabase::class.java, "cache-test")
                .allowMainThreadQueries()
                .build()
        cacheController = CacheController(database.cacheDao(), Gson(), DefaultTimeProvider())
    }

    @Test
    fun cache() {
        cacheController.put("user", User(name = "test"))

        assertThat(cacheController.hasKey("user")).isTrue()

        val value = cacheController.get<User>("user")
        assertThat(value).isNotNull()
        assertThat(value.name).isEqualTo("test")
    }

    @Test
    fun cacheList() {
        cacheController.put("user", listOf(
                User(name = "test"),
                User(name = "test2")
        ))

        assertThat(cacheController.hasKey("user")).isTrue()

        val value = cacheController.getList<User>("user", genericType<List<User>>())
        assertThat(value).isNotNull()
        assertThat(value[0].name).isEqualTo("test")
        assertThat(value[1].name).isEqualTo("test2")
    }

    @Test
    fun deleteCache() {

    }

}
