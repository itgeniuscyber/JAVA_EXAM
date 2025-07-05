public class AQICalculator {
    public static void main(String[] args) {
        try {
            int totalAQI = 1200;
            int days = 0; // simulate a missing reading scenario
            int average = totalAQI / days;
            System.out.println("Average AQI: " + average);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero. Please check AQI data.");
        } finally {
            System.out.println("AQI calculation complete.");
        }
    }
}
