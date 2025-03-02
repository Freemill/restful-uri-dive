package kr.co.joneconsulting.myrestfulservice.bean;

import com.fasterxml.jackson.annotation.JsonFilter;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor
@JsonFilter("TestInfo")
public class TestUser {
    private int id;

    @Size(min = 2, message = "Name needs more than 2 words.")
    private String name;

    @Past(message = "Join Date not allows future date.")
    private Date joinDate;

    //    @JsonIgnore
    private String password;

    //    @JsonIgnore
    private String ssn;
}
