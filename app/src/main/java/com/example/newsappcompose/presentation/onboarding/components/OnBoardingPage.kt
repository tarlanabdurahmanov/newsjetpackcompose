package com.example.newsappcompose.presentation.onboarding.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.newsappcompose.presentation.Dimens
import com.example.newsappcompose.presentation.onboarding.Page
import com.example.newsappcompose.presentation.onboarding.pages
import com.example.newsappcompose.ui.theme.NewsAppComposeTheme


@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier, page: Page
) {

    Column(modifier) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.6f),
            painter = painterResource(id = page.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(Dimens.MediumPadding1))

        Text(
            text = page.title,
            modifier = Modifier.padding(horizontal = Dimens.MediumPadding2),
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = page.description,
            modifier = Modifier.padding(horizontal = Dimens.MediumPadding2),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}


@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun OnBoardingPagePreview() {
    NewsAppComposeTheme {
        OnBoardingPage(page = pages[0])
    }
}