package chris.PesterMe.Fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import chris.PesterMe.R;

/**
 * Created by chris on 8/4/16.
 */

public class HomeFragment extends Fragment {

	private RelativeLayout homeFragRoot;

	private FrameLayout upcomingTaskContainer, taskListContainer;
	private RecyclerView upcomingTask, taskList;

	private FloatingActionButton fab;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		// Inflates the fragment_home into the containing FrameLayout (already has parent)
		this.homeFragRoot = (RelativeLayout) inflater.inflate(R.layout.fragment_home, container, false);

		this.upcomingTaskContainer = (FrameLayout) this.homeFragRoot.findViewById(R.id.upcoming_task_container);
		this.upcomingTask = (RecyclerView) this.upcomingTaskContainer.findViewById(R.id.tasks_list);
		this.upcomingTask.setHasFixedSize(true); // only ever contains one item
		LinearLayoutManager upcomingTaskLlm = new LinearLayoutManager(getContext());
		upcomingTaskLlm.setOrientation(LinearLayoutManager.VERTICAL);
		this.upcomingTask.setLayoutManager(upcomingTaskLlm);

		this.taskListContainer = (FrameLayout) this.homeFragRoot.findViewById(R.id.task_list_container);
		this.taskList = (RecyclerView) this.taskListContainer.findViewById(R.id.tasks_list);
		this.taskList.setHasFixedSize(false); // TODO: only have most recent task showing (with subtasks)?
		LinearLayoutManager taskListLlm = new LinearLayoutManager(getContext());
		taskListLlm.setOrientation(LinearLayoutManager.VERTICAL);
		this.taskList.setLayoutManager(taskListLlm);



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