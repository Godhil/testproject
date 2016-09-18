import com.marennikov.app.testproject.config.DataConfig;
import com.marennikov.app.testproject.entity.Photo;
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
public class PhotoServiceTest extends Assert {

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

    @Autowired
    private IPhotoService photoService;

    @Test
    public void addAndFindPhotoByIdTest() throws Exception {

        checkAndAdd();

        Photo expectedPhoto = photoService.getById(1);

        assertNotNull(expectedPhoto);

        assertEquals(expectedPhoto.toString(), TestData.photo().toString());
    }

    @Test
    public void editPhotoTest() throws Exception {

        String actualPath = "Actual Path";

        checkAndAdd();

        Photo actualPhoto = photoService.getById(2);
        actualPhoto.setPath(actualPath);
        photoService.savePhoto(actualPhoto);

        Photo expectedPhoto = photoService.getById(2);

        assertNotNull(expectedPhoto);

        assertEquals(expectedPhoto.toString(), actualPhoto.toString());
    }

    @Test
    public void photoListWithDelete() throws Exception {

        checkAndAdd();

        List<Photo> expectedList = (List<Photo>) photoService.photoListWithDelete();

        assertNotNull(expectedList);

        assertEquals(expectedList.size(), TestData.listSizeWithDelete);
    }

    @Test
    public void photoListWithOutDelete() throws Exception {

        checkAndAdd();

        List<Photo> expectedList = photoService.photoList(null);

        assertNotNull(expectedList);

        assertEquals(expectedList.size(), TestData.listSizeWithOutDelete);
    }

    @Test
    public void setDeleteActiveStatusForPhoto() {

        String actualActiveStatus = "Delete";

        checkAndAdd();

        Photo photo = photoService.getById(3);
        photoService.setDeleteStatus(photo);

        Photo expectedPhoto = photoService.getById(3);

        assertNotNull(expectedPhoto);

        assertEquals(expectedPhoto.getActiveStatus(), actualActiveStatus);
    }

    private void checkAndAdd() {
        List<Photo> checkList =(List<Photo>) photoService.photoListWithDelete();
        if(checkList.size() == 0) {
            municipalityService.saveMunicipality(TestData.municipality());
            userService.saveUser(TestData.user());
            adPlaceService.saveAdPlace(TestData.adPlace());
            adConstructionService.saveAdConstruction(TestData.adConstruction());
            requestService.saveRequest(TestData.request());
            photoService.savePhoto(TestData.photo());
            photoService.savePhoto(TestData.deletePhoto());
            photoService.savePhoto(TestData.willBeDeletePhoto());
        }
    }
}
