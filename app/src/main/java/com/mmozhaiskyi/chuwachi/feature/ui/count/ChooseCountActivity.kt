package com.mmozhaiskyi.chuwachi.feature.ui.count

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.mmozhaiskyi.chuwachi.R
import kotlinx.android.synthetic.main.activity_choose_count.*

class ChooseCountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_count)

        val items = ContentFactory.content

        val layoutManager = GridLayoutManager(this, SPAN_SIZE).apply {
            spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {

                override fun getSpanSize(position: Int): Int {
                    val type = items[position].type
                    return when (type) {
                        ChooseCountContentModel.ViewType.MORE_BUTTON,
                        ChooseCountContentModel.ViewType.TITLE -> SPAN_SIZE
                        else -> 1
                    }
                }
            }
        }

        contentList.layoutManager = layoutManager
        contentList.adapter = ChooseCountContentAdapter(items) {

        }
    }

    companion object {

        private const val SPAN_SIZE = 3
    }
}
