package ro.ubb.abc2024;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ro.ubb.abc2024.arheo.domain.site.CreateArchaeologicalSiteRequest;
import ro.ubb.abc2024.arheo.domain.auxiliary.GeographicPoint;
import ro.ubb.abc2024.arheo.domain.site.Site;
import ro.ubb.abc2024.arheo.domain.site.SiteStatus;
import ro.ubb.abc2024.arheo.repository.SiteRepository;
import ro.ubb.abc2024.arheo.repository.SiteRequestRepository;
import ro.ubb.abc2024.arheo.service.SiteService;
import ro.ubb.abc2024.user.Role;
import ro.ubb.abc2024.user.User;
import ro.ubb.abc2024.user.UserRepository;
import ro.ubb.abc2024.user.userRoleRequest.RequestStatus;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RequestNewArcheologicalSiteTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SiteRequestRepository siteRequestRepository;

    @Autowired
    private SiteService siteService;

    @Autowired
    private SiteRepository siteRepository;

    private User userAdmin;
    private User userArheo;

    @BeforeEach
    void setUp() {
        // Set up admin user
        userAdmin = new User();
        userAdmin.setUsername("admin");
        userAdmin.setPassword("Adminpassword1!");
        userAdmin.setEmail("admin@gmail.com");
        userAdmin.setFirstName("firstName");
        userAdmin.setLastName("lastName");
        userAdmin.setRole(Role.ADMIN);
        userAdmin.setEnabled(true);
        userRepository.save(userAdmin);

        // Set up archaeologist user
        userArheo = new User();
        userArheo.setUsername("arheo");
        userArheo.setPassword("Arheopassword1!");
        userArheo.setEmail("arheo@gmail.com");
        userArheo.setFirstName("firstName");
        userArheo.setLastName("lastName");
        userArheo.setRole(Role.ARH);
        userArheo.setEnabled(true);
        userRepository.save(userArheo);

        //System.out.println(userRepository.findAll());
    }

    @Test
    void testRequestCreateArcheologicalSite() {

        CreateArchaeologicalSiteRequest request = new CreateArchaeologicalSiteRequest();
        request.setTitle("Test Site");
        request.setDescription("A description for the test site.");
        request.setCenterCoordinates(new GeographicPoint(10.0, 20.0)); // Ensure this matches your constructor
        request.setPerimeterCoordinates(Collections.emptyList());
        request.setStatus(RequestStatus.PENDING);
        request.setCreateRequestTime(LocalDateTime.now());
        request.setArcheologist(userArheo);


        CreateArchaeologicalSiteRequest result = siteService.requestCreateArchaeologicalSite(request);


        assertNotNull(result, "The result should not be null");
        assertEquals(request.getTitle(), result.getTitle(), "The title should match");
        assertEquals(request.getDescription(), result.getDescription(), "The description should match");
        assertEquals(RequestStatus.PENDING, result.getStatus(), "The status should be PENDING");
        assertNotNull(result.getId(), "The ID should be generated");
    }

    @Test
    void testGetCreateArchaeologicalSiteRequestById() {

        CreateArchaeologicalSiteRequest request = new CreateArchaeologicalSiteRequest();
        request.setTitle("Test Site");
        request.setDescription("A description for the test site.");
        request.setCenterCoordinates(new GeographicPoint(10.0, 20.0));
        request.setPerimeterCoordinates(Collections.emptyList());
        request.setStatus(RequestStatus.PENDING);
        request.setCreateRequestTime(LocalDateTime.now());
        request.setArcheologist(userArheo);

        CreateArchaeologicalSiteRequest savedRequest = siteService.requestCreateArchaeologicalSite(request);


        CreateArchaeologicalSiteRequest result = siteService.getCreateArchaeologicalSiteRequest(savedRequest.getId());


        assertNotNull(result, "The result should not be null");
        assertEquals(savedRequest.getId(), result.getId(), "The IDs should match");
    }


    @Test
    void testDeleteCreateArchaeologicalSiteRequest() {
        // Arrange
        CreateArchaeologicalSiteRequest request = new CreateArchaeologicalSiteRequest();
        request.setTitle("Test Site");
        request.setDescription("A description for the test site.");
        request.setCenterCoordinates(new GeographicPoint(10.0, 20.0));
        request.setPerimeterCoordinates(Collections.emptyList());
        request.setStatus(RequestStatus.PENDING);
        request.setCreateRequestTime(LocalDateTime.now());
        request.setArcheologist(userArheo);

        CreateArchaeologicalSiteRequest savedRequest = siteService.requestCreateArchaeologicalSite(request);

        // Act
        siteService.deleteCreateArchaeologicalSiteRequest(savedRequest.getId());
        CreateArchaeologicalSiteRequest result = siteRequestRepository.findById(savedRequest.getId()).orElse(null);

        // Assert
        assertNull(result, "The result should be null after deletion");
    }

    @Test
    void testGetAllSiteRequests() {
        // Arrange
        CreateArchaeologicalSiteRequest request1 = new CreateArchaeologicalSiteRequest();
        request1.setTitle("Site 1");
        request1.setDescription("Description 1");
        request1.setCenterCoordinates(new GeographicPoint(10.0, 20.0));
        request1.setPerimeterCoordinates(Collections.emptyList());
        request1.setStatus(RequestStatus.PENDING);
        request1.setCreateRequestTime(LocalDateTime.now());
        request1.setArcheologist(userArheo);

        CreateArchaeologicalSiteRequest request2 = new CreateArchaeologicalSiteRequest();
        request2.setTitle("Site 2");
        request2.setDescription("Description 2");
        request2.setCenterCoordinates(new GeographicPoint(15.0, 25.0));
        request2.setPerimeterCoordinates(Collections.emptyList());
        request2.setStatus(RequestStatus.PENDING);
        request2.setCreateRequestTime(LocalDateTime.now());
        request2.setArcheologist(userArheo);

        siteService.requestCreateArchaeologicalSite(request1);
        siteService.requestCreateArchaeologicalSite(request2);

        // Act
        List<CreateArchaeologicalSiteRequest> requests = siteService.getAllSiteRequests();

        // Assert
        assertEquals(2, requests.size(), "There should be 2 requests");
    }

    @Test
    void testGetPendingSiteRequests() {
        // Arrange
        CreateArchaeologicalSiteRequest request1 = new CreateArchaeologicalSiteRequest();
        request1.setTitle("Pending Site");
        request1.setDescription("Pending Description");
        request1.setCenterCoordinates(new GeographicPoint(10.0, 20.0));
        request1.setPerimeterCoordinates(Collections.emptyList());
        request1.setStatus(RequestStatus.PENDING);
        request1.setCreateRequestTime(LocalDateTime.now());
        request1.setArcheologist(userArheo);

        CreateArchaeologicalSiteRequest request2 = new CreateArchaeologicalSiteRequest();
        request2.setTitle("Accepted Site");
        request2.setDescription("Accepted Description");
        request2.setCenterCoordinates(new GeographicPoint(15.0, 25.0));
        request2.setPerimeterCoordinates(Collections.emptyList());
        request2.setStatus(RequestStatus.ACCEPTED);
        request2.setCreateRequestTime(LocalDateTime.now());
        request2.setArcheologist(userArheo);

        siteService.requestCreateArchaeologicalSite(request1);
        siteService.requestCreateArchaeologicalSite(request2);

        // Act
        List<CreateArchaeologicalSiteRequest> pendingRequests = siteService.getPendingSiteRequests();

        // Assert
        assertEquals(1, pendingRequests.size(), "There should be 1 pending request");
        assertEquals(request1.getTitle(), pendingRequests.get(0).getTitle(), "The pending request title should match");
    }

    @Test
    void testSolveCreateSiteRequest() {
        // Arrange
        CreateArchaeologicalSiteRequest request = new CreateArchaeologicalSiteRequest();
        request.setTitle("Test Site to Solve");
        request.setDescription("Description for the test site to solve");
        request.setCenterCoordinates(new GeographicPoint(10.0, 20.0));
        request.setPerimeterCoordinates(Collections.emptyList());
        request.setStatus(RequestStatus.PENDING);
        request.setCreateRequestTime(LocalDateTime.now());
        request.setArcheologist(userArheo);

        CreateArchaeologicalSiteRequest savedRequest = siteService.requestCreateArchaeologicalSite(request);

        // Act
        CreateArchaeologicalSiteRequest solvedRequest = siteService.solveCreateSiteRequest(savedRequest.getId());

        // Assert
        assertEquals(RequestStatus.ACCEPTED, solvedRequest.getStatus(), "The request status should be ACCEPTED");
        assertNotNull(solvedRequest.getSolveRequestTime(), "The solveRequestTime should be set");

        // Verify that a Site was created
        List<Site> sites = siteRepository.findAll(); // Fetch all sites from the repository
        assertFalse(sites.isEmpty(), "There should be at least one site");

        // Find the site that was created by matching its title or other unique identifier
        Site createdSite = sites.stream()
                .filter(site -> site.getTitle().equals(request.getTitle()))
                .findFirst()
                .orElse(null);

        assertNotNull(createdSite, "The created site should not be null");
        assertEquals(request.getTitle(), createdSite.getTitle(), "The site title should match");
        assertEquals(request.getDescription(), createdSite.getDescription(), "The site description should match");
        assertNotNull(createdSite.getPerimeterCoordinates(), "The perimeterCoordinates should not be null");
        assertEquals(SiteStatus.DIGGING, createdSite.getStatus(), "The site status should be DIGGING");
        assertEquals(userArheo, createdSite.getMainArchaeologist(), "The main archaeologist should match");
    }


    @AfterEach
    void tearDown() {
        // Remove all sites before deleting users
        siteRepository.deleteAll();

        // Then remove all site requests
        siteRequestRepository.deleteAll();

        // Finally remove all users
        userRepository.deleteAll();
    }
}
