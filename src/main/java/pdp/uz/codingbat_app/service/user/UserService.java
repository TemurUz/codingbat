package pdp.uz.codingbat_app.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pdp.uz.codingbat_app.entity.UsersEntity;
import pdp.uz.codingbat_app.interfaces.UserInterfaceMethod;
import pdp.uz.codingbat_app.payload.ApiResponse;
import pdp.uz.codingbat_app.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserInterfaceMethod {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public ResponseEntity<List<UsersEntity>> getUsers(int page, int size) {
        List<UsersEntity> list = userRepository.findAll();
        return ResponseEntity.status(200).body(list);
    }

    @Override
    public ResponseEntity<UsersEntity> getUser(
            Long id
    ) {
        Optional<UsersEntity> userEntityOptional
                = userRepository.findById(id);
        if (userEntityOptional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        UsersEntity userEntity = userEntityOptional.get();
        return ResponseEntity.status(HttpStatus.FOUND).body(userEntity);
    }

    @Override
    public ResponseEntity<ApiResponse> saveUser(
            UsersEntity userEntity
    ) {

        boolean byEmail
                = userRepository
                .existsByEmail(userEntity.getEmail());

        if (byEmail){
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(new ApiResponse("Problem with account creation:Sorry, that email address is already in use\n" +
                            "Please go back and try again",false));
        }

        UsersEntity save = userRepository.save(userEntity);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse("Created user", true));
    }

    @Override
    public ResponseEntity<ApiResponse> editUser(
            Long id,
            UsersEntity userPassword
    ) {
        Optional<UsersEntity> optionalUserEntity = userRepository.findById(id);
        if (optionalUserEntity.isEmpty()){
           return ResponseEntity
                   .status(HttpStatus.NOT_FOUND)
                   .body(new ApiResponse("USER NOT FOUND",false));
        }
        UsersEntity userEntity = optionalUserEntity.get();
        userEntity.setPassword(userPassword.getPassword());
        userRepository.save(userEntity);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(new ApiResponse("EDIT USER",true));
    }

    @Override
    public ResponseEntity<ApiResponse> deleteUser(
            Long id
    ) {
        try {
            userRepository.deleteById(id);
            return ResponseEntity.ok(new ApiResponse( " delete", true));
        }catch (Exception e){
            return ResponseEntity
                    .ok(new ApiResponse("Xatolik!!", false));
        }
    }
}
