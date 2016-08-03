package chris.PesterMe.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import chris.PesterMe.R;

public class MainActivity extends AppCompatActivity {

	private DrawerLayout rootDrawerLayout;
	private ActionBarDrawerToggle actionBarDrawerToggle;

	private FrameLayout taskListContainer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.rootDrawerLayout = (DrawerLayout) findViewById(R.id.root_main);

		// setup toolbar
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
//		getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_first_page_white_24px);
//		getSupportActionBar().setHomeActionContentDescription(R.string.app_name);

		this.actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this,
				this.rootDrawerLayout, R.string.app_name, R.string.app_name);
//		this.actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
//		this.actionBarDrawerToggle.setHomeAsUpIndicator(R.drawable.ic_first_page_white_24px);
		this.actionBarDrawerToggle.syncState();
		this.rootDrawerLayout.addDrawerListener(this.actionBarDrawerToggle);

		//setup task list container
		this.taskListContainer = (FrameLayout) this.rootDrawerLayout.findViewById(R.id.task_list_container);

		//setup floating action button
		FloatingActionButton fab = (FloatingActionButton) this.rootDrawerLayout.findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Toast.makeText(MainActivity.this, "Pressed fab", Toast.LENGTH_SHORT).show();
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

		if(actionBarDrawerToggle.onOptionsItemSelected(item)) {
			Toast.makeText(MainActivity.this, "Pressed Actionbar Toggle", Toast.LENGTH_SHORT).show();
			return true;
		}

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			Toast.makeText(MainActivity.this, "Pressed Settings", Toast.LENGTH_SHORT).show();
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
