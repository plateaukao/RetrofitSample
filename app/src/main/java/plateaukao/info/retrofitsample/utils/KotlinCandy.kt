package plateaukao.info.retrofitsample.utils

import android.view.View

/**
 * @author Daniel Kao
 */

public fun onClickListener(action: (View) -> Unit): View.OnClickListener {
    return object : View.OnClickListener {
        public override fun onClick(v: View) {
            action(v)
        }
    }
}

public fun View.setOnClickListener(action: (View?) -> Unit): Unit {
    setOnClickListener(onClickListener(action))
}