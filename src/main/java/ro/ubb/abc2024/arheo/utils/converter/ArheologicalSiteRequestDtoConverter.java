package ro.ubb.abc2024.arheo.utils.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.ubb.abc2024.arheo.domain.CreateArchaeologicalSiteRequest;
import ro.ubb.abc2024.arheo.domain.Status;
import ro.ubb.abc2024.arheo.utils.dto.ArheologicalSiteRequestDto;
import ro.ubb.abc2024.user.UserRepository;
import ro.ubb.abc2024.utils.converter.Converter;

@RequiredArgsConstructor
@Component
public class ArheologicalSiteRequestDtoConverter implements Converter<CreateArchaeologicalSiteRequest, ArheologicalSiteRequestDto> {

    private final UserRepository userRepository;

    @Override
    public CreateArchaeologicalSiteRequest createFromDto(ArheologicalSiteRequestDto dto) {
        return CreateArchaeologicalSiteRequest.builder()
                .geograficCoordinates(dto.getGeograficCoordinates())
                .status(Status.PENDING)
                .createRequestTime(dto.getCreateRequestTime())
                .archeologist(userRepository.getReferenceById(dto.getArheoId()))
                .build();
    }

    @Override
    public ArheologicalSiteRequestDto createFromEntity(CreateArchaeologicalSiteRequest entity) {
        return null;
    }
}
