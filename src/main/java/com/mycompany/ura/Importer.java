/*
 * Importer class implementing specific VAT calculation logic
 * Demonstrates polymorphism in EFRIS system
 */

package com.mycompany.ura;

/**
 * Importer taxpayer category with 10% VAT rate
 * Overrides calculateVAT() method for import-specific logic
 */
public class Importer extends TaxCategory {
    
    /**
     * Constructor for Importer
     * @param taxpayerTIN Tax Identification Number
     * @param businessName Name of the import business
     */
    public Importer(String taxpayerTIN, String businessName) {
        super(taxpayerTIN, businessName);
        this.baseVATRate = 0.10; // 10% VAT rate for importers
    }
    
    /**
     * Calculates VAT for import transactions
     * Implements polymorphism - import-specific VAT calculation
     * @param amount Transaction amount
     * @return Calculated VAT amount (10% of transaction)
     */
    @Override
    public double calculateVAT(double amount) {
        if (!isValidAmount(amount)) {
            throw new IllegalArgumentException("Invalid transaction amount");
        }
        
        // Import VAT calculation: 10% of transaction amount
        double vatAmount = amount * baseVATRate;
        
        // Additional import-specific logic
        // Essential goods imports get further reduction
        if (isEssentialGoods(amount)) {
            vatAmount *= 0.50; // 50% reduction for essential goods
        }
        
        // Add customs duty consideration for large imports
        if (amount > 1000000) {
            // Large imports may have additional customs processing
            vatAmount += (amount * 0.02); // 2% customs processing fee
        }
        
        return Math.round(vatAmount * 100.0) / 100.0; // Round to 2 decimal places
    }
    
    /**
     * Returns the category type
     * @return Category type as string
     */
    @Override
    public String getCategoryType() {
        return "Importer";
    }
    
    /**
     * Import-specific method to determine if goods are essential
     * @param amount Transaction amount (simplified logic based on amount)
     * @return true if considered essential goods
     */
    private boolean isEssentialGoods(double amount) {
        // Simplified logic: smaller amounts often represent essential goods
        return amount < 200000;
    }
    
    /**
     * Calculate customs duty for imported goods
     * @param amount Import value
     * @return Customs duty amount
     */
    public double calculateCustomsDuty(double amount) {
        if (amount > 500000) {
            return amount * 0.25; // 25% customs duty for luxury imports
        } else {
            return amount * 0.10; // 10% customs duty for regular imports
        }
    }
}