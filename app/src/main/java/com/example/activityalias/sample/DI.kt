package com.example.activityalias.sample

import com.example.activityalias.sample.infobip.InfobipWrapper
import org.kodein.di.Kodein
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

fun appKodein(app: SampleApp) = Kodein.lazy {
    import(androidXModule(app))
    import(appModule)
}

val appModule = Kodein.Module("app-module") {
    bind<InfobipWrapper>() with singleton { InfobipWrapper(instance()) }
}