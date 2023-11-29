package com.jonasrosendo.sections

import androidx.compose.runtime.Composable
import com.jonasrosendo.components.SectionTitle
import com.jonasrosendo.components.SkillBar
import com.jonasrosendo.models.Section
import com.jonasrosendo.models.Skill
import com.jonasrosendo.models.Theme
import com.jonasrosendo.styles.AboutImageStyle
import com.jonasrosendo.styles.AboutTextStyle
import com.jonasrosendo.utils.Constants
import com.jonasrosendo.utils.Constants.LOREM_IPSUM_SHORT
import com.jonasrosendo.utils.Res
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun AboutSection() {
    Box(
        modifier = Modifier
            .id(Section.About.id)
            .maxWidth(Constants.SECTION_WIDTH.px)
            .padding(topBottom = 150.px),
        contentAlignment = Alignment.TopCenter
    ) {
        AboutContent()
    }
}

@Composable
fun AboutContent() {
    val breakpoint = rememberBreakpoint()

    Column(
        modifier = Modifier
            .fillMaxWidth(if (breakpoint >= Breakpoint.MD) 100.percent else 90.percent)
            .maxWidth(1200.px),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SimpleGrid(
            numColumns = numColumns(base = 1, md = 2),
            modifier = Modifier
                .fillMaxWidth(
                    if (breakpoint >= Breakpoint.MD) 90.percent else 100.percent
                )
        ) {
            if (breakpoint >= Breakpoint.MD) {
                AboutImage()
            }
            AboutMe()
        }
    }
}

@Composable
fun AboutImage() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            src = Res.Image.ABOUT_IMAGE,
            description = "About Image",
            modifier = AboutImageStyle.toModifier().fillMaxWidth(80.percent)
        )
    }
}

@Composable
fun AboutMe() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        SectionTitle(section = Section.About)

        P(
            attrs = AboutTextStyle.toModifier()
                .margin(topBottom = 25.px)
                .fontFamily(Constants.STANDARD_FONT_FAMILY)
                .fontSize(18.px)
                .fontStyle(FontStyle.Italic)
                .fontWeight(FontWeight.Normal)
                .color(Theme.Secondary.rgb)
                .toAttrs()
        ) {
            Text(LOREM_IPSUM_SHORT)
        }

        Skill.entries.forEach { skill ->
            SkillBar(name = skill.title, percentage = skill.percentage)
        }

    }
}