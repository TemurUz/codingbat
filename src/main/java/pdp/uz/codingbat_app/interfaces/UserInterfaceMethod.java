package pdp.uz.codingbat_app.interfaces;

import org.springframework.http.ResponseEntity;
import pdp.uz.codingbat_app.entity.UsersEntity;
import pdp.uz.codingbat_app.payload.ApiResponse;

import java.util.List;

public interface UserInterfaceMethod {

    ResponseEntity<List<UsersEntity>> getUsers(int page, int size);

    ResponseEntity<UsersEntity> getUser(Long id);

    ResponseEntity<ApiResponse> saveUser(UsersEntity userEntity);

    ResponseEntity<ApiResponse> editUser(Long id , UsersEntity usersEntity);

    ResponseEntity<ApiResponse> deleteUser(Long id);

}
