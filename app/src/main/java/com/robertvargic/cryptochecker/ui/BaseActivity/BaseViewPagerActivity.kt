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

    val currencyListFragment = CurrencyListFragment()
    val portfolioFragment = PortfolioFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_view_pager)

        activity_base_view_pager_bottom_navigation_view.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        setupViewPager(activity_base_view_pager_view_pager)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_currency_list -> {
                activity_base_view_pager_view_pager.setCurrentItem(0, true)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_portfolio -> {
                activity_base_view_pager_view_pager.setCurrentItem(1, true)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun setupViewPager(viewPager: ViewPager) {
        var viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(currencyListFragment, "title1")
        viewPagerAdapter.addFragment(portfolioFragment, "title2")

        viewPager.adapter = viewPagerAdapter
    }
}