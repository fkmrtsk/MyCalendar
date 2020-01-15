package com.example.mycalendar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val indexes: ArrayList<Int> = arrayListOf(0, 1, 2)
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addAll(indexes)

        viewPager.adapter = viewPagerAdapter
        // ●←▲→■の▲を初期ページとして表示するよう設定
        viewPager.setCurrentItem(1)

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageSelected(position: Int) {
            }

            override fun onPageScrollStateChanged(state: Int) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    val viewPagerAdapter2 = ViewPagerAdapter(supportFragmentManager)
                    viewPagerAdapter2.addAll(indexes)
                    var indexes2: ArrayList<Int> = viewPagerAdapter2.getAll()
                    val currentPage = viewPager.currentItem
                    if( currentPage != 0 && currentPage != indexes2.size - 1){
                        Log.v("test:onPageScrollStateChanged", "return")
                        //最初でも最後のページでもない場合処理を抜ける
                        return;
                    }

                    var nextPage = 0
                    if (currentPage == 0) { //最初のページに到達
                        Log.v("test:onPageScrollStateChanged", "0")
                        nextPage = 1
                        indexes2.add(0, indexes2[0] - 1)
                        //1ページ目は既に存在するため、Fragmentを全て破棄する
//                        viewPagerAdapter2.destroyAllItem(viewPager)
                        viewPagerAdapter2.notifyDataSetChanged()
                    } else if (currentPage === indexes2.size - 1) { //最後のページに到達
                        Log.v("test:onPageScrollStateChanged", "1")
                        nextPage = currentPage
                        indexes2.add(indexes[indexes2.size - 1] + 1)
                    }
                    viewPagerAdapter2.addAll(indexes2);
                    viewPager.setAdapter(viewPagerAdapter2);
                    viewPager.setCurrentItem(nextPage);
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
