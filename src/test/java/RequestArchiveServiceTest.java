import com.marennikov.app.testproject.config.DataConfig;
import com.marennikov.app.testproject.entity.RequestArchive;
import com.marennikov.app.testproject.service.*;
import data.TestData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
@WebAppConfiguration
public class RequestArchiveServiceTest extends Assert {


    @Autowired
    private IUserService userService;

    @Autowired
    private IMunicipalityService municipalityService;

    @Autowired
    private IAdPlaceService adPlaceService;

    @Autowired
    private IAdConstructionService adConstructionService;

    @Autowired
    private IRequestService requestService;

    @Autowired IRequestsArchiveService requestsArchiveService;

    @Test
    public void addAndFindRequestArchiveByIdTest() throws Exception {

        checkAndAdd();

        RequestArchive expectedRequestArchive = requestsArchiveService.getById(1);

        assertNotNull(expectedRequestArchive);

        assertEquals(expectedRequestArchive.toString(), TestData.requestArchive().toString());
    }

    @Test
    public void editRequestArchiveTest() throws Exception {

        int actualVesion = 55;

        checkAndAdd();

        RequestArchive actualRequestAchive = requestsArchiveService.getById(2);
        actualRequestAchive.setVersion(actualVesion);
        requestsArchiveService.saveRequestArchive(actualRequestAchive);

        RequestArchive expectedRequestAchive = requestsArchiveService.getById(2);

        assertNotNull(expectedRequestAchive);

        assertEquals(expectedRequestAchive.toString(), actualRequestAchive.toString());
    }

    @Test
    public void requestArchiveListWithDelete() throws Exception {

        checkAndAdd();

        List<RequestArchive> expectedList =
                (List<RequestArchive>) requestsArchiveService.requestsArchiveListWithDelete();

        assertNotNull(expectedList);

        assertEquals(expectedList.size(), TestData.listSizeWithDelete);

    }

    @Test
    public void requestArchiveListWithOutDelete() throws Exception {

        checkAndAdd();

        List<RequestArchive> expectedList = requestsArchiveService.requestArchiveList(null);

        assertNotNull(expectedList);

        assertEquals(expectedList.size(), TestData.listSizeWithOutDelete);

    }

    @Test
    public void setDeleteStatusForRequestArchiveTest() throws Exception {

        String actualActiveStatus = "Delete";

        checkAndAdd();

        RequestArchive requestArchive = requestsArchiveService.getById(3);
        requestsArchiveService.setDeleteStatus(requestArchive);

        RequestArchive expectedRequestArchive = requestsArchiveService.getById(3);

        assertNotNull(expectedRequestArchive);

        assertEquals(expectedRequestArchive.getActiveStatus(), actualActiveStatus);
    }

    private void checkAndAdd() {
        List<RequestArchive> checkList =
                (List<RequestArchive>) requestsArchiveService.requestsArchiveListWithDelete();
        if(checkList.size() == 0) {
            municipalityService.saveMunicipality(TestData.municipality());
            userService.saveUser(TestData.user());
            adPlaceService.saveAdPlace(TestData.adPlace());
            adConstructionService.saveAdConstruction(TestData.adConstruction());
            requestService.saveRequest(TestData.request());
            requestsArchiveService.saveRequestArchive(TestData.requestArchive());
            requestsArchiveService.saveRequestArchive(TestData.deleteRequestArchive());
            requestsArchiveService.saveRequestArchive(TestData.willBeDeleteRequestArchive());
        }
    }
}
