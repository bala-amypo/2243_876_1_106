@RestController
@RequestMapping("/api/locations")
@Tag(name = "Locations Endpoints")
public class LocationController {

    private final LocationService service;

    public LocationController(LocationService s) {
        this.service = s;
    }

    @PostMapping
    public Location create(@RequestBody Location l) {
        return service.createLocation(l);
    }

    @GetMapping
    public List<Location> all() {
        return service.getAllLocations();
    }
}
