package kr.co.joneconsulting.myrestfulservice.controller;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import kr.co.joneconsulting.myrestfulservice.bean.TestUser;
import kr.co.joneconsulting.myrestfulservice.bean.User;
import kr.co.joneconsulting.myrestfulservice.dao.UserDaoService;
import kr.co.joneconsulting.myrestfulservice.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestUserController {
    private final UserDaoService service;

    @GetMapping("/users/{id}")
    public MappingJacksonValue findUserById(@PathVariable("id") int id) {
        User user = service.findOne(id);

        TestUser testUser = new TestUser();
        if (user == null) {
            throw new UserNotFoundException(String.format("User with id %s not found", id));
        } else {
            BeanUtils.copyProperties(user, testUser);
        }

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id");
        SimpleFilterProvider filters = new SimpleFilterProvider().addFilter("TestUserFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(testUser);
        mapping.setFilters(filters);

        return mapping;
    }

}
