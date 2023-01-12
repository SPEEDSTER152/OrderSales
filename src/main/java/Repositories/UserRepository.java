package Repositories;

import entities.User;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepositoriesAutoConfiguration<UserRepository, Integer> {
    static User save(User user) {
        return user;
    }

    static List<User> findAll() {
        return findAll();
    }

    static Optional<Object> findById(Integer iduser) {
        return findById(iduser);
    }

    static boolean existsByid(Integer idUser) {
        return existsByid(idUser);
    }

    static void delete(User user) {
    }
}
