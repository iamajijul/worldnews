package com.ajijul.givemeforcast.utils.base

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.ajijul.worldnews.R
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

class MessageHandlerImp @Inject constructor() : MessageHandler {

    override fun showSnackErrorWithAction(view: View, msg: Int, action: () -> Unit) {
        val snackbar = view.indefiniteSnackbar(msg)
        snackbar.setAction(R.string.retry_text) { action() }
        snackbar.view.setBackgroundColor(
            ContextCompat.getColor(
                view.context,
                android.R.color.holo_red_dark
            )
        )
        snackbar.setTextColor( ContextCompat.getColor(
            view.context,
            android.R.color.white
        ))
        snackbar.setActionTextColor( ContextCompat.getColor(
            view.context,
            android.R.color.white
        ))
        snackbar.show()
    }

    override fun showSnackErrorWithAction(view: View, msg: String, action: () -> Unit) {
        val snackbar = view.indefiniteSnackbar(msg)
        snackbar.setAction(R.string.retry_text) { action() }
        snackbar.view.setBackgroundColor(
            ContextCompat.getColor(
                view.context,
                android.R.color.holo_red_dark
            )
        )
        snackbar.setTextColor( ContextCompat.getColor(
            view.context,
            android.R.color.white
        ))
        snackbar.setActionTextColor( ContextCompat.getColor(
            view.context,
            android.R.color.white
        ))
        snackbar.show()
    }

    override fun showSnackSuccess(view: View, msg: Int, long: Boolean) {
        val snackbar = if (!long) view.snackbar(msg)
        else view.longSnackbar(msg)
        val textView =
            snackbar.view.findViewById(com.google.android.material.R.id.snackbar_text) as TextView //Get reference of snackbar textview
        textView.maxLines = 5
        snackbar.view.setBackgroundColor(ContextCompat.getColor(view.context, android.R.color.holo_green_dark))
        snackbar.setTextColor( ContextCompat.getColor(
            view.context,
            android.R.color.white
        ))
        snackbar.setActionTextColor( ContextCompat.getColor(
            view.context,
            android.R.color.white
        ))
        snackbar.show()
    }
}

fun View.indefiniteSnackbar(msg: Int) = Snackbar.make(this, msg, Snackbar.LENGTH_INDEFINITE)
fun View.indefiniteSnackbar(msg: String) = Snackbar.make(this, msg, Snackbar.LENGTH_INDEFINITE)
fun View.longSnackbar(msg: Int) = Snackbar.make(this, msg, Snackbar.LENGTH_LONG)
fun View.snackbar(msg: Int) = Snackbar.make(this, msg, Snackbar.LENGTH_SHORT)