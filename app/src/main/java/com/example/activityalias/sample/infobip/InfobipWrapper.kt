package com.example.activityalias.sample.infobip

import android.app.Application
import com.example.activityalias.sample.MainActivity
import com.example.activityalias.sample.R
import org.infobip.mobile.messaging.MobileMessaging
import org.infobip.mobile.messaging.NotificationSettings
import org.infobip.mobile.messaging.storage.SQLiteMessageStore

class InfobipWrapper(app: Application) {

    private val mobileMessaging = MobileMessaging.Builder(app)
        .withMessageStore(SQLiteMessageStore::class.java)
        .withDisplayNotification(
            NotificationSettings.Builder(app)
                .withMultipleNotifications()
                .withCallbackActivity(MainActivity::class.java)
                .withDefaultIcon(R.drawable.ic_launcher_initial)
                .build()
        )
        .build()

    // bellow some methods

}