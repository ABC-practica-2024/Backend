package ro.ubb.abc2024.arheo.utils.converter;

import org.springframework.stereotype.Component;
import ro.ubb.abc2024.arheo.domain.artifact.Artifact;
import ro.ubb.abc2024.arheo.domain.auxiliary.GeographicPoint;
import ro.ubb.abc2024.arheo.domain.section.Section;
import ro.ubb.abc2024.arheo.domain.section.SectionDimensions;
import ro.ubb.abc2024.arheo.domain.site.Site;
import ro.ubb.abc2024.arheo.repository.SiteRepository;
import ro.ubb.abc2024.arheo.utils.dto.GeographicPointDto;
import ro.ubb.abc2024.arheo.utils.dto.SectionDimensionsDto;
import ro.ubb.abc2024.arheo.utils.dto.SectionDto;
import ro.ubb.abc2024.utils.converter.Converter;

import java.util.ArrayList;
import java.util.List;

@Component
public class SectionDtoConverter implements Converter<Section, SectionDto> {
    private final SiteRepository siteRepository;

    public SectionDtoConverter(SiteRepository siteRepository) {
        this.siteRepository = siteRepository;
    }

    @Override
    public Section createFromDto(SectionDto dto) {
        // get the right Site object from the database
        Site site = siteRepository.findById(dto.siteId()).orElseThrow();

        return Section.builder()
                .id(dto.id())
                .name(dto.name())
                .southWest(toEntity(dto.southWest()))
                .northWest(toEntity(dto.northWest()))
                .northEast(toEntity(dto.northEast()))
                .southEast(toEntity(dto.southEast()))
                .status(dto.status())
                .dimensions(toEntity(dto.dimensions()))
                .createdAt(dto.createdAt())
                .updatedAt(dto.updatedAt())
                .site(site)
                .artifactsList(new ArrayList<>())
                .build();
    }

    @Override
    public SectionDto createFromEntity(Section entity) {
        return new SectionDto(
                entity.getId(),
                entity.getName(),
                toDto(entity.getSouthWest()),
                toDto(entity.getNorthWest()),
                toDto(entity.getNorthEast()),
                toDto(entity.getSouthEast()),
                toDto(entity.getDimensions()),
                entity.getStatus(),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                entity.getSite().getId(),
                entity.getArtifactsList().stream().map(Artifact::getId).toList()
        );
    }

    private static GeographicPoint toEntity(GeographicPointDto dto) {
        GeographicPoint point = new GeographicPoint();
        point.setLatitude(dto.latitude());
        point.setLongitude(dto.longitude());
        return point;
    }

    private static GeographicPointDto toDto(GeographicPoint entity) {
        return new GeographicPointDto(entity.getLatitude(), entity.getLongitude());
    }

    private static SectionDimensionsDto toDto(SectionDimensions entity) {
        return new SectionDimensionsDto(entity.getLength(), entity.getWidth(), entity.getDepth());
    }

    private static SectionDimensions toEntity(SectionDimensionsDto dto) {
        return SectionDimensions.builder()
                .length(dto.length())
                .width(dto.width())
                .depth(dto.depth())
                .build();
    }

}
