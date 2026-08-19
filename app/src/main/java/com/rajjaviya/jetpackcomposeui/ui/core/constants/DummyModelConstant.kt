package com.rajjaviya.jetpackcomposeui.ui.core.constants

import android.os.Build
import androidx.annotation.RequiresApi
import com.rajjaviya.jetpackcomposeui.R
import com.rajjaviya.jetpackcomposeui.ui.model.BondDiscoverChatModel
import com.rajjaviya.jetpackcomposeui.ui.model.BondStoryModel
import java.time.LocalDateTime

object DummyModelConstant {
    @RequiresApi(Build.VERSION_CODES.O)

    val listOfStory = listOf(
        BondStoryModel(
            id = 1,
            name = "javiya raj", date = LocalDateTime.now(), images = listOf(
                R.drawable.image_03,
                R.drawable.image_02,
                R.drawable.image_03,
            )
        ),
        BondStoryModel(
            id = 2,
            name = "javiya meet", date = LocalDateTime.now(), images = listOf(
                R.drawable.image_01,
                R.drawable.image_02,
                R.drawable.image_03,
            )
        ),
        BondStoryModel(
            id = 3,
            name = "javiya yash", date = LocalDateTime.now(), images = listOf(
                R.drawable.image_02,
                R.drawable.image_03,
            )
        ),
        BondStoryModel(
            id = 4,
            name = "Alex lee", date = LocalDateTime.now(), images = listOf(
                R.drawable.image_03,
            )
        ),
    )

    val listOfDiscoverMessages = listOf(
        BondDiscoverChatModel(id = 0, message = "Best Match place in India"),
        BondDiscoverChatModel(
            id = 1,
            message = "The best place in India depends entirely on what you want: choose Leh-Ladakh for mountains, Rajasthan for history, Kerala for nature, or Goa for beaches.",
            isAiResponse = true
        ),
        BondDiscoverChatModel(id = 0, message = "Now give me which good food near my place."),
    )

    val listOfTravelImages = listOf(
        R.drawable.travel_01,
        R.drawable.travel_03,
        R.drawable.travel_03,
        R.drawable.travel_04,
        R.drawable.travel_05)
}