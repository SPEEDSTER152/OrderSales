package Controllers;

import Services.UserService;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User newUser){
        User CreateUser = UserService.save(newUser);
        return new ResponseEntity<>(CreateUser, HttpStatus.CREATED);
    }
    @PatchMapping("/{idUser}")
    public ResponseEntity<User> update(@PathVariable("idUser") Integer idUser,
                                       @RequestBody User user) throws ClassNotFoundException{
        User updateUser = userService.findById(idUser);
        if(updateUser != null){
         updateUser = UserService.save(user);
         return new ResponseEntity<>(updateUser, HttpStatus.OK);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"O Usuario Nao Foi Encontrado");
    }
    public ResponseEntity<User> findbyId(@PathVariable("idUser") Integer idUser){
        User findUser = userService.findById(idUser);
        if(findUser != null){
           return new ResponseEntity<>(UserService.findById(idUser),HttpStatus.OK);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"O Id Do Usuario nao Foi Encontrado");
    }
    public ResponseEntity<List<User>> findall(){
        return new ResponseEntity<>(UserService.findall(),HttpStatus.OK);
    }
}
