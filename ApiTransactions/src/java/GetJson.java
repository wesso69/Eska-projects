public class GetJson {

	private String transactionId;
	private String status;
	private String errorMessage;

	public GetJson(String transactionId, String status, String errorMessage) {
		super();
		this.transactionId = transactionId;
		this.status = status;
		this.errorMessage = errorMessage;
		
	}

	public GetJson() {
		super();
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
