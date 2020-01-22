package com.example.mycalendar

import android.util.Log
import android.view.ViewGroup
import androidx.fragment.app.*
import androidx.viewpager.widget.ViewPager


class ViewPagerAdapter(val fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager) {
    var mIndexes = ArrayList<Int>()
    var year: Int = 0
    var month: Int = 0

    override fun getItem(position: Int): Fragment {
        return CurrentFragment(year, month)
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

    fun setDate(tmpYear: Int, tmpMonth: Int) {
        year = tmpYear
        month = tmpMonth
    }

    fun getYearData(): Int {
        return year
    }

    fun getMonthData(): Int {
        return month
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