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

package com.google.samples.apps.nowinandroid.ui.lesson16

import androidx.compose.ui.test.ExperimentalTestApi
import com.kaspersky.components.composesupport.config.withComposeSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase

class Test : TestCase(Kaspresso.Builder.withComposeSupport())  {
    @OptIn(ExperimentalTestApi::class)
    fun lazyListTest() {
        run {
            LazyListScreen.items.childAt<ListItem>(3) {
                icon.assertIsDisplayed()
                title.assertTextEquals("Element title")
            }
            LazyListScreen.items.childWith<ListItem> {
                hasAnyDescendant(androidx.compose.ui.test.hasText("Element title"))
            } perform {
                icon.assertIsDisplayed()
                title.assertTextEquals("Element title")
            }
        }
    }
}