package ru.shalkoff.ui.bottombar

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ru.shalkoff.core.ui.R

sealed class BottomNavItem(
    @DrawableRes val icon: Int,
    @StringRes val description: Int
) {
    object HomeTabItem : BottomNavItem(
        R.drawable.ic_home,
        R.string.home
    )

    object HeartTabItem : BottomNavItem(
        R.drawable.ic_heart,
        R.string.heart
    )

    object ProfileTabItem : BottomNavItem(
        R.drawable.ic_person,
        R.string.profile
    )
}