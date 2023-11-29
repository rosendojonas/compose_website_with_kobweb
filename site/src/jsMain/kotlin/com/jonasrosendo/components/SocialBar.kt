package com.jonasrosendo.components

import androidx.compose.runtime.Composable
import com.jonasrosendo.styles.SocialLinkStyle
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.icons.fa.*
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.px

@Composable
fun SocialBar() {
    Column(
        modifier = Modifier
            .margin(right = 25.px)
            .padding(topBottom = 25.px)
            .minWidth(40.px)
            .borderRadius(r = 20.px)
            .backgroundColor(Colors.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SocialLinks()
    }
}

@Composable
private fun SocialLinks() {
    Link(
        path = "https://www.facebook.com",
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        FaFacebook(
            modifier = SocialLinkStyle.toModifier()
                .margin(bottom = 40.px),
            size = IconSize.LG
        )
    }
    Link(
        path = "https://www.pinterest.com",
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        FaPinterest(
            modifier = SocialLinkStyle.toModifier()
                .margin(bottom = 40.px),
            size = IconSize.LG
        )
    }
    Link(
        path = "https://www.twitter.com",
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        FaTwitter(
            modifier = SocialLinkStyle.toModifier()
                .margin(bottom = 40.px),
            size = IconSize.LG
        )
    }
    Link(
        path = "https://www.instagram.com",
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        FaInstagram(
            modifier = SocialLinkStyle.toModifier()
                .margin(bottom = 40.px),
            size = IconSize.LG
        )
    }
    Link(
        path = "https://www.linkedin.com",
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        FaLinkedin(
            modifier = SocialLinkStyle.toModifier(),
            size = IconSize.LG
        )
    }
}