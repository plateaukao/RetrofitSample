package plateaukao.info.retrofitsample.ui

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView

import plateaukao.info.retrofitsample.R

import kotlinx.android.synthetic.activity_web_view.*

public class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        if (getIntent() != null) {
            val intent = getIntent()
            var content = intent.getStringExtra(ARG_CONTENT)
            if(content != null) {
                loadData(content)
            }

            var character = intent.getStringExtra(ARG_CHARACTER)
            if(character != null) {
                webView.loadUrl(DIC_URL + character)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_web_view, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.getItemId()

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun loadData(content: String) {
        webView.loadDataWithBaseURL("https://zh.wikipedia.org", content, "text/html", "utf-8", null)
    }

    companion object {
        private val ARG_CONTENT = "arg_content"
        private val ARG_CHARACTER = "arg_char"
        private val DIC_URL = "https://en.m.wiktionary.org/wiki/"

        public fun startActivityWithContent(context: Context, content: String) {
            val intent = Intent(context, javaClass<WebViewActivity>())
            intent.putExtra(ARG_CONTENT, content)
            context.startActivity(intent)
        }

        public fun startActivityWithCharacter(context: Context, content: String) {
            val intent = Intent(context, javaClass<WebViewActivity>())
            intent.putExtra(ARG_CHARACTER, content)
            context.startActivity(intent)
        }
    }
}
