package com.stylethory.raldes.di.scope


import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Retention
import javax.inject.Scope

@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class PerActivity