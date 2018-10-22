package com.spotprompt.learning.listModule

import com.example.bhawanap.testapplication.SecondModule.DataObserver
import com.example.bhawanap.testapplication.SecondModule.Model
import com.example.bhawanap.testapplication.SecondModule.SecondView
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

/**
 * **  Created by home on 22-Oct-18.
 */
@RunWith(MockitoJUnitRunner::class)
class dataObserverTest {

    @Mock
    lateinit var mockListView: SecondView

    @Mock
    lateinit var mockList: List<Model>

    lateinit var dataObserver: DataObserver


    @Before
    fun setUp() {

        dataObserver = DataObserver(mockListView)
    }

    @Test
    fun should_call_updateList_when_onNext() {
        Observable.just(mockList).subscribe(dataObserver)
        verify(mockListView, times(1)).updateData(mockList)
    }

}