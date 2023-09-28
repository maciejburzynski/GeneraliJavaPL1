package pl.generali.Spring.security;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final IUserRepository iUserRepository;

    public void save(User user) {
        iUserRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return iUserRepository.findByUsername(username);
    }
}
