package ro.ubb.abc2024.arheo.utils.converter;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import ro.ubb.abc2024.arheo.domain.auxiliary.GeographicPoint;
import ro.ubb.abc2024.arheo.domain.site.Site;
import ro.ubb.abc2024.arheo.domain.site.SiteCoordinate;
import ro.ubb.abc2024.arheo.repository.SiteRepository;
import ro.ubb.abc2024.arheo.utils.dto.CreateSiteDTO;
import ro.ubb.abc2024.arheo.utils.dto.GeographicPointDto;
import ro.ubb.abc2024.user.UserRepository;
import ro.ubb.abc2024.utils.converter.Converter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
public class SiteConverterDto implements Converter<Site, CreateSiteDTO> {

    GeographicPointConverterDto pointConverter = new GeographicPointConverterDto();
    private final UserRepository userRepository;

    @Override
    public Site createFromDto(CreateSiteDTO createSiteDTO) {
        List<SiteCoordinate> perimeterCoordinates=new ArrayList<>();
        long mainArheoId=createSiteDTO.mainArchaeologistID();
        var mainArheo=userRepository.findById(mainArheoId).orElse(null);
        Site site = Site.builder()
                .title(createSiteDTO.title())
                .description(createSiteDTO.description())
                .centerCoordinates(pointConverter.createFromDto(createSiteDTO.centralCoordinate()))
                .perimeterCoordinates(perimeterCoordinates)
                .status(createSiteDTO.status())
                .mainArchaelogist(mainArheo)
                .build();
        return site;
    }

    //TODO to implement
    @Override
    public CreateSiteDTO createFromEntity(Site entity) {
        return null;
    }
}
