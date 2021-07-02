package pdp.uz.codingbat_app.controller.userCon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import pdp.uz.codingbat_app.entity.UsersEntity;
import pdp.uz.codingbat_app.interfaces.UserInterfaceMethod;
import pdp.uz.codingbat_app.payload.ApiResponse;
import pdp.uz.codingbat_app.service.user.UserService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/user")
public class UserController implements UserInterfaceMethod {
    @Autowired
    UserService userService;

    /**
     * All User list return
     *
     * @return List<UserEntity>
     */
    @Override
    @GetMapping("/list")
    public ResponseEntity<List<UsersEntity>> getUsers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return userService.getUsers(page, size);
    }

    /**
     * This id a User return
     *
     * @param id
     * @return User
     */
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<UsersEntity> getUser(
            @PathVariable Long id
    ) {
        ResponseEntity<UsersEntity> user = userService.getUser(id);
        return user;
    }


    /**
     * Save User
     *
     * @param userEntity
     * @return ApiResponse
     */
    @PostMapping("/save")
    @Override
    public ResponseEntity<ApiResponse> saveUser(
            @Valid @RequestBody UsersEntity userEntity
    ) {
        return userService.saveUser(userEntity);
    }

    /**
     * Edit User password
     *
     * @param id
     * @param usersEntity
     * @return ApiResponse
     */
    @PutMapping("/edit/{id}")
    @Override
    public ResponseEntity<ApiResponse> editUser(
            @PathVariable Long id,
            @Valid @RequestBody UsersEntity usersEntity
    ) {
        ResponseEntity<ApiResponse> apiResponseResponseEntity
                = userService
                .editUser(id, usersEntity);

        return apiResponseResponseEntity;
    }

    /**
     * Delete user via id
     *
     * @param id
     * @return ApiResponse
     */
    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<ApiResponse> deleteUser(
            @PathVariable Long id
    ) {
        ResponseEntity<ApiResponse> apiResponseResponseEntity = userService.deleteUser(id);
        if (apiResponseResponseEntity.getBody().isSuccess()) {
            return ResponseEntity.status(202).body(apiResponseResponseEntity.getBody());
        }
        return ResponseEntity.status(409).body(apiResponseResponseEntity.getBody());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
