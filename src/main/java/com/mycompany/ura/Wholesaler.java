/*
 * Wholesaler class implementing specific VAT calculation logic
 * Demonstrates polymorphism in EFRIS system
 */

package com.mycompany.ura;

/**
 * Wholesaler taxpayer category with 15% VAT rate
 * Overrides calculateVAT() method for wholesale-specific logic
 */
public class Wholesaler extends TaxCategory {
    
    
    public Wholesaler(String taxpayerTIN, String businessName) {
        super(taxpayerTIN, businessName);
        this.baseVATRate = 0.15; // 15% VAT rate for wholesalers
    }
    
    
    @Override
    public double calculateVAT(double amount) {
        if (!isValidAmount(amount)) {
            throw new IllegalArgumentException("Invalid transaction amount");
        }
        
        // Wholesale VAT calculation: 15% of transaction amount
        double vatAmount = amount * baseVATRate;
        
        // Additional wholesale-specific logic
        // Bulk transactions (> 500,000) get volume discount
        if (amount > 500000) {
            vatAmount *= 0.90; // 10% reduction for bulk transactions
        }
        
        return Math.round(vatAmount * 100.0) / 100.0; // Round to 2 decimal places
    }
    

    @Override
    public String getCategoryType() {
        return "Wholesaler";
    }
    
  
    public double getVolumeDiscount(double amount) {
        if (amount > 1000000) {
            return 0.15; // 15% discount for very large orders
        } else if (amount > 500000) {
            return 0.10; // 10% discount for large orders
        }
        return 0.0; // No discount for smaller orders
    }
}