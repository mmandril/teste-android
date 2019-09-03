package br.com.marcussouza.easyinvest.presentation.base

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import br.com.marcussouza.easyinvest.R

open class BaseActivity : AppCompatActivity(), LifecycleOwner {

    private var onStartCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState?.also {
            onStartCount = 2
        } ?: run {
            this.overridePendingTransition(
                R.anim.anim_slide_in_left,
                R.anim.anim_slide_out_left
            )
        }
    }

    override fun onStart() {
        super.onStart()
        if (onStartCount > 1) {
            this.overridePendingTransition(
                R.anim.anim_slide_in_right,
                R.anim.anim_slide_out_right
            )

        } else if (onStartCount == 1) {
            onStartCount++
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}