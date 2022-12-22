package registerStrategy;

import user.User;

public interface RegisterStrategy {

    void register(User user);
    void save(User user);
}

