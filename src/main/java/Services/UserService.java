package Services;

import Repositories.UserRepository;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {

    @Autowired
    UserService userService;

    public static User save(User user) {
        UserRepository.save(user);
        return user;
    }

    public static List<User> findall() {
        return UserRepository.findAll();
    }

    public static User findById(Integer iduser) {
        return (User) UserRepository.findById(iduser).orElseThrow();
    }

    public User update(User user) throws ClassNotFoundException{
        if (UserRepository.existsByid(user.getIdUser())){
            return UserRepository.save(user);
        }
        throw new ClassNotFoundException("Usuario Inesxistente");
    }
    public void delete(Integer iduser) throws ClassNotFoundException{
        if(UserRepository.existsByid(iduser)){
            User User = (entities.User) UserRepository.findById(iduser).orElseThrow();
            UserRepository.delete(User);
        }
        throw new ClassNotFoundException("Esse Usuario Não Existe");
    }
}
