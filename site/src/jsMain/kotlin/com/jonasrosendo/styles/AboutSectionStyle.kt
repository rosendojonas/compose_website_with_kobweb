package com.jonasrosendo.styles

import com.jonasrosendo.models.Theme
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.TransitionProperty
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.anyLink
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*

@OptIn(ExperimentalComposeWebApi::class)
val AboutImageStyle by ComponentStyle {
    base {
        Modifier
            .styleModifier { filter { grayscale(100.percent) } }
            .borderRadius(
                topLeft = 0.px,
                topRight = 0.px,
                bottomLeft = 0.px,
                bottomRight = 0.px,
            )
            .transition(CSSTransition(property = TransitionProperty.All, duration = 200.ms))
    }
    hover {
        Modifier
            .styleModifier { filter { grayscale(0.percent) } }
            .borderRadius(r = 100.percent)
            .rotate(10.deg)
    }
}

val AboutTextStyle by ComponentStyle {
    base {
        Modifier
            .opacity(50.percent)
            .transition(CSSTransition(property = "opacity", duration = 200.ms))

    }
    hover {
        Modifier
            .opacity(100.percent)
    }
}