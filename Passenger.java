public class Passenger {
    private Location pickupLocation;
    private Location destinationLocation;

    public Passenger(Location pickupLocation, Location destinationLocation) {
        this.pickupLocation = pickupLocation;
        this.destinationLocation = destinationLocation;
    }

    public Location getPickupLocation() {
        return pickupLocation;
    }

    public Location getDestinationLocation() {
        return destinationLocation;
    }
}
