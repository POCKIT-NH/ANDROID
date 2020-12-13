package com.nhgirls.pockit.data

import com.nhgirls.pockit.R

object DummyContainer {
    fun getDummyMealKits() = listOf(
        Mealkit(
            R.drawable.dummy_mealkit_1,
            "청국장과 부추전",
            11670,
            false,
            31
        ),
        Mealkit(
            R.drawable.dummy_mealkit_2,
            "비지찌개와 삼겹…",
            9880,
            false,
            102
        ),
        Mealkit(
            R.drawable.dummy_mealkit_3,
            "만둣국과 짱아찌",
            10720,
            false,
            24
        ),
        Mealkit(
            R.drawable.dummy_mealkit_4,
            "고추장찌개와 오…",
            11250,
            true,
            11
        ),
        Mealkit(
            R.drawable.dummy_mealkit_5,
            "된장국과 김치제…",
            12120,
            false,
            157
        ),
        Mealkit(
            R.drawable.dummy_mealkit_6,
            "굴밥과 항정살구…",
            12320,
            false,
            231
        )
    )

    fun getDummyCarts() = listOf(
        Cart(0,
            "https://user-images.githubusercontent.com/57262833/101932237-daf2de80-3c1d-11eb-9773-67447208ccf6.png",
        "전통 백반",
            12300,
            1
        ),
        Cart(1,
            "https://thewiki.ewr1.vultrobjects.com/data/65787465726e616c2f3033332d3337342d323134312e706b743131342e636f6d2f313432333831323838345f3230303331315f312e6a7067.jpg",
            "현대 백반",
            10000,
            1
        )
    )
}