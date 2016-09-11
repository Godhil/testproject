import com.marennikov.app.testproject.config.DataConfig;
import com.marennikov.app.testproject.entity.Municipality;
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
public class MunicipalityServiceTest extends Assert{

    @Autowired
    private IMunicipalityService municipalityService;

    @Test
    public void addAndFindMunicipalityById() throws Exception {

        checkAndAdd();

        Municipality expectedMunicipality = municipalityService.getById(1);

        assertNotNull(expectedMunicipality);
        assertEquals(expectedMunicipality.toString(), TestData.municipality().toString());
    }


    @Test
    public void findMunicipalityWithOutDelete() throws Exception {

        checkAndAdd();

        List<Municipality> expectedlist =  municipalityService.municipalityList(null);

        assertNotNull(expectedlist);
        assertEquals(expectedlist.size(), TestData.listSizeWithOutDelete);
    }


    @Test
    public void findMunicipalityWithDelete() throws Exception {

        checkAndAdd();

        List<Municipality> expectedList =
                (List<Municipality>) municipalityService.municipalityListWithDelete();

        assertNotNull(expectedList);

        assertEquals(expectedList.size(), TestData.listSizeWithDelete);
    }

    @Test
    public void editMunicipalityTest() throws Exception {

        String actualName = "Actual Name";

        checkAndAdd();

        Municipality actualMunicipality = municipalityService.getById(2);
        actualMunicipality.setName(actualName);
        municipalityService.editMunicipality(actualMunicipality);

        Municipality expectedMunicipality = municipalityService.getById(2);

        assertNotNull(expectedMunicipality);

        assertEquals(expectedMunicipality.toString(), actualMunicipality.toString());
    }

    @Test
    public void setDeleteActiveStatusForMunicipality() {

        String actualActiveStatus = "Delete";

        checkAndAdd();

        Municipality municipality = municipalityService.getById(3);
        municipalityService.setDeleteStatus(municipality);

        Municipality expectedMunicipality = municipalityService.getById(3);

        assertNotNull(expectedMunicipality);

        assertEquals(expectedMunicipality.getActiveStatus(), actualActiveStatus);
    }

    private void checkAndAdd() {
        List<Municipality> checkList = (List<Municipality>) municipalityService.municipalityListWithDelete();
        if (checkList.size() == 0) {
            municipalityService.addMunicipality(TestData.municipality());
            municipalityService.addMunicipality(TestData.deleteMunicipality());
            municipalityService.addMunicipality(TestData.willBeDeleteMunicipality());
        }
    }
}
