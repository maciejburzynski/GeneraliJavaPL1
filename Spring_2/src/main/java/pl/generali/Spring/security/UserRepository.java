package pl.generali.Spring.security;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final IUserRepository iUserRepository;

    public void save(User user) {
        iUserRepository.save(user);
    }
}
