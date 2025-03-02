package kr.co.joneconsulting.myrestfulservice.docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import kr.co.joneconsulting.myrestfulservice.bean.User;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "user-controller", description = "�Ϲ� ����� ���񽺸� ���� ��Ʈ�ѷ�")
public interface UserApiSpec {
    List<User> retrieveAllUsers();

    @Operation(summary = "����� ���� ��ȸ API", description = "����� ID�� �̿��ؼ� ����� �� ���� ��ȸ�� �մϴ�.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK !!"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST !!"),
            @ApiResponse(responseCode = "404", description = "USER NOT FOUND!"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR!!")
    })
    EntityModel<User> retrieveUser(@Parameter(description = "����� ID", required = true, example = "1") int id);

    ResponseEntity<User> createUser(User user);

    ResponseEntity deleteUser(int id);
}
