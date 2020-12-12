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
}