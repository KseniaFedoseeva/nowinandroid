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

import androidx.compose.ui.semantics.SemanticsNode
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode
import io.github.kakaocup.compose.node.element.lazylist.KLazyListItemNode
import io.github.kakaocup.compose.node.element.lazylist.KLazyListNode

class ListItem(
    semanticNode: SemanticsNode,
    semanticsProvider: SemanticsNodeInteractionsProvider? = null
) : KLazyListItemNode<ListItem>(semanticNode, semanticsProvider) {

    val icon = child<KNode> {
        hasTestTag("icon")
    }

    val title = child<KNode> {
        hasTestTag("title")
    }
}

object LazyListScreen : ComposeScreen<LazyListScreen>() {

    val items = KLazyListNode(
        semanticsProvider = semanticsProvider, // передаётся только если не используется новый Kakao
        viewBuilderAction = {
            hasTestTag("lazy-list")
        },
        itemTypeBuilder = {
            itemType(::ListItem)
        },
        positionMatcher = {
            SemanticsMatcher.expectValue(LazyListItemPositionSemantics, it)
        },
        lengthSemanticsPropertyKey = LazyListSizeSemantics // передаётся только если используется новый Kakao
    )
}