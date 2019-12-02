package android.example.myapplication.common.utils

import android.view.View
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

fun Disposable.addTo(compositeDisposable: CompositeDisposable) = compositeDisposable.add(this)

var View.isVisible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if(value) View.VISIBLE
        else View.GONE
    }
