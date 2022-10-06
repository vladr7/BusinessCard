package com.example.businesscard

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.android.animation.SegmentType
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LogoNameTitle()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        LogoNameTitle()
    }
}

@Composable
fun LogoNameTitle() {

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier
                .padding(10.dp)
                .size(100.dp)
        )
        Text(
            text = "Vlad Ricean",
            fontSize = 32.sp,
            color = Color.White
        )
        Text(
            text = "Compose Developer! :O",
            modifier = Modifier
                .padding(10.dp),
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Green
        )
        PersonalInfo(
            phoneNr = "0757123456",
            share = "@AndroidDev",
            email = "vlad@gmail.com",
        )
    }
}

@Composable
fun ColumnScope.PersonalInfo(
    phoneNr: String,
    share: String,
    email: String,
) {
    Column(
        modifier = Modifier
            .fillMaxHeight(0.5f)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
    ) {
        InfoItem(icon = painterResource(id = R.drawable.ic_baseline_local_phone_24), text = phoneNr)
        InfoItem(icon = painterResource(id = R.drawable.ic_baseline_share_24), text = share)
        InfoItem(icon = painterResource(id = R.drawable.ic_baseline_email_24), text = email)
    }
}

@Composable
fun InfoItem(
    icon: Painter,
    text: String
) {
    Divider(
        color = Color.LightGray,
        thickness = 1.dp
    )
    Row(
        modifier = Modifier.padding(
            start = 50.dp,
            top = 10.dp,
            bottom = 10.dp
        )
    ) {
        Image(
            painter = icon,
            contentDescription = null,
        )
        Text(
            text = text,
            color = Color.White,
            modifier = Modifier.padding(start = 20.dp),
        )
    }
}
