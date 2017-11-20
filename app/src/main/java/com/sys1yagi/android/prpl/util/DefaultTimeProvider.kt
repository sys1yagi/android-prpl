package com.sys1yagi.android.prpl.util

class DefaultTimeProvider : TimeProvider {
    override fun now() = System.currentTimeMillis()
}
