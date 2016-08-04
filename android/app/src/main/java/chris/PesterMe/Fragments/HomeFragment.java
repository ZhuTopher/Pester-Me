package chris.PesterMe.Fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import chris.PesterMe.R;

/**
 * Created by chris on 8/4/16.
 */

public class HomeFragment extends Fragment {

	private RelativeLayout homeFragRoot;
	private FloatingActionButton fab;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		// Inflates the fragment_home into the containing FrameLayout (already has parent)
		this.homeFragRoot = (RelativeLayout) inflater.inflate(R.layout.fragment_home, container, false);

		//setup floating action button
		fab = (FloatingActionButton) this.homeFragRoot.findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Toast.makeText(getContext(), "Pressed fab", Toast.LENGTH_SHORT).show();
			}
		});

		return this.homeFragRoot;
	}
}