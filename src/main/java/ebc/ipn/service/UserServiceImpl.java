package ebc.ipn.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import ebc.ipn.entity.UserEntity;
import ebc.ipn.util.Collection;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public ResponseEntity<?> get(int id) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference reference = firestore.collection(Collection.crud_user.name()).document(String.valueOf(id));
        ApiFuture<DocumentSnapshot> document = reference.get();
        if(document.get().exists()) {
            return ResponseEntity.ok(document.get().toObject(UserEntity.class));
        } else {
            throw new RuntimeException("document is not found");
        }
    }

    @Override
    public ResponseEntity<?> create(UserEntity entity) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> future = firestore.collection(Collection.crud_user.name()).document(entity.getName()).set(entity);
        return ResponseEntity.ok(future.get().getUpdateTime().toString());
    }

    @Override
    public ResponseEntity<?> update(int id, UserEntity entity) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> future = firestore.collection(Collection.crud_user.name()).document(entity.getName()).set(entity);
        return ResponseEntity.ok(future.get().getUpdateTime().toString());
    }

    @Override
    public ResponseEntity<?> delete(int id) {
        Firestore firestore = FirestoreClient.getFirestore();
        firestore.collection(Collection.crud_user.name()).document(String.valueOf(id)).delete();
        return ResponseEntity.ok("deleted successfully " + id);
    }
}
