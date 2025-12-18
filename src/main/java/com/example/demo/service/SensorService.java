@Service
public class SensorService {

    private final SensorRepository sensorRepo;
    private final LocationRepository locationRepo;

    public SensorService(SensorRepository s, LocationRepository l) {
        this.sensorRepo = s;
        this.locationRepo = l;
    }

    public Sensor createSensor(Long locationId, Sensor sensor) {
        Location loc = locationRepo.findById(locationId)
                .orElseThrow(() -> new ResourceNotFoundException("Location"));
        sensor.setLocation(loc);
        return sensorRepo.save(sensor);
    }
}
