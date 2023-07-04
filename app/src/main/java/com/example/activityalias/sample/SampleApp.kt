package com.example.activityalias.sample

import android.app.Application
import com.example.activityalias.sample.infobip.InfobipWrapper
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.direct
import org.kodein.di.generic.instance

class SampleApp : Application(), KodeinAware {

    override val kodein: Kodein = appKodein(this)

    override fun onCreate() {
        super.onCreate()
        forceInitInfobip()
    }

    private fun forceInitInfobip() {
        kodein.direct.instance<InfobipWrapper>()
    }
}