/*
 * Retailer class implementing specific VAT calculation logic
 * Demonstrates polymorphism in EFRIS system
 */

package com.mycompany.ura;

/**
 * Retailer taxpayer category with 18% VAT rate
 * Overrides calculateVAT() method for retail-specific logic
 */
public class Retailer extends TaxCategory {
    
    /**
     * Constructor for Retailer
     * @param taxpayerTIN Tax Identification Number
     * @param businessName Name of the retail business
     */
    public Retailer(String taxpayerTIN, String businessName) {
        super(taxpayerTIN, businessName);
        this.baseVATRate = 0.18; // 18% VAT rate for retailers
    }
    
    /**
     * Calculates VAT for retail transactions
     * Implements polymorphism - retail-specific VAT calculation
     * @param amount Transaction amount
     * @return Calculated VAT amount (18% of transaction)
     */
    @Override
    public double calculateVAT(double amount) {
        if (!isValidAmount(amount)) {
            throw new IllegalArgumentException("Invalid transaction amount");
        }
        
        // Retail VAT calculation: 18% of transaction amount
        double vatAmount = amount * baseVATRate;
        
        // Additional retail-specific logic
        // Small retailers (transactions < 100,000) get slight reduction
        if (amount < 100000) {
            vatAmount *= 0.95; // 5% reduction for small transactions
        }
        
        return Math.round(vatAmount * 100.0) / 100.0; // Round to 2 decimal places
    }
    
    /**
     * Returns the category type
     * @return Category type as string
     */
    @Override
    public String getCategoryType() {
        return "Retailer";
    }
    
    /**
     * Retail-specific method to check if eligible for small business exemption
     * @param annualTurnover Annual business turnover
     * @return true if eligible for exemption
     */
    public boolean isEligibleForSmallBusinessExemption(double annualTurnover) {
        return annualTurnover < 150000000; // 150 million UGX threshold
    }
}