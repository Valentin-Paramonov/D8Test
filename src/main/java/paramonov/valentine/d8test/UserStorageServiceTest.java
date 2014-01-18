package paramonov.valentine.d8test;

import org.junit.Before;
import org.junit.Test;
import paramonov.valentine.d8test.bean.User;
import paramonov.valentine.d8test.service.UserStorageService;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserStorageServiceTest {
    private UserStorageService userStorage;

    @Before
    public void setUp() throws Exception {
        userStorage = new UserStorageService();
        userStorage.add(new User());
        userStorage.add(new User());
        userStorage.add(new User());
    }

    @Test
    public void testGetId_Increments() {
        List<User> users = userStorage.getValues();

        long user1Id = users.get(0).getId();
        long user2Id = users.get(1).getId();

        assertThat(user1Id, not(equalTo(user2Id)));
    }
}
