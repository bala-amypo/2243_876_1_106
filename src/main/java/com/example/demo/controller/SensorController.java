@RestController
@RequestMapping("/api/sensors")
@Tag(name = "Sensors Endpoints")
public class SensorController {

    private final SensorService service;

    public SensorController(SensorService s) {
        this.service = s;
    }

    @PostMapping("/{locationId}")
    public Sensor create(@PathVariable Long locationId,
                         @RequestBody Sensor sensor) {
        return service.createSensor(locationId, sensor);
    }

    @GetMapping
    public List<Sensor> all() {
        return service.getAllSensors();
    }

    @GetMapping("/{id}")
    public Sensor get(@PathVariable Long id) {
        return service.getSensor(id);
    }
}
