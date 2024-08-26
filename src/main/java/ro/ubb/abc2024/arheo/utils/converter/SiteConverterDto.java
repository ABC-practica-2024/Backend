package ro.ubb.abc2024.arheo.utils.converter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ro.ubb.abc2024.arheo.domain.site.Site;
import ro.ubb.abc2024.arheo.domain.site.SiteCoordinate;
import ro.ubb.abc2024.arheo.utils.dto.GeographicPointDto;
import ro.ubb.abc2024.arheo.utils.dto.SiteDTO;
import ro.ubb.abc2024.user.UserRepository;
import ro.ubb.abc2024.utils.converter.Converter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
public class SiteConverterDto implements Converter<Site, SiteDTO> {

    GeographicPointConverterDto pointConverter = new GeographicPointConverterDto();
    private final UserRepository userRepository;

    @Override
    public Site createFromDto(SiteDTO siteDTO) {
        List<SiteCoordinate> perimeterCoordinates=new ArrayList<>();
        long mainArheoId= siteDTO.mainArchaeologistID();
        var mainArheo=userRepository.findById(mainArheoId).orElse(null);
        Site site = Site.builder()
                .title(siteDTO.title())
                .description(siteDTO.description())
                .centerCoordinates(pointConverter.createFromDto(siteDTO.centralCoordinate()))
                .perimeterCoordinates(perimeterCoordinates)
                .status(siteDTO.status())
                .mainArchaeologist(mainArheo)
                .build();
        return site;
    }

    @Override
    public SiteDTO createFromEntity(Site site) {
        return new SiteDTO(
                site.getTitle(),
                site.getDescription(),
                new GeographicPointDto(site.getCenterCoordinates().getLatitude(), site.getCenterCoordinates().getLongitude()),
                site.getPerimeterCoordinates(),
                site.getStatus(),
                site.getMainArchaeologist().getId()
        );
    }
}
