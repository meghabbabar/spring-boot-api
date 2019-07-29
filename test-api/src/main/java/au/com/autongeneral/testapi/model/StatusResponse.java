package au.com.autongeneral.testapi.model;


public class StatusResponse {
	
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StatusResponse [status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}
	
	

}
