package com.robertvargic.cryptochecker.ui.BaseActivity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.robertvargic.cryptochecker.R
import com.robertvargic.cryptochecker.ui.currencyList.CurrencyListFragment
import com.robertvargic.cryptochecker.ui.portfolio.PortfolioFragment
import kotlinx.android.synthetic.main.activity_base_view_pager.*

class BaseViewPagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_view_pager)

        activity_base_view_pager_bottom_navigation_view.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        setupViewPager(activity_base_view_pager_view_pager)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_currency_list -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_portfolio -> {

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    fun setupViewPager(viewPager: ViewPager) {
        var viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(CurrencyListFragment(), "Title")
        viewPagerAdapter.addFragment(PortfolioFragment(), "Title2")
        viewPager.adapter = viewPagerAdapter
    }
}