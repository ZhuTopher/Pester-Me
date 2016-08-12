package chris.PesterMe.Models;

/**
 * Created by chris on 8/11/16.
 */

public abstract class Task { // TODO: use as an abstract class: SubTask, MainTask (?)
	// TODO: Task object, needs various fields including a list of subtasks
	private String title, description;

	protected Task(String title, String description) {
		this.title = title;
		this.description = description;
	}

	protected void setTitle(String title) {
		this.title = title;
	}

	protected void setDescription(String description) {
		this.description = description;
	}

	protected String getTitle() {
		return this.title;
	}

	protected String getDescription() {
		return this.description;
	}
}
