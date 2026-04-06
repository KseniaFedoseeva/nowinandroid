/*
 * Copyright 2026 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.nowinandroid.ui.lesson17

import androidx.compose.remote.creation.step
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.google.samples.apps.nowinandroid.MainActivity
import com.google.samples.apps.nowinandroid.ui.lesson15.HomeScreen
import com.google.samples.apps.nowinandroid.ui.lesson15.SearchScreen
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import dagger.hilt.android.testing.HiltAndroidRule
import io.qameta.allure.kotlin.Allure.step
import org.junit.Rule
import org.junit.Test

class MyTest : TestCase(kaspressoBuilder = Kaspresso.Builder.withForcedAllureSupport(false)) {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(1)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun checkElements() {

        step("Проверка элементов toolBar") {
            HomeScreen.toolbarTitle.assertTextEquals("Now in Android")
        }
        step("Проверка HomePage") {
            HomeScreen.doneButton.assertIsDisplayed()
        }
        step("Тап на иконку поиска") {
            HomeScreen.iconSearchToolbar.performClick()
        }
        step("Проверка элеменетов SearchScreen") {
            SearchScreen.searchTextField.assertIsDisplayed()
            SearchScreen.iconSearchScreen.assertIsDisplayed()
        }
    }
}