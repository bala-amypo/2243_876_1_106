@RestController
@RequestMapping("/api/readings")
@Tag(name = "Sensor Readings Endpoints")
public class SensorReadingController {

    private final SensorReadingService service;

    public SensorReadingController(SensorReadingService s) {
        this.service = s;
    }

    @PostMapping("/{sensorId}")
    public SensorReading submit(@PathVariable Long sensorId,
                                @RequestBody SensorReading r) {
        return service.submitReading(sensorId, r);
    }

    @GetMapping("/sensor/{sensorId}")
    public List<SensorReading> bySensor(@PathVariable Long sensorId) {
        return service.getReadingsBySensor(sensorId);
    }

    @GetMapping("/{id}")
    public SensorReading get(@PathVariable Long id) {
        return service.getReading(id);
    }
}
