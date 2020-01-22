package com.example.mycalendar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 現在の年月を取得
        val calendar = Calendar.getInstance()
        val year: Int = calendar.get(Calendar.YEAR)
        val month: Int = calendar.get(Calendar.MONTH) // 該当の月 - 1の値が渡される

        // 表示するページ数を設定する
        val indexes: ArrayList<Int> = arrayListOf(0, 1, 2)
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addAll(indexes)
        viewPagerAdapter.setDate(year, month)

        viewPager.adapter = viewPagerAdapter
        // ●←▲→■の▲を初期ページとして表示するよう設定
        viewPager.setCurrentItem(1)

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageSelected(position: Int) {
            }

            override fun onPageScrollStateChanged(state: Int) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    var indexes2: ArrayList<Int> = viewPagerAdapter.getAll()
                    val currentPage = viewPager.currentItem
                    var nextPage = 0
                    var tmpYear = viewPagerAdapter.getYearData()
                    var tmpMonth = viewPagerAdapter.getMonthData()
                    if (currentPage == 0) { //最初のページに到達
                        tmpMonth--
                        viewPagerAdapter.setDate(tmpYear, tmpMonth)
                        nextPage = 1
                        indexes2.add(0, indexes2[0] - 1)
                        indexes2.removeAt(indexes2.size - 1)
                        //1ページ目は既に存在するため、Fragmentを全て破棄する
//                        viewPagerAdapter.destroyAllItem(viewPager)
                    } else if (currentPage === indexes2.size - 1) { //最後のページに到達
                        tmpMonth++
                        viewPagerAdapter.setDate(tmpYear, tmpMonth)
                        nextPage = 1
                        indexes2.add(indexes2[indexes2.size - 1] + 1)
                        indexes2.removeAt(0)
                    }
                    viewPagerAdapter.notifyDataSetChanged()
                    viewPagerAdapter.addAll(indexes2)
                    viewPager.setAdapter(viewPagerAdapter)
                    viewPager.setCurrentItem(nextPage)
                }
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }
        })
    }
}
