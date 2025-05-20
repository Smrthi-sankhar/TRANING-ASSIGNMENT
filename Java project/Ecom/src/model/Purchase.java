package model;
import java.time.LocalDate;

public class Purchase {
    private int purchaseId;
    private int customerId;
    private int productId;
    private int quantity;
    private LocalDate purchaseDate;
    
    public Purchase() { }
	public Purchase(int purchaseId, int customerId, int productId, int quantity, LocalDate purchaseDate) {
		super();
		this.purchaseId = purchaseId;
		this.customerId = customerId;
		this.productId = productId;
		this.quantity = quantity;
		this.purchaseDate = purchaseDate;
	}
	public int getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(int PurchaseId) {
		this.purchaseId = PurchaseId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	@Override
	public String toString() {
		return "Purchase [id=" + purchaseId + ", customerId=" + customerId + ", productId=" + productId + ", quantity="
				+ quantity + ", purchaseDate=" + purchaseDate + "]";
	}  
}


