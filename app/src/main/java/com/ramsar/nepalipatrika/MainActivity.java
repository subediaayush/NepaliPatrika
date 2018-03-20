package com.ramsar.nepalipatrika;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {
	
	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link FragmentPagerAdapter} derivative, which will keep every
	 * loaded fragment in memory. If this becomes too memory intensive, it
	 * may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	private SectionsPagerAdapter mSectionsPagerAdapter;
	
	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	private ViewPager mViewPager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		
		// Create the adapter that will return a fragment for each of the three
		// primary sections of the activity.
		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
		
		// Set up the ViewPager with the sections adapter.
		mViewPager = findViewById(R.id.container);
		mViewPager.setAdapter(mSectionsPagerAdapter);
		
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
	
	
	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {
		
		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}
		
		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a NewsListFragment (defined as a static inner class below).
			return NewsListFragment.newInstance(getCategoryName(position));
		}
		
		@Override
		public int getCount() {
			// Show 3 total pages.
			return 3;
		}
	}
	
	private String getCategoryName(int position) {
		return "Nepali";
	}
	
	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class NewsListFragment extends Fragment {
		private static final String CATEGORY_ID = "category";
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private RecyclerView mNewsList;
		private SwipeRefreshLayout mSwipeRefreshLayout;
		
		/**
		 * Returns a new instance of this fragment for the given section
		 * number.
		 */
		public static NewsListFragment newInstance(String category) {
			NewsListFragment fragment = new NewsListFragment();
			Bundle args = new Bundle();
			args.putString(CATEGORY_ID, category);
			fragment.setArguments(args);
			return fragment;
		}
		
		public NewsListFragment() {
		}
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
		                         Bundle savedInstanceState) {
			View view = inflater.inflate(R.layout.fragment_news_list, container, false);
			mSwipeRefreshLayout = (SwipeRefreshLayout) view;
			mNewsList = view.findViewById(R.id.news_list);
			
			return view;
		}
	}
}
