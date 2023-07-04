package com.example.activityalias.sample.util

import com.example.activityalias.sample.BuildConfig
import com.example.activityalias.sample.MainActivity
import com.example.activityalias.sample.R

enum class ActivityAlias(val manifestName: String, val resId: Int) {
    Red("${BuildConfig.APPLICATION_ID}.Red", R.drawable.ic_launcher_red),
}