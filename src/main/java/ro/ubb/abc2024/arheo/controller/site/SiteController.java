package ro.ubb.abc2024.arheo.controller.site;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.arheo.domain.section.Section;
import ro.ubb.abc2024.arheo.domain.section.SectionStatus;
import ro.ubb.abc2024.arheo.utils.converter.SectionDtoConverter;
import ro.ubb.abc2024.arheo.utils.converter.SiteConverterDto;
import ro.ubb.abc2024.arheo.utils.dto.SectionDto;
import ro.ubb.abc2024.arheo.utils.dto.SiteDTO;
import ro.ubb.abc2024.arheo.domain.site.Site;
import ro.ubb.abc2024.arheo.service.SiteServiceImpl;
import ro.ubb.abc2024.utils.dto.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.endpoint.arheo}/site")
//@SecurityRequirement(name = "bearerAuth")
public class SiteController {

    private final SiteServiceImpl siteService;
    private final SiteConverterDto siteConverterDto;
    private final SectionDtoConverter sectionDtoConverter;

    @GetMapping
    public Result<Map<String,Object>> getSites(@RequestParam(required = false) String status,
                                                   @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "10") int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Site> sitePage = siteService.getAllPaginatedByCriteria(status, pageable);
        List<SiteDTO> siteDtoList = sitePage.getContent().stream().map(siteConverterDto::createFromEntity)
                .collect(Collectors.toList());
        Map<String, Object> response = new HashMap<>();
        response.put("sites", siteDtoList);
        response.put("currentPage", sitePage.getNumber());
        response.put("totalItems", sitePage.getTotalElements());
        response.put("totalPages", sitePage.getTotalPages());
        return new Result<>(true, HttpStatus.OK.value(), "Retrieved all sites", response);
    }

    @GetMapping("{id}")
    public Result<SiteDTO> getSiteById(@PathVariable Long id){
        return new Result<>(true, HttpStatus.OK.value(), "Sites returned.", siteConverterDto.createFromEntity(siteService.getSite(id)));
    }

    @PostMapping()
    @PreAuthorize("hasAnyAuthority('SCOPE_ARH', 'SCOPE_ADMIN')")
    public Result<SiteDTO> createSite(@RequestBody SiteDTO siteDTO){
        Site newSite=siteConverterDto.createFromDto(siteDTO);
        siteService.addSite(newSite);
        return new Result<>(true, HttpStatus.OK.value(), "Site added successfully.", siteDTO);
    }

    @PutMapping()
    @PreAuthorize("hasAnyAuthority('SCOPE_ARH', 'SCOPE_ADMIN')")
    public Result<SiteDTO> updateSite(@RequestBody SiteDTO siteDTO){
        siteService.updateSite(siteDTO.id(), siteDTO);
        return new Result<>(true, HttpStatus.OK.value(), "Site updated successfully.", siteDTO);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAnyAuthority('SCOPE_ARH', 'SCOPE_ADMIN')")
    public Result<Boolean> deleteSite(@PathVariable Long id){
        siteService.deleteSite(id);
        return new Result<>(true, HttpStatus.OK.value(), "Site deleted successfully.", Boolean.TRUE);
    }

    @GetMapping("/sections")
    @PreAuthorize("hasAnyAuthority('SCOPE_ARH', 'SCOPE_ADMIN')")
    public Result<Map<String, Object>> getSectionsBySite(@RequestParam Long siteId,
                                                         @RequestParam(required = false) String sectionStatus,
                                                         @RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "10") int pageSize){
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Section> sectionPage = siteService.getPaginatedSectionsByCriteria(siteId, sectionStatus, pageable);
        List<SectionDto> siteDtoList = sectionPage.getContent().stream().map(sectionDtoConverter::createFromEntity)
                .collect(Collectors.toList());
        Map<String, Object> response = new HashMap<>();
        response.put("sites", siteDtoList);
        response.put("currentPage", sectionPage.getNumber());
        response.put("totalItems", sectionPage.getTotalElements());
        response.put("totalPages", sectionPage.getTotalPages());
        return new Result<>(true, HttpStatus.OK.value(), "Retrieved all sections", response);
    }

    /*@GetMapping("/sections/{id}")
    @PreAuthorize("hasAnyAuthority('SCOPE_ARH', 'SCOPE_ADMIN')")
    public Result<List<SectionDto>> getSectionsById(@PathVariable long id){
        return new Result<>(true, HttpStatus.OK.value(), "Returned all sections.", siteService.getSectionsBySiteId(id).stream().map(sectionDtoConverter::createFromEntity).toList());
    }

    @GetMapping("sections_incomplete/{id}")
    @PreAuthorize("hasAnyAuthority('SCOPE_ARH', 'SCOPE_ADMIN')")
    public Result<List<SectionDto>> getIncompleteSectionsBySiteId(@PathVariable long id){
        return new Result<>(true,
                HttpStatus.OK.value(),
                "Returned incomplete sections.",
                Stream.concat(
                        siteService.getSectionsBySiteIdAndStatus(id, SectionStatus.DIGGING).stream().map(sectionDtoConverter::createFromEntity),
                        siteService.getSectionsBySiteIdAndStatus(id, SectionStatus.ANALYSIS).stream().map(sectionDtoConverter::createFromEntity))
                        .toList()
        );
    }*/

    //todo: complete endpoint when done artifacts
    /*@GetMapping("artifacts/{id}")
    public Result<List<ArtifactDto>> getArtifactsBySiteId(@PathVariable long id){

    }*/

    //todo: complete endpoint when done artifacts
    /*@GetMapping("artifacts")
    public Result<List<SectionDto>> getArtifactsBySiteIdAndArchaeologist(@RequestBody Long siteId,
                                                                         @RequestBody Long archaeologistId){

    }*/
}
