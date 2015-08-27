package plateaukao.info.retrofitsample.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

import plateaukao.info.retrofitsample.R;
import plateaukao.info.retrofitsample.api.WikiApiEndpointInterface;
import plateaukao.info.retrofitsample.api.WikiService;
import plateaukao.info.retrofitsample.model.WikiModel;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {
	Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button = (Button)findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				WikiApiEndpointInterface wikiInterface = WikiService.getWikiApiEndpointInterface();
				wikiInterface.geAuthorContent("白居易", new Callback<String>() {
					@Override
					public void success(String content, Response response) {
						try {
							JSONObject jobj = new JSONObject(content);
							JSONObject pages = jobj.getJSONObject("query").getJSONObject("pages");
							String data = ((JSONObject)(pages.getJSONObject(pages.keys().next()).getJSONArray("revisions").get(0))).getString("*");
							Log.v("wiki", data);
							WebViewActivity.startActivityWithContent(MainActivity.this, data);

						} catch (JSONException e) {
							e.printStackTrace();
						}
					}

					@Override
					public void failure(RetrofitError error) {
						Log.v("wiki", "fail");
					}
				});
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
