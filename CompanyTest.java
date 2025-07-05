
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompanyTest {
    private Company company;

    @BeforeEach
    public void setUp() {
        company = new Company();
        // Add vehicles if required
    }

    @Test
    public void testSchedulePickupSuccess() {
        Location pickup = new Location(10, 10);
        Location destination = new Location(20, 20);
        Passenger passenger = new Passenger(pickup, destination);
        boolean result = company.schedulePickup(passenger);
        assertTrue(result);
    }

    @Test
    public void testSchedulePickupFailWhenNoVehicle() {
        Company emptyCompany = new Company(); // with no vehicles
        Location pickup = new Location(10, 10);
        Location destination = new Location(20, 20);
        Passenger passenger = new Passenger(pickup, destination);
        boolean result = emptyCompany.schedulePickup(passenger);
        assertFalse(result);
    }
}
