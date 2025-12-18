@Entity
public class ComplianceThreshold {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Column(unique = true)
private String sensorType;


private Double minValue;
private Double maxValue;


private String severityLevel;


private LocalDateTime createdAt = LocalDateTime.now();
}