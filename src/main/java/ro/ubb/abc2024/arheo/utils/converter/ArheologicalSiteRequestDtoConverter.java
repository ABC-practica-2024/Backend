package ro.ubb.abc2024.arheo.utils.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.ubb.abc2024.arheo.domain.auxiliary.GeographicPoint;
import ro.ubb.abc2024.arheo.domain.site.CreateArchaeologicalSiteRequest;
import ro.ubb.abc2024.arheo.domain.site.SiteCoordinate;
import ro.ubb.abc2024.arheo.utils.dto.ArheologicalSiteRequestDto;
import ro.ubb.abc2024.user.UserRepository;
import ro.ubb.abc2024.user.userRoleRequest.RequestStatus;
import ro.ubb.abc2024.utils.converter.Converter;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Component
public class ArheologicalSiteRequestDtoConverter implements Converter<CreateArchaeologicalSiteRequest, ArheologicalSiteRequestDto> {

    private final UserRepository userRepository;

    @Override
    public CreateArchaeologicalSiteRequest createFromDto(ArheologicalSiteRequestDto dto) {
        return CreateArchaeologicalSiteRequest.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .centerCoordinates(dto.getCenterCoordinates())
                .perimeterCoordinates(dto.getPerimeterCoordinates())
                .status(RequestStatus.PENDING)
                .createRequestTime(dto.getCreateRequestTime())
                .archeologist(userRepository.getReferenceById(dto.getArheoId()))
                .build();
    }
    private String title;
    private String description;
    private GeographicPoint centerCoordinates;
    private List<SiteCoordinate> perimeterCoordinates;
    private LocalDateTime createRequestTime;
    private Long arheoId;
    @Override
    public ArheologicalSiteRequestDto createFromEntity(CreateArchaeologicalSiteRequest entity) {

        return ArheologicalSiteRequestDto.builder()
                .title(entity.getTitle())
                .description(entity.getDescription())
                .arheoId(entity.getArcheologist().getId())
                .requestId(entity.getId())
                .status(entity.getStatus().name())
                .createRequestTime(entity.getCreateRequestTime())
                .solveRequestTime(entity.getSolveRequestTime())
                .centerCoordinates(null)
                .perimeterCoordinates(null)
                .build();
    }
}
