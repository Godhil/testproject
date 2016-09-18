import com.marennikov.app.testproject.config.DataConfig;
import com.marennikov.app.testproject.entity.AdConstruction;
import com.marennikov.app.testproject.service.IAdConstructionService;
import com.marennikov.app.testproject.service.IAdPlaceService;
import com.marennikov.app.testproject.service.IMunicipalityService;
import data.TestData;
import org.junit.After;
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
public class AdConstructionServiceTest extends Assert {

    private IAdConstructionService adConstructionService;

    private IMunicipalityService municipalityService;

    private IAdPlaceService adPlaceService;

    @Autowired
    public void setAdConstructionService(IAdConstructionService adConstructionService) {
        this.adConstructionService = adConstructionService;
    }

    @Autowired
    public void setMunicipalityService(IMunicipalityService municipalityService) {
        this.municipalityService = municipalityService;
    }

    @Autowired
    public void setAdPlaceService(IAdPlaceService adPlaceService) {
        this.adPlaceService = adPlaceService;
    }

    @Test
    public void addAndFindAdConstructionByIdTest() throws Exception {

        checkAndAdd();

        AdConstruction expectedAdConstruction = adConstructionService.getById(1);

        assertNotNull(expectedAdConstruction);

        assertEquals(expectedAdConstruction.toString(), TestData.adConstruction().toString());
    }

    @Test
    public void editAdConstructionTest() throws Exception {

        String actualOwner = "Actual Owner";

        checkAndAdd();

        AdConstruction actualAdConstruction = adConstructionService.getById(2);
        actualAdConstruction.setOwner(actualOwner);
        adConstructionService.saveAdConstruction(actualAdConstruction);

        AdConstruction expectedAdConstruction = adConstructionService.getById(2);

        assertNotNull(expectedAdConstruction);

        assertEquals(expectedAdConstruction.toString(), actualAdConstruction.toString());
    }

    @Test
    public void getAdConstructionWithDeleteTest() throws Exception {

        checkAndAdd();

        List<AdConstruction> expectedAdConstructionList =
                (List<AdConstruction>) adConstructionService.adConstructionListWithDelete();

        assertNotNull(expectedAdConstructionList);

        assertEquals(expectedAdConstructionList.size(), TestData.listSizeWithDelete);
    }

    @Test
    public void adConstructionListWithOutDeleteTest() throws Exception {

        checkAndAdd();

        List<AdConstruction> expectedAdConstructionList =
                adConstructionService.adConstructionList(null);

        assertNotNull(expectedAdConstructionList);

        assertEquals(expectedAdConstructionList.size(), TestData.listSizeWithOutDelete);
    }

    @After
    @Test
    public void setDeleteActiveStatusForAdConstructionTest() throws Exception {

        String actualActiveStatus = "Delete";

        checkAndAdd();

        AdConstruction adConstruction = adConstructionService.getById(3);

        assertNotNull(adConstruction);
        adConstructionService.setDeleteStatus(adConstruction);

        AdConstruction expectedAdConstruction = adConstructionService.getById(3);

        assertNotNull(expectedAdConstruction);

        assertEquals(expectedAdConstruction.getActiveStatus(), actualActiveStatus);
    }

    private void checkAndAdd() {
        List<AdConstruction> checkList =
                (List<AdConstruction>) adConstructionService.adConstructionListWithDelete();
        if (checkList.size() == 0) {
            municipalityService.saveMunicipality(TestData.municipality());
            adPlaceService.saveAdPlace(TestData.adPlace());
            adConstructionService.saveAdConstruction(TestData.adConstruction());
            adConstructionService.saveAdConstruction(TestData.deleteAdConstruction());
            adConstructionService.saveAdConstruction(TestData.willBeDeleteAdConstruction());
        }
    }
}
