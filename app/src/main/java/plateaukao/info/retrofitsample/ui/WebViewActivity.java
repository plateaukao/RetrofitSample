package plateaukao.info.retrofitsample.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

import plateaukao.info.retrofitsample.R;

public class WebViewActivity extends AppCompatActivity {
	private static final String ARG_CONTENT = "arg_content";
	WebView webview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_view);
		webview = (WebView)findViewById(R.id.webView);

		if(getIntent()!=null) {
			loadData(getIntent().getStringExtra(ARG_CONTENT));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_web_view, menu);
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

	private void loadData(String content) {
		webview.loadDataWithBaseURL("https://zh.wikipedia.org", content, "text/html", "utf-8", null);
	}

	public static void startActivityWithContent(Context context, String content){
		Intent intent = new Intent(context, WebViewActivity.class);
		intent.putExtra(ARG_CONTENT, content);
		context.startActivity(intent);
	}
}
