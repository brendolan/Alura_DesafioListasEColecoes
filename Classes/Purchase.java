package Classes;

import java.time.LocalDate;

class Purchase implements Comparable<Purchase>{

	private String storeName;
	private LocalDate purchaseDate;
	private double purchaseAmount;
	
	public Purchase(String storeName, LocalDate purchaseDate, double purchaseAmount) {
		setStoreName(storeName);
		setPurchaseDate(purchaseDate);
		setPurchaseAmount(purchaseAmount);
	}
	
	private void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	public String getStoreName() {
		return this.storeName;
	}
	
	private void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	public LocalDate getPurchaseDate() {
		return this.purchaseDate;
	}
	
	private void setPurchaseAmount(double purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
	
	public double getPurchaseAmount() {
		return this.purchaseAmount;
	}
	
	@Override
	public String toString() {
		return "Store: " + getStoreName() + " - Date: " + getPurchaseDate() + " - Amount: " + getPurchaseAmount();
	}

	@Override
	public int compareTo(Purchase otherPurchase) {
		if (this.getPurchaseAmount() < otherPurchase.getPurchaseAmount()) {
			return -1;	
		} else if (this.getPurchaseAmount() == otherPurchase.getPurchaseAmount()) {
			return 0;
		} else {
			return 1;
		}
		
	}
	
}
