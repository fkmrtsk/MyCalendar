package com.example.mycalendar

import android.util.Log
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager


class ViewPagerAdapter(val fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {
    var mIndexes = ArrayList<Int>()

    override fun getItem(position: Int): Fragment {
        Log.v("getItem", position.toString())
        return when (position) {
            0 -> LeftFragment()
            1 -> CurrentFragment()
            else -> RightFragment()
        }
    }

    // スライドできる画面の総数を設定
    override fun getCount(): Int {
        return mIndexes.size
    }

    fun addAll(indexes: ArrayList<Int>) {
        mIndexes = indexes
    }

    fun getAll(): ArrayList<Int> {
        return mIndexes
    }

//    fun destroyAllItem(viewPager: ViewPager) {
//        for (i in 0 .. getCount()) {
//            try {
//                val obj = this.instantiateItem(viewPager, i)
//                obj?.let { destroyItem(viewPager, i, it) }
//            } catch (e: Exception) {
//            }
//        }
//    }
//
//    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
//        super.destroyItem(container!!, position, `object`)
//        if (position <= getCount()) {
//            val manager = (`object` as Fragment).fragmentManager
//            val trans: FragmentTransaction = manager!!.beginTransaction()
//            trans.remove(`object`)
//            trans.commit()
//        }
//    }

//    override fun getPageTitle(position: Int): CharSequence {
//        return listTitles[position]
//    }

}