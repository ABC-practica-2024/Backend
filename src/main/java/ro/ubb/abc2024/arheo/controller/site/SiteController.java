package ro.ubb.abc2024.arheo.controller.site;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.arheo.domain.section.SectionStatus;
import ro.ubb.abc2024.arheo.domain.site.SiteStatus;
import ro.ubb.abc2024.arheo.utils.converter.SectionDtoConverter;
import ro.ubb.abc2024.arheo.utils.converter.SiteConverterDto;
import ro.ubb.abc2024.arheo.utils.dto.SectionDto;
import ro.ubb.abc2024.arheo.utils.dto.SiteDTO;
import ro.ubb.abc2024.arheo.domain.site.Site;
import ro.ubb.abc2024.arheo.service.SiteServiceImpl;
import ro.ubb.abc2024.utils.dto.Result;

import java.util.List;
import java.util.stream.Stream;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.endpoint.arheo}/site")
//@SecurityRequirement(name = "bearerAuth")
public class SiteController {

    private final SiteServiceImpl siteService;
    private final SiteConverterDto siteConverterDto;
    private final SectionDtoConverter sectionDtoConverter;

    @GetMapping()
    public Result<List<SiteDTO>> getSites(){
        return new Result<>(true, HttpStatus.OK.value(), "Sites returned.", siteService.getAll().stream().map(siteConverterDto::createFromEntity).toList());
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
        //Site updatedSite = siteConverterDto.createFromDto(siteDTO);
        siteService.updateSite(siteDTO.id(), siteDTO);
        return new Result<>(true, HttpStatus.OK.value(), "Site updated successfully.", siteDTO);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAnyAuthority('SCOPE_ARH', 'SCOPE_ADMIN')")
    public Result<Boolean> deleteSite(@PathVariable Long id){
        siteService.deleteSite(id);
        return new Result<>(true, HttpStatus.OK.value(), "Site deleted successfully.", Boolean.TRUE);
    }

    @GetMapping("/digging")
    @PreAuthorize("hasAnyAuthority('SCOPE_ARH', 'SCOPE_ADMIN')")
    public Result<List<SiteDTO>> getDiggingSites(){
        return new Result<>(true, HttpStatus.OK.value(), "Returned digging sites.", siteService.getAllByStatus(SiteStatus.DIGGING).stream().map(siteConverterDto::createFromEntity).toList());
    }

    @GetMapping("/analysis")
    @PreAuthorize("hasAnyAuthority('SCOPE_ARH', 'SCOPE_ADMIN')")
    public Result<List<SiteDTO>> getAnalyzedSites(){
        return new Result<>(true, HttpStatus.OK.value(), "Returned analyzed sites.", siteService.getAllByStatus(SiteStatus.ANALYSIS).stream().map(siteConverterDto::createFromEntity).toList());
    }

    @GetMapping("/completed")
    @PreAuthorize("hasAnyAuthority('SCOPE_ARH', 'SCOPE_ADMIN')")
    public Result<List<SiteDTO>> getCompletedSites(){
        return new Result<>(true, HttpStatus.OK.value(), "Returned completed sites.", siteService.getAllByStatus(SiteStatus.COMPLETED).stream().map(siteConverterDto::createFromEntity).toList());
    }

    @GetMapping("/incomplete")
    @PreAuthorize("hasAnyAuthority('SCOPE_ARH', 'SCOPE_ADMIN')")
    public Result<List<SiteDTO>> getIncompleteSites(){
        return new Result<>(true,
                HttpStatus.OK.value(),
                "Returned incomplete sites.",
                Stream.concat(
                        siteService.getAllByStatus(SiteStatus.DIGGING).stream().map(siteConverterDto::createFromEntity),
                        siteService.getAllByStatus(SiteStatus.ANALYSIS).stream().map(siteConverterDto::createFromEntity))
                        .toList()
        );
    }

    @GetMapping("/sections/{id}")
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
    }

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
