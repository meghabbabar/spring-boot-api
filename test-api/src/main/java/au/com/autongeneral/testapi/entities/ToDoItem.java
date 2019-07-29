package au.com.autongeneral.testapi.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "TODO")
public class ToDoItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "todo_id")
	private Long id;

	@Column(name = "text")
	private String text;

	@Column(name = "is_completed", columnDefinition = "boolean default false")
	private boolean isCompleted;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_At", nullable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
	private Date createdAt = new Date();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public ToDoItem() {
	}
	
	public ToDoItem(String text) {
		this.text = text;
	}

	public ToDoItem(String text, boolean isCompleted, Date createdAt) {
		super();
		this.text = text;
		this.isCompleted = isCompleted;
		this.createdAt = createdAt;
	}

}
