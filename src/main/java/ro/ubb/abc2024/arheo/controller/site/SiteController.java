package ro.ubb.abc2024.arheo.controller.site;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.ubb.abc2024.arheo.utils.converter.SiteConverterDto;
import ro.ubb.abc2024.arheo.utils.dto.SiteDTO;
import ro.ubb.abc2024.arheo.domain.site.Site;
import ro.ubb.abc2024.arheo.service.SiteService;
import ro.ubb.abc2024.utils.dto.Result;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.endpoint.arheo}/sites")
//@SecurityRequirement(name = "bearerAuth")
public class SiteController {

    private final SiteService siteService;
    private final SiteConverterDto siteConverterDto;

    @GetMapping()
    public Result<List<Site>> getSites(){
        return new Result<>(true, HttpStatus.OK.value(), "Details about user served.", siteService.getAll());
    }

    @PostMapping()
    public Result<SiteDTO> createSite(@RequestBody SiteDTO siteDTO){
        Site newSite=siteConverterDto.createFromDto(siteDTO);
        siteService.addSite(newSite);
        return new Result<>(true, HttpStatus.OK.value(), "User updated successfully.", siteDTO);
    }

   // @PutMapping()
   // public Result<Site> updateSite(@RequestBody Site site){
   //
   // }
}
