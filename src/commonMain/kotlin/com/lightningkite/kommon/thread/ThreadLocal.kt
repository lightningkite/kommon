package com.lightningkite.kommon.thread

import com.lightningkite.kommon.property.MutablePropertyDelegate

expect class ThreadLocal<T>(startValue: T) : MutablePropertyDelegate<T>