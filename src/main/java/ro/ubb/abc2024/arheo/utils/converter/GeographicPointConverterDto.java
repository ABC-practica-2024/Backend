package ro.ubb.abc2024.arheo.utils.converter;

import org.springframework.stereotype.Component;
import ro.ubb.abc2024.arheo.domain.auxiliary.GeographicPoint;
import ro.ubb.abc2024.arheo.utils.dto.GeographicPointDto;
import ro.ubb.abc2024.user.User;
import ro.ubb.abc2024.utils.converter.Converter;
import ro.ubb.abc2024.utils.dto.RegistrationUserDto;

@Component
public class GeographicPointConverterDto implements Converter<GeographicPoint,GeographicPointDto> {
    @Override
    public GeographicPoint createFromDto(GeographicPointDto dto) {
        GeographicPoint point = new GeographicPoint();
        point.setLatitude(dto.latitude());
        point.setLongitude(dto.longitude());
        return point;
    }

    @Override
    public GeographicPointDto createFromEntity(GeographicPoint entity) {
        return new GeographicPointDto(entity.getLatitude(), entity.getLongitude());
    }
}
