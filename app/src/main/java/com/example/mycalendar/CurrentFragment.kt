package com.example.mycalendar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_current.view.*
import java.util.*

class CurrentFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_current, container, false)
        view.button.setOnClickListener {
            findNavController().navigate(R.id.action_first_to_second)
        }
        return view
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        // カレンダー用のパッケージ
//        val calendar   = Calendar.getInstance()
//        var year: Int  = calendar.get(Calendar.YEAR)
//        var month: Int = calendar.get(Calendar.MONTH)
//        var day: Int   = calendar.get(Calendar.DATE)
//        var dayView    = arrayOfNulls<Int>(42)
//
//
//        // 今月の初日の曜日を取得
//        calendar.set(year, month, 1)
//        val firstDayWeek: Int = calendar.get(Calendar.DAY_OF_WEEK)
//
//        // 先月の最終日を取得
//        calendar.set(year, month, 0)
//        val beforeMonthLastDay: Int = calendar.get(Calendar.DATE)
//
//        // 今月の最終日を取得
//        calendar.set(year, month + 1, 0)
//        val currentMonthLastDay: Int = calendar.get(Calendar.DATE)
//
//        var count: Int = 0
//        for (i in firstDayWeek - 2 downTo 0) {
//            dayView[count] = beforeMonthLastDay - i
//            count++
//        }
//
//        for (i in 1 .. currentMonthLastDay) {
//            dayView[count] = i
//            count++
//        }
//
//        var nextMonthDay: Int = 1
//        for (i in count..41) {
//            dayView[count] = nextMonthDay
//            nextMonthDay++
//            count++
//        }
//
//        // 現在の月を表示
//        currentMonthView.text = (month + 1).toString() + "月"
//        // ViewのIDを配列に格納
//        var dayTexiView = arrayOf(
//            sunFirstView, monFirstView, tueFirstView, wedFirstView, thuFirstView, friFirstView,satFirstView,
//            sunSecondView, monSecondView, tueSecondView, wedSecondView, thuSecondView, friSecondView,satSecondView,
//            sunThirdView, monThirdView, tueThirdView, wedThirdView, thuThirdView, friThirdView,satThirdView,
//            sunFourthView, monFourthView, tueFourthView, wedFourthView, thuFourthView, friFourthView,satFourthView,
//            sunFifthView, monFifthView, tueFifthView, wedFifthView, thuFifthView, friFifthView,satFifthView,
//            sunSixthView, monSixthView, tueSixthView, wedSixthView, thuSixthView, friSixthView,satSixthView
//        )
//        for ((index, value) in dayView.withIndex()) {
//            dayTexiView[index].text = value.toString()
//            if (index == 0 ||
//                index == 7 ||
//                index == 14 ||
//                index == 21 ||
//                index == 28 ||
//                index == 35
//            ) {
//                dayTexiView[index].setTextColor(Color.RED)
//            } else if (index == 6 ||
//                index == 13 ||
//                index == 20 ||
//                index == 27 ||
//                index == 34 ||
//                index == 41) {
//                dayTexiView[index].setTextColor(Color.BLUE)
//            }
//        }
//    }
}
