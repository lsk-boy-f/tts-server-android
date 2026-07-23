package com.github.jing332.tts.speech

import org.junit.Assert.assertEquals
import org.junit.Test

class TextToSpeechProviderTest {
    @Test
    fun requestedNonDefaultValueOverridesConfiguredValue() {
        assertEquals(4.3f, resolveRequestedParameter(configured = 1f, requested = 4.3f))
    }

    @Test
    fun configuredValueIsUsedWhenRequestHasDefaultValue() {
        assertEquals(1.25f, resolveRequestedParameter(configured = 1.25f, requested = 1f))
    }

    @Test
    fun followAlwaysUsesRequestedValue() {
        assertEquals(1f, resolveRequestedParameter(configured = 0f, requested = 1f))
        assertEquals(1.5f, resolveRequestedParameter(configured = 0f, requested = 1.5f))
    }
}
