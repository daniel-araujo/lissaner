package com.daniel_araujo.lissaner

import org.junit.Test

import org.junit.Assert.*

class PcmUtilsTest {
    @Test
    fun bufferSize_noIntOverflow() {
        // These parameters led to an int type overflow.
        assertEquals(52920000, PcmUtils.bufferSize(10 * 60 * 1000, 44100, 2, 1))
    }

    @Test
    fun duration_expectedIntegerResults() {
        assertEquals(1000, PcmUtils.duration(8000, 8000, 1, 1))
        assertEquals(1000, PcmUtils.duration(16000, 8000, 2, 1))
        assertEquals(1000, PcmUtils.duration(32000, 8000, 2, 2))

        assertEquals(1000, PcmUtils.duration(16000, 16000, 1, 1))
        assertEquals(2000, PcmUtils.duration(32000, 16000, 1, 1))
    }

    @Test
    fun duration_millisecondPrecision() {
        assertEquals(500, PcmUtils.duration(4000, 8000, 1, 1))
        assertEquals(125, PcmUtils.duration(1000, 8000, 1, 1))
    }
}