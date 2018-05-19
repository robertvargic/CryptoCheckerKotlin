package com.robertvargic.cryptochecker

import com.robertvargic.cryptochecker.ui.currencyList.CurrencyListContract
import com.robertvargic.cryptochecker.ui.currencyList.CurrencyListPresenter
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CurrencyListPresenterTest {

    private lateinit var presenter: CurrencyListPresenter

    @Mock lateinit var currencyListView: CurrencyListContract.View

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        presenter = CurrencyListPresenter(currencyListView)
    }

    @Test
    fun testInitListView() {
//        presenter.getCurrencyList()
//
//        verify(currencyListView).initListView()
//
//        verifyNoMoreInteractions(currencyListView)
    }

}