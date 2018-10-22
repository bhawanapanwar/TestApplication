package com.spotprompt.learning.listModule

import com.example.bhawanap.testapplication.SecondModule.Iterator
import com.example.bhawanap.testapplication.SecondModule.Model
import com.example.bhawanap.testapplication.SecondModule.Presenter
import com.example.bhawanap.testapplication.SecondModule.SecondView
import io.reactivex.Observable
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

/**
 * **  Created by home on 22-Oct-18.
 */
@RunWith(MockitoJUnitRunner::class)
class ListPresenterTest {

    @Mock
    lateinit var mockListView: SecondView

    @Mock
    lateinit var mockList: List<Model>

    @Mock
    lateinit var mockListIterator: Iterator

    lateinit var listPresenter: Presenter

    @Before
    fun setUp() {
        listPresenter = Presenter(mockListView, mockListIterator)
    }

    @Test
    @Ignore
    fun should_call_updateList_on_getData() {
        `when`(mockListIterator.hitApi()).thenReturn(Observable.just(mockList))
                listPresenter.getData()
    }
}