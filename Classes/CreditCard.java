package Classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class CreditCard extends Card{
	
	private String expirationDate;
	private int securityCode;
	private double creditLimit;
	private ArrayList<Purchase> purchases;
	
	public CreditCard(String branch, String cardNumber, String cardHolderName, String expirationDate, int securityCode, double creditLimit) {
		super (branch, cardNumber, cardHolderName);
		
		setExpirationDate(expirationDate);
		setSecurityCode(securityCode);
		setCreditLimit(creditLimit);
		
		purchases = new ArrayList<Purchase>();
	}
	
	private void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	public String getExpirationDate() {
		return this.expirationDate;
	}
	
	private void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}
	
	public int getSecurityCode() {
		return this.securityCode;
	}
	
	private void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
	
	public double getCreditLimit() {
		return this.creditLimit;
	}

	public void addPurchase(String storeName, LocalDate purchaseDate, double purchaseAmount) {
		if ((purchaseAmount + getTotalPurchaseAmount()) < getCreditLimit()) {
			purchases.add(new Purchase(storeName, purchaseDate, purchaseAmount));	
		} else {		
			throw new LimitExceededException("O Limite não é suficiente para esta compra! Limite disponivel: " + getAvailableLimit());
		}
	}
	
	public String getPurchasesOrderingByValueAsc() {
		ArrayList<Purchase> sortedPurchases = new ArrayList<>(purchases);
		Collections.sort(sortedPurchases);
		return sortedPurchases.toString();
	}
	
	public double getTotalPurchaseAmount() {
		double totalAmount = 0;
		
		for (Purchase purchase : purchases) {
			totalAmount += purchase.getPurchaseAmount();
		}
		
		return totalAmount;
	}
	
	public double getAvailableLimit() {
		double availableLimit = getCreditLimit();
		
		for (Purchase purchase : purchases) {
			availableLimit -= purchase.getPurchaseAmount();
		}
		
		return availableLimit;
		
	}

}
