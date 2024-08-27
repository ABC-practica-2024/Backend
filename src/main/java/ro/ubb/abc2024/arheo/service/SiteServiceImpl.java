package ro.ubb.abc2024.arheo.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.arheo.domain.section.Section;
import ro.ubb.abc2024.arheo.domain.section.SectionStatus;
import ro.ubb.abc2024.arheo.domain.site.Site;
import ro.ubb.abc2024.arheo.domain.site.SiteStatus;
import ro.ubb.abc2024.arheo.repository.SiteRepository;
import ro.ubb.abc2024.arheo.utils.dto.SiteDTO;
import ro.ubb.abc2024.utils.exception.UserServiceException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SiteServiceImpl implements SiteService{

    @Autowired
    private SectionService sectionService;

    private final SiteRepository siteRepository;

    @Transactional
    public List<Site> getAll(){
        return siteRepository.getSitesWithSectionsAndArchaeologists();
    }

    public List<Site> getAllByStatus(SiteStatus status){
        return siteRepository.getSitesByStatus(status);
    }

    public Site getSiteByTitle(String title){
        return siteRepository.getSiteByTitle(title);
    }

    public Site addSite(Site site){
        return siteRepository.save(site);
    }

    public void deleteSite(Long id){
        siteRepository.deleteById(id);
    }

    public Site getSite(Long id){
        return siteRepository.getSiteById(id);
    }

    @Transactional
    public Site updateSite(long siteId, SiteDTO newSite){

        var updateSite = this.siteRepository.findById(siteId).orElseThrow(
                () -> new EntityNotFoundException(String.format("Site with id %d, does not exist.", siteId)
                ));
        updateSite.setTitle(newSite.title());
        updateSite.setDescription(newSite.description());
        updateSite.setStatus(newSite.status());
//        try {
//            validator.validate(user);
        return this.siteRepository.save(updateSite);
//        } catch (ConstraintViolationException ex){
//            throw new UserServiceException(ex.getMessage());
//        }
    }

    public List<Section> getSectionsBySiteId(Long siteId){
        return siteRepository.getSiteById(siteId).getSections();
    }

    public List<Section> getSectionsBySiteIdAndStatus(Long siteId, SectionStatus status){
        return sectionService.getSectionsByStatusIsAndSiteId(status.name(), siteId);
    }
}
