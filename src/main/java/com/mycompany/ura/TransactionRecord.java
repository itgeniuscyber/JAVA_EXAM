/*
 * TransactionRecord class demonstrating Encapsulation in EFRIS
 * Protects sensitive transaction details using private fields with public accessors
 */

package com.mycompany.ura;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Encapsulated class for storing sensitive transaction details
 * Uses private fields with public getter and setter methods
 */
public class TransactionRecord {
    // Private fields to protect sensitive data (Encapsulation)
    private String buyerTIN;
    private String sellerTIN;
    private String invoiceNumber;
    private double invoiceAmount;
    private long transactionTimestamp;
    
   
    public TransactionRecord(String buyerTIN, String sellerTIN, String invoiceNumber, 
                           double invoiceAmount, long transactionTimestamp) {
        this.buyerTIN = buyerTIN;
        this.sellerTIN = sellerTIN;
        this.invoiceNumber = invoiceNumber;
        this.invoiceAmount = invoiceAmount;
        this.transactionTimestamp = transactionTimestamp;
    }
    
    // Public getter methods (Encapsulation - controlled access)
    public String getBuyerTIN() {
        return buyerTIN;
    }
    
    public String getSellerTIN() {
        return sellerTIN;
    }
    
    public String getInvoiceNumber() {
        return invoiceNumber;
    }
    
    public double getInvoiceAmount() {
        return invoiceAmount;
    }
    
    public long getTransactionTimestamp() {
        return transactionTimestamp;
    }
    
    // Public setter methods (Encapsulation - controlled modification)
    public void setBuyerTIN(String buyerTIN) {
        if (buyerTIN != null && !buyerTIN.trim().isEmpty()) {
            this.buyerTIN = buyerTIN;
        }
    }
    
    public void setSellerTIN(String sellerTIN) {
        if (sellerTIN != null && !sellerTIN.trim().isEmpty()) {
            this.sellerTIN = sellerTIN;
        }
    }
    
    public void setInvoiceNumber(String invoiceNumber) {
        if (invoiceNumber != null && !invoiceNumber.trim().isEmpty()) {
            this.invoiceNumber = invoiceNumber;
        }
    }
    
    public void setInvoiceAmount(double invoiceAmount) {
        if (invoiceAmount >= 0) {
            this.invoiceAmount = invoiceAmount;
        }
    }
    
    public void setTransactionTimestamp(long transactionTimestamp) {
        this.transactionTimestamp = transactionTimestamp;
    }
    
    /**
     * Returns formatted transaction summary
     * @return String representation of transaction details
     */
    public String getTransactionSummary() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(transactionTimestamp);
        
        return String.format("Invoice: %s | Buyer: %s | Seller: %s | Amount: UGX %.2f | Time: %s",
                invoiceNumber, buyerTIN, sellerTIN, invoiceAmount, dateFormat.format(date));
    }
    
    /**
     * Validates transaction data integrity
     * @return true if all required fields are valid
     */
    public boolean isValidTransaction() {
        return buyerTIN != null && !buyerTIN.trim().isEmpty() &&
               sellerTIN != null && !sellerTIN.trim().isEmpty() &&
               invoiceNumber != null && !invoiceNumber.trim().isEmpty() &&
               invoiceAmount > 0 &&
               transactionTimestamp > 0;
    }
}