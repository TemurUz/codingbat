package pdp.uz.codingbat_app.service.user;

import org.springframework.http.ResponseEntity;
import pdp.uz.codingbat_app.entity.UsersEntity;
import pdp.uz.codingbat_app.payload.ApiResponse;
import pdp.uz.codingbat_app.payload.PagedResponse;

import java.util.List;

public interface UserService {

    PagedResponse<UsersEntity> getUsers(int page, int size);

    UsersEntity getUser(Long id);

    ApiResponse saveUser(UsersEntity userEntity);

    ApiResponse editUser(Long id , UsersEntity usersEntity);

    ApiResponse deleteUser(Long id);

}
