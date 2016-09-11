import com.marennikov.app.testproject.config.DataConfig;
import com.marennikov.app.testproject.entity.AdPlace;
import com.marennikov.app.testproject.service.IAdPlaceService;
import com.marennikov.app.testproject.service.IMunicipalityService;
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
public class AdPlaceServiceTest extends Assert{

    @Autowired
    private IAdPlaceService adPlaceService;

    @Autowired
    private IMunicipalityService municipalityService;

    @Test
    public void addAndFindAdPlaceByIdTest() throws Exception {

        checkAndAdd();

        AdPlace expectedAdPlace = adPlaceService.getById(1);

        assertNotNull(expectedAdPlace);

        assertEquals(expectedAdPlace.toString(), TestData.adPlace().toString());
    }

    @Test
    public void editAdPlaceTest() throws Exception {

        String actualAddress = "Actual Address";

        checkAndAdd();

        AdPlace actualAdPlace = adPlaceService.getById(2);
        actualAdPlace.setAddress(actualAddress);
        adPlaceService.editAdPlace(actualAdPlace);

        AdPlace expectedAdPlace = adPlaceService.getById(2);

        assertNotNull(expectedAdPlace);

        assertEquals(expectedAdPlace.toString(), actualAdPlace.toString());
    }

    @Test
    public void adPlaceListWithDeleteTest() throws Exception {

        checkAndAdd();

        List<AdPlace> expectedAdPlaceList =(List<AdPlace>) adPlaceService.adPlaceListWithDelete();

        assertNotNull(expectedAdPlaceList);

        assertEquals(expectedAdPlaceList.size(), TestData.listSizeWithDelete);
    }

    @Test
    public void adPlaceListWithOutDeleteTest() throws Exception {

        checkAndAdd();

        List<AdPlace> expectedAdPlaceList = adPlaceService.adPlaceList(null);

        assertNotNull(expectedAdPlaceList);

        assertEquals(expectedAdPlaceList.size(), TestData.listSizeWithOutDelete);
    }

    @Test
    public void setDeleteActiveStatusForAdPlaceTest() throws Exception {

        String actualActiveStatus = "Delete";

        AdPlace adPlace = adPlaceService.getById(3);
        adPlaceService.setDeleteStatus(adPlace);

        AdPlace expectedAdplace = adPlaceService.getById(3);

        assertNotNull(expectedAdplace);

        assertEquals(expectedAdplace.getActiveStatus(), actualActiveStatus);
    }

    private void checkAndAdd() {
        List<AdPlace> checkList = (List<AdPlace>) adPlaceService.adPlaceListWithDelete();
        if (checkList.size() == 0) {
            municipalityService.addMunicipality(TestData.municipality());
            adPlaceService.addAdPlace(TestData.adPlace());
            adPlaceService.addAdPlace(TestData.deleteAdPlace());
            adPlaceService.addAdPlace(TestData.willBeDeleteAdPlace());
        }
    }

}
