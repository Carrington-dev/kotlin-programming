package za.co.stemgon.navapp.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(val route: String, val title:String, val icon: ImageVector) {
    data object Home: BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    data object Profile: BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.AccountCircle
    )

    data object Settings: BottomBarScreen(
        route = "settings",
        title = "Settings",
        icon = Icons.Default.Settings
    )
}