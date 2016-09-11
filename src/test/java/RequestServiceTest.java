import com.marennikov.app.testproject.config.DataConfig;
import com.marennikov.app.testproject.entity.*;
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
public class RequestServiceTest extends Assert {

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

    @Test
    public void addAndFindRequestByIdTest() throws Exception {

        checkAndAdd();

        Request expectedRequest = requestService.getById(1);

        assertNotNull(expectedRequest);

        assertEquals(expectedRequest.toString(), TestData.request().toString());
    }

    @Test
    public void findRequestListWithDelete() throws Exception {

        checkAndAdd();

        List<Request> expectedList = (List<Request>) requestService.requestsListWithDelete();


        assertNotNull(expectedList);
        assertEquals(expectedList.size(), TestData.listSizeWithDelete);
    }


    @Test
    public void findRequestListWithOutDelete() throws Exception {

        checkAndAdd();

        List<Request> expectedList = requestService.requestList(null);

        assertNotNull(expectedList);
        assertEquals(expectedList.size(), TestData.listSizeWithOutDelete);
    }

    @Test
    public void editRequestTest() throws Exception {

        String actualStatus = "Actual Status";

        checkAndAdd();

        Request actualRequest = requestService.getById(2);
        actualRequest.setActiveStatus(actualStatus);
        requestService.editRequest(actualRequest);

        Request expectedRequest = requestService.getById(2);

        assertNotNull(expectedRequest);
        assertEquals(expectedRequest.toString(), actualRequest.toString());
    }

    @Test
    public void setDeleteForRequestTest() throws Exception {

        String actualActiveStatus = "Delete";

        checkAndAdd();

        Request request = requestService.getById(3);
        requestService.setDeleteStatus(request);

        Request expectedRequest = requestService.getById(3);

        assertNotNull(expectedRequest);

        assertEquals(expectedRequest.getActiveStatus(), actualActiveStatus);
    }

    private void checkAndAdd() {

        List<Request> checkList =(List<Request>) requestService.requestsListWithDelete();
        if(checkList.size() == 0) {
            municipalityService.addMunicipality(TestData.municipality());
            userService.addUser(TestData.user());
            adPlaceService.addAdPlace(TestData.adPlace());
            adConstructionService.addAdConstruction(TestData.adConstruction());
            requestService.addRequest(TestData.request());
            requestService.addRequest(TestData.deleteRequest());
            requestService.addRequest(TestData.willBeDeleteRequest());
        }
    }

}
