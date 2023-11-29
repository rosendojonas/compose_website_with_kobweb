package com.jonasrosendo.components

import androidx.compose.runtime.Composable
import com.jonasrosendo.models.Section
import com.jonasrosendo.models.Theme
import com.jonasrosendo.styles.LogoStyle
import com.jonasrosendo.styles.NavigationItemStyle
import com.jonasrosendo.utils.Constants.FONT_FAMILY
import com.jonasrosendo.utils.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgb

@Composable
fun Header() {
    Row(
        modifier = Modifier.fillMaxWidth(80.percent)
            .margin(topBottom = 50.px),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LeftSide()
        RightSide()
    }
}

@Composable
fun LeftSide() {
    Row {
        Image(src = Res.Image.LOGO, description = "Logo Image", modifier = LogoStyle.toModifier())
    }
}

@Composable
fun RightSide() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .borderRadius(r = 50.px)
            .backgroundColor(Theme.LighterGray.rgb)
            .padding(all = 20.px),
        horizontalArrangement = Arrangement.End
    ) {
        Section.entries.take(6).forEach { section ->
            Link(
                path = section.path,
                modifier = NavigationItemStyle.toModifier()
                    .margin(right = 30.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Normal)
                    .textDecorationLine(TextDecorationLine.None),
                text = section.title
            )
        }
    }
}