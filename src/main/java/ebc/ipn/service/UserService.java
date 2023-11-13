package ebc.ipn.service;

import ebc.ipn.entity.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.ExecutionException;

public interface UserService {

    ResponseEntity<?> get(int id) throws ExecutionException, InterruptedException;
    ResponseEntity<?> create(UserEntity entity) throws ExecutionException, InterruptedException;
    ResponseEntity<?> update(int id, UserEntity entity) throws ExecutionException, InterruptedException;
    ResponseEntity<?> delete(int id);

}
