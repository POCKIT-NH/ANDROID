package com.nhgirls.pockit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.nhgirls.pockit.R
import com.nhgirls.pockit.common.setOnDebounceClickListener
import com.nhgirls.pockit.ui.category.CategoryFragment
import com.nhgirls.pockit.ui.forest.ForestFragment
import com.nhgirls.pockit.ui.home.HomeFragment
import com.nhgirls.pockit.ui.story.StoryFragment
import com.nhgirls.pockit.ui.user.UserFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val list : List<Menus> by lazy {
        listOf(
            Menus(clHome, imgHome, HomeFragment()),
            Menus(clStory, imgStory, StoryFragment()),
            Menus(clSearch, imgSearch, CategoryFragment()),
            Menus(clLeaf, imgLeaf, ForestFragment()),
            Menus(clUser, imgUser, UserFragment())
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initSetting()
    }

    private fun initSetting(){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.flMain, HomeFragment())
            .commitAllowingStateLoss()

        list.forEachIndexed { index, menus ->
            menus.layout.setOnDebounceClickListener { changeSelected(index) }
        }

    }

    //selected
    fun changeSelected(tabNum: Int){
        val list = listOf(
            Menus(clHome, imgHome, HomeFragment()),
            Menus(clStory, imgStory, StoryFragment()),
            Menus(clSearch, imgSearch, CategoryFragment()),
            Menus(clLeaf, imgLeaf, ForestFragment()),
            Menus(clUser, imgUser, UserFragment())
        )

        list.forEachIndexed { index, menus ->
            if(index != 0){
                menus.img.isSelected = index == tabNum
            }
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.flMain, list[tabNum].fragment)
            .commitAllowingStateLoss()
    }

    data class Menus(
        val layout: ConstraintLayout,
        val img: ImageView,
        val fragment: Fragment
    )
}