package ro.ubb.abc2024.arheo.utils.dto;

import ro.ubb.abc2024.arheo.domain.site.SiteCoordinate;
import ro.ubb.abc2024.arheo.domain.site.SiteStatus;

import java.util.List;

public record SiteDTO(
    String title,
    String description,
    GeographicPointDto centralCoordinate,
    List<SiteCoordinate> perimeterCoordinates,
    SiteStatus status,
    long mainArchaeologistID
){ }