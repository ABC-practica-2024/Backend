package ro.ubb.abc2024.arheo.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.ubb.abc2024.arheo.domain.site.Site;
import ro.ubb.abc2024.arheo.domain.site.SiteStatus;
import ro.ubb.abc2024.arheo.repository.SiteRepository;
import ro.ubb.abc2024.utils.exception.UserServiceException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SiteServiceImpl implements SiteService{
    private final SiteRepository siteRepository;
    public List<Site> getAll(){
        return siteRepository.findAll();
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
    // TODO finish this with dtos
    @Transactional
    public Site updateSite(long siteId, Site newSite){

        var updateSite = this.siteRepository.findById(siteId).orElseThrow(
                () -> new EntityNotFoundException(String.format("Site with id %d, does not exist.", siteId)
                ));
        updateSite.setTitle(newSite.getTitle());
        updateSite.setDescription(newSite.getDescription());
        updateSite.setStatus(newSite.getStatus());
        updateSite.setMainArchaeologist(newSite.getMainArchaeologist());
//        try {
//            validator.validate(user);
        return this.siteRepository.save(updateSite);
//        } catch (ConstraintViolationException ex){
//            throw new UserServiceException(ex.getMessage());
//        }
    }
}
