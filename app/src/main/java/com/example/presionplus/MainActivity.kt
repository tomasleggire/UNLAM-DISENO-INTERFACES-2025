package com.example.presionplus


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.compose.rememberNavController
import com.example.presionplus.navigation.NavigationComponent
import com.example.presionplus.ui.screens.DashboardScreen
import com.example.presionplus.ui.theme.PresionPlusTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        full size sin top bar de sistema
        /*WindowCompat.setDecorFitsSystemWindows(window, false)

        val controller = WindowInsetsControllerCompat(window, window.decorView)
        controller.hide(WindowInsetsCompat.Type.systemBars())
        controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE*/
        
        setContent {
            PresionPlusTheme {
                NavigationComponent()
            }
        }
    }
}

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val dmSerifItalic = FontFamily(
    Font(
        googleFont = GoogleFont("DM Serif Text Italic"),
        fontProvider = provider
    )
)


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PresionPlusTheme {
        DashboardScreen(
            modifier = Modifier,
            controller = rememberNavController()
        )
    }
}
