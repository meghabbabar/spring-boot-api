package au.com.autongeneral.testapi.model;

public class BalanceTestResult {
	
	private String input;
	
	private Boolean isBalanced;

	public BalanceTestResult(String input, Boolean isBalanced) {
		this.input = input;
		this.isBalanced = isBalanced;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public Boolean getIsBalanced() {
		return isBalanced;
	}

	public void setIsBalanced(Boolean isBalanced) {
		this.isBalanced = isBalanced;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BracketsResponse [input=");
		builder.append(input);
		builder.append(", isBalanced=");
		builder.append(isBalanced);
		builder.append("]");
		return builder.toString();
	}
	
}
