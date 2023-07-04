package com.example.activityalias.sample

import android.content.ComponentName
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.activityalias.sample.infobip.InfobipWrapper
import com.example.activityalias.sample.util.ActivityAlias
import com.google.android.material.button.MaterialButton
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(R.layout.activity_main), KodeinAware {

    override val kodein: Kodein by closestKodein()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        findViewById<MaterialButton>(R.id.btn_set_red_icon).setOnClickListener {
            ActivityAlias.Red.setEnabled()
        }
    }

    private fun ActivityAlias.setEnabled() {
        this.toComponentName().setComponentState(true)
        ComponentName(applicationContext, MainActivity::class.java)
            .setComponentState(false)
    }

    private fun ComponentName.setComponentState(enabled: Boolean) {
        val newState = when {
            enabled -> PackageManager.COMPONENT_ENABLED_STATE_ENABLED
            else -> PackageManager.COMPONENT_ENABLED_STATE_DISABLED
        }

        packageManager.setComponentEnabledSetting(this, newState, PackageManager.DONT_KILL_APP)
    }

    private fun ActivityAlias.toComponentName(): ComponentName {
        val packageName = BuildConfig.APPLICATION_ID
        return ComponentName(packageName, manifestName)
    }
}