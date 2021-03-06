package com.github.andrei1993ak.mentoring.daggertaskkazlouski.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(val userId: Long, val title: String, val avatar: String) : Parcelable