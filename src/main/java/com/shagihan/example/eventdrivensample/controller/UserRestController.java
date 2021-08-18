package com.shagihan.example.eventdrivensample.controller;

import com.shagihan.example.eventdrivensample.model.User;
import com.shagihan.example.eventdrivensample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> SaveUser(@RequestBody User user) {
        User user1 = userService.SaveUser(user);
        if (user1 != null)
            return ResponseEntity.status(202).body(user);
        else
            return ResponseEntity.internalServerError().build();
    }

    @PostMapping(path = "/bulk")
    public ResponseEntity<List<User>> SaveUser(@RequestBody List<User> users) {
        List<User> user1 = userService.SaveUsers(users);
        if (user1 != null)
            return ResponseEntity.status(202).body(user1);
        else
            return ResponseEntity.internalServerError().build();
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(@RequestParam(name = "limit", defaultValue = "100")
                                                          Optional<Integer> limit,
                                                  @RequestParam(name = "offset", defaultValue = "0")
                                                          Optional<Integer> offset) {
        List<User> users = userService.getUserList(limit.get(), offset.get());
        return ResponseEntity.ok(users);
    }

    @GetMapping(path = "/{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") int userId) {

        User user = userService.getUser(userId);
        if (user == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(user);
    }

    @GetMapping(path = "/find")
    public ResponseEntity<User> getUserByNamr(@RequestParam("userName") String userName) {

        User user = userService.getUserByName(userName);
        if (user == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(user);
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity deleteUser(@PathVariable("userId") int userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{userId}")
    public ResponseEntity UpdateUser(@PathVariable("userId") int userId, @RequestBody User user) {
        User temp = userService.getUser(userId);
        if(temp != null) {
            user.setId(userId);
            return ResponseEntity.ok(userService.updateUser(user));
        } else {
            return ResponseEntity.internalServerError().body("Invalid input");
        }

    }


}
