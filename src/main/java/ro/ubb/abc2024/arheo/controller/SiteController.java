package ro.ubb.abc2024.arheo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.abc2024.arheo.service.SiteServiceImpl;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.endpoint.base-url}/sites")
//@SecurityRequirement(name = "bearerAuth")
public class SiteController {
    private final SiteServiceImpl siteService;

    //@GetMapping()
    //public Result<List<Site>> getSites(){
    //}


}
