/*
 * Manufacturer class implementing specific VAT calculation logic
 * Demonstrates polymorphism in EFRIS system
 */

package com.mycompany.ura;

/**
 * Manufacturer taxpayer category with variable VAT rate
 * Overrides calculateVAT() method for manufacturing-specific logic
 */
public class Manufacturer extends TaxCategory {
    
    /**
     * Constructor for Manufacturer
     * @param taxpayerTIN Tax Identification Number
     * @param businessName Name of the manufacturing business
     */
    public Manufacturer(String taxpayerTIN, String businessName) {
        super(taxpayerTIN, businessName);
        this.baseVATRate = 0.12; // 12% base VAT rate for manufacturers
    }
    
    /**
     * Calculates VAT for manufacturing transactions
     * Implements polymorphism - manufacturing-specific VAT calculation
     * @param amount Transaction amount
     * @return Calculated VAT amount (variable rate based on production type)
     */
    @Override
    public double calculateVAT(double amount) {
        if (!isValidAmount(amount)) {
            throw new IllegalArgumentException("Invalid transaction amount");
        }
        
        // Manufacturing VAT calculation with variable rates
        double vatRate = determineVATRate(amount);
        double vatAmount = amount * vatRate;
        
        // Manufacturing incentive for local production
        if (isLocalProduction(amount)) {
            vatAmount *= 0.85; // 15% reduction for local production incentive
        }
        
        // Export manufacturing gets additional benefits
        if (isExportManufacturing(amount)) {
            vatAmount *= 0.70; // 30% reduction for export manufacturing
        }
        
        return Math.round(vatAmount * 100.0) / 100.0; // Round to 2 decimal places
    }
    
    /**
     * Determines VAT rate based on manufacturing type and amount
     * @param amount Transaction amount
     * @return Applicable VAT rate
     */
    private double determineVATRate(double amount) {
        if (amount > 1000000) {
            return 0.15; // 15% for large-scale manufacturing
        } else if (amount > 300000) {
            return 0.12; // 12% for medium-scale manufacturing
        } else {
            return 0.08; // 8% for small-scale manufacturing
        }
    }
    
    /**
     * Returns the category type
     * @return Category type as string
     */
    @Override
    public String getCategoryType() {
        return "Manufacturer";
    }
    
    /**
     * Determines if production is local (simplified logic)
     * @param amount Transaction amount
     * @return true if local production
     */
    private boolean isLocalProduction(double amount) {
        // Simplified logic: medium amounts often represent local production
        return amount >= 100000 && amount <= 800000;
    }
    
    /**
     * Determines if manufacturing is for export (simplified logic)
     * @param amount Transaction amount
     * @return true if export manufacturing
     */
    private boolean isExportManufacturing(double amount) {
        // Simplified logic: very large amounts often represent export manufacturing
        return amount > 750000;
    }
    
    /**
     * Calculate production incentive bonus
     * @param amount Production value
     * @return Incentive amount
     */
    public double calculateProductionIncentive(double amount) {
        if (isExportManufacturing(amount)) {
            return amount * 0.05; // 5% export incentive
        } else if (isLocalProduction(amount)) {
            return amount * 0.02; // 2% local production incentive
        }
        return 0.0;
    }
}