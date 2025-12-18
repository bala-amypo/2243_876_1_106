@RestController
@RequestMapping("/api/thresholds")
@Tag(name = "Thresholds Endpoints")
public class ComplianceThresholdController {

    private final ComplianceThresholdService service;

    public ComplianceThresholdController(ComplianceThresholdService s) {
        this.service = s;
    }

    @PostMapping
    public ComplianceThreshold create(@RequestBody ComplianceThreshold t) {
        return service.createThreshold(t);
    }

    @GetMapping
    public List<ComplianceThreshold> all() {
        return service.getAllThresholds();
    }

    @GetMapping("/{id}")
    public ComplianceThreshold get(@PathVariable Long id) {
        return service.getThreshold(id);
    }

    @GetMapping("/type/{sensorType}")
    public ComplianceThreshold getByType(@PathVariable String sensorType) {
        return service.getThresholdBySensorType(sensorType);
    }
}
