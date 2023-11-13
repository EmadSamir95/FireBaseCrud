package ebc.ipn.controller;

import ebc.ipn.entity.UserEntity;
import ebc.ipn.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userServiceImpl;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") int id)
            throws ExecutionException, InterruptedException {
        return userServiceImpl.get(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserEntity userEntity)
            throws ExecutionException, InterruptedException {
        return userServiceImpl.create(userEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody UserEntity userEntity)
            throws ExecutionException, InterruptedException {
        return userServiceImpl.update(id, userEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        return userServiceImpl.delete(id);
    }

}
