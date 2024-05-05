package kr.co.smsconsulting.myrestfulservice.bean;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("userInfo")
public class AdminUser {
    private Integer id;

    @Size(min = 2, message = "Name은 두글자 이상 입력해주세요.")
    private String name;

    @Past(message = "등록일은 미래 날짜를 이렵하실 수 없습니다.")
    private Date joinDate;

    private String password;
    private String ssn;
}
