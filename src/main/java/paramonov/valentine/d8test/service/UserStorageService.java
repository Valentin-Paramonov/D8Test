package paramonov.valentine.d8test.service;

import paramonov.valentine.d8test.beans.User;

import java.util.*;

public class UserStorageService implements StorageService<User> {
    private long id = 0;
    private Map<Long, User> users = new HashMap<Long, User>(0);

    public Map<Long, User> getUsers() {
        return users;
    }

    public void setUsers(Map<Long, User> users) {
        this.users = users;
    }

    @Override
    public boolean add(User user) {
        user.setId(id);
        users.put(id, user);
        id++;
        return true;
    }

    @Override
    public boolean delete(long id) {
        User user = users.remove(id);

        return user != null;
    }

    @Override
    public boolean update(User user) {
        long id = user.getId();

        if(!users.containsKey(id)) {
            return false;
        }

        users.put(id, user);

        return true;
    }

    @Override
    public List<User> getValues() {
        return new ArrayList(users.values());
    }

    @Override
    public User get(long id) {
        return users.get(id);
    }
}
