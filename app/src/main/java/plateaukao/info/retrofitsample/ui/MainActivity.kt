package plateaukao.info.retrofitsample.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import org.json.JSONException
import org.json.JSONObject
import plateaukao.info.retrofitsample.R
import plateaukao.info.retrofitsample.api.WikiService
import retrofit.Callback
import retrofit.RetrofitError
import retrofit.client.Response

import kotlinx.android.synthetic.activity_main.*

public class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            val wikiInterface = WikiService.getWikiApiEndpointInterface()
            wikiInterface.geAuthorContent("王羲之", object : Callback<String> {
                override fun success(content: String, response: Response) {
                    try {
                        val job = JSONObject(content)
                        val pages = job.getJSONObject("query").getJSONObject("pages")
                        val data = ((pages.getJSONObject(pages.keys().next()).getJSONArray("revisions").get(0)) as JSONObject).getString("*")
                        Log.v("wiki", data)
                        WebViewActivity.startActivityWithContent(this@MainActivity, data)

                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }

                }

                override fun failure(error: RetrofitError) {
                    Log.v("wiki", "fail")
                }
            })
        }

        bt_character.setOnClickListener{
            WebViewActivity.startActivityWithCharacter(this@MainActivity, "國")
            /*
            val wikiInterface = WikiService.getDictApiEndpointInterface()
            wikiInterface.geCharContent("國", object : Callback<String> {
                override fun success(content: String, response: Response) {
                    try {
                        val job = JSONObject(content)
                        val data = job.getJSONObject("parse").getJSONObject("text").getString("*")
                        Log.v("wikidictionary", content)
                        WebViewActivity.startActivityWithCharacter(this@MainActivity, data)

                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }

                }

                override fun failure(error: RetrofitError) {
                    Log.v("wiki", "fail")
                }
            })
            */
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu)
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
}
