import com.marennikov.app.testproject.config.DataConfig;
import com.marennikov.app.testproject.entity.User;
import com.marennikov.app.testproject.service.IMunicipalityService;
import com.marennikov.app.testproject.service.IUserService;
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
public class UserServiceTest extends Assert {

    @Autowired
    private IUserService userService;

    @Autowired
    private IMunicipalityService municipalityService;

    @Test
    public void addAndFindUserByIdTest() throws Exception {

        checkAndAdd();

        User expectedUser = userService.getById(1);

        assertNotNull(expectedUser);
        assertEquals(expectedUser.toString(), TestData.user().toString());
    }


    @Test
    public void findUserListWithDelete() throws Exception {

        checkAndAdd();

        List<User> expectedList = (List<User>) userService.usersListWithDelete();

        assertNotNull(expectedList);
        assertEquals(expectedList.size(), TestData.listSizeWithDelete);
    }


    @Test
    public void findUserListWithOutDelete() throws Exception {

        checkAndAdd();

        List<User> expectedList = userService.userList(null);


        assertNotNull(expectedList);
        assertEquals(expectedList.size(), TestData.listSizeWithOutDelete);
    }

    @Test
    public void editUserTest() throws Exception {

        String actualName = "Actual Name";

        checkAndAdd();

        User actualUser = userService.getById(2);
        actualUser.setFirstName(actualName);
        userService.editUser(actualUser);

        User expectedUser = userService.getById(2);

        assertNotNull(expectedUser);
        assertEquals(expectedUser.toString(), actualUser.toString());
    }

    @Test
    public void deleteUserTest() throws Exception {

        checkAndAdd();

        String actualActiveStatus = "Delete";

        User actualUser = userService.getById(3);
        userService.setDeleteStatus(actualUser);

        User expectedUser = userService.getById(3);

        assertNotNull(expectedUser);

        assertEquals(expectedUser.getActiveStatus(), actualActiveStatus);
    }

    private void checkAndAdd() {

        List<User> checkList = (List<User>) userService.usersListWithDelete();
        if (checkList.size() == 0) {
            municipalityService.addMunicipality(TestData.municipality());
            userService.addUser(TestData.user());
            userService.addUser(TestData.deleteUser());
            userService.addUser(TestData.willBeDeleteUser());
        }
    }
}
