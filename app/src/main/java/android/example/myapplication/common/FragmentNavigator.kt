package android.example.myapplication.common

import android.os.Bundle

interface FragmentNavigator {

    fun navigate(action: Int, bundle: Bundle)
}
