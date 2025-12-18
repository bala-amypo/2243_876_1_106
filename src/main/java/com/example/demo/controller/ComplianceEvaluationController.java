@RestController
@RequestMapping("/api/compliance")
@Tag(name = "Compliance Evaluation Endpoints")
public class ComplianceEvaluationController {

    private final ComplianceEvaluationService service;

    public ComplianceEvaluationController(ComplianceEvaluationService s) {
        this.service = s;
    }

    @PostMapping("/evaluate/{readingId}")
    public ComplianceLog evaluate(@PathVariable Long readingId) {
        return service.evaluateReading(readingId);
    }

    @GetMapping("/reading/{readingId}")
    public List<ComplianceLog> logs(@PathVariable Long readingId) {
        return service.getLogsByReading(readingId);
    }

    @GetMapping("/{id}")
    public ComplianceLog get(@PathVariable Long id) {
        return service.getLog(id);
    }
}
