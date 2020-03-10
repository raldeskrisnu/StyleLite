package com.stylethory.raldes.module

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.stylethory.raldes.R
import com.stylethory.raldes.adapter.StyleTheoryLiteAdapter
import com.stylethory.raldes.module.fragment.color.ColorsFragment
import com.stylethory.raldes.module.fragment.products.ProductsFragment

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val adapter = StyleTheoryLiteAdapter(supportFragmentManager)
        adapter.addFragment(ProductsFragment() , " Products ")
        adapter.addFragment(ColorsFragment() , " Colors ")
        uiview_viewpager.adapter = adapter
        uiview_tablayout.setupWithViewPager(uiview_viewpager)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
