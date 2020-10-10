package com.demoproject.model

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DisplayDataTest {
    private lateinit var data: DisplayData

    @Before
    fun setUp() {
        data = Mockito.spy(DisplayData())
    }

    @Test
    fun getWeatherId() {
        data.weatherId
    }

    @Test
    fun setWeatherId() {
        data.weatherId = 1
    }


    @Test
    fun getWeatherCity() {
        data.weatherCity
    }

    @Test
    fun setWeatherCity() {
        data.weatherCity = "Delhi"
    }

    @Test
    fun getResponse() {
        data.response
        //   Mockito.`when`(data.response.equals("")).thenReturn(true)
    }

    @Test
    fun setResponse() {
        data.response = ""
    }
}