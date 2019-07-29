package au.com.autongeneral.testapi.model;

public class ToDoItemUpdateRequest extends ToDoItemAddRequest {

	private boolean isCompleted;

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ToDoItemUpdateRequest [isCompleted=");
		builder.append(isCompleted);
		builder.append(", isCompleted()=");
		builder.append(isCompleted());
		builder.append(", getText()=");
		builder.append(getText());
		builder.append(", getClass()=");
		builder.append(getClass());
		builder.append(", hashCode()=");
		builder.append(hashCode());
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}

	public ToDoItemUpdateRequest(boolean isCompleted) {
		super();
		this.isCompleted = isCompleted;
	}
	
	
}
