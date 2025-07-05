import java.util.Arrays;
import java.util.Random;

public class AirQualityMonitor {
    public static void main(String[] args) {
        int[] aqiReadings = new int[30];
        Random random = new Random();
        int hazardousDays = 0;

        //  Generate 30 random AQI readings between 1 and 300
        for (int i = 0; i < 30; i++) {
            aqiReadings[i] = random.nextInt(300) + 1;
            if (aqiReadings[i] > 200) {
                hazardousDays++;
            }
        }

        // Display the readings
        System.out.println("AQI Readings: " + Arrays.toString(aqiReadings));

        // ii) Compute the median
        Arrays.sort(aqiReadings);
        double median;
        if (aqiReadings.length % 2 == 0) {
            median = (aqiReadings[14] + aqiReadings[15]) / 2.0;
        } else {
            median = aqiReadings[aqiReadings.length / 2];
        }
        System.out.println("Median AQI: " + median);

        //  Display hazardous days count
        System.out.println("Number of hazardous days (AQI > 200): " + hazardousDays);
    }
}
