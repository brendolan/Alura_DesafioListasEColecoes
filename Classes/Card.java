package Classes;

class Card {
		
	private String branch;
	private String cardNumber;
	private String cardHolderName;

	public Card(String branch, String cardNumber, String cardHolderName) {
		setBranch(branch);
		setCardNumber(cardNumber);
		setCardHolderName(cardHolderName);
	}
	
	private void setBranch(String branch) {
		this.branch = branch;
	}
	
	public String getBranch() {
		return this.branch;
	}
	
	private void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public String getCardNumber() {
		return this.cardNumber;
	}
	
	private void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	
	public String getCardHolderName() {
		return this.cardHolderName;
	}

}
