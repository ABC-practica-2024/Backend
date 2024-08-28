package ro.ubb.abc2024.arheo.service;

import org.springframework.stereotype.Service;
import ro.ubb.abc2024.arheo.domain.site.Site;
import ro.ubb.abc2024.arheo.domain.site.SiteStatus;

import java.util.List;


@Service
public interface SiteService {
    public List<Site> getAll();
    public List<Site> getAllByStatus(SiteStatus status);
    Site getSiteByTitle(String title);
    Site addSite(Site site);
    void deleteSite(Long id);
    public Site getSite(Long id);
}
