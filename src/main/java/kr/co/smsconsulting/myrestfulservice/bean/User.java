package kr.co.smsconsulting.myrestfulservice.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(value = {"password", "ssn"})
public class User {
    private Integer id;

    @Size(min = 2, message = "Name은 두글자 이상 입력해주세요.")
    private String name;

    @Past(message = "등록일은 미래 날짜를 이렵하실 수 없습니다.")
    private Date joinDate;

//    @JsonIgnore
    private String password;
//    @JsonIgnore
    private String ssn;
}
