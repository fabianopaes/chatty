package com.neoway.chatty.api.web;

import com.neoway.chatty.api.config.EndpointConfig;
import com.neoway.chatty.api.domain.User;
import com.neoway.chatty.api.domain.resource.ErrorResource;
import com.neoway.chatty.api.service.UserService;
import com.neoway.chatty.api.utils.URIPathBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;


@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = EndpointConfig.USERS_COLLECTION, method = GET)
    @ResponseBody
    public Iterable<User> list(){
        return userService.findAll();
    }

    @RequestMapping(value = EndpointConfig.USERS_COLLECTION, method = POST)
    @ResponseBody
    public ResponseEntity<Object> create(@Valid @RequestBody User user, Errors errors) throws URISyntaxException {

        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(ErrorResource.badRequest(errors));
        }

        //TODO it still need to validate properly if the user is already  in database
        userService.create(user);

        return ResponseEntity
            .created(URIPathBinder.resourceLocationBuilder(EndpointConfig.USERS_SINGLE_RESOURCE,  null))
            .body(user);
    }

    @RequestMapping(value = EndpointConfig.USERS_SINGLE_RESOURCE, method = GET)
    @ResponseBody
    public ResponseEntity<Object> get(@PathVariable(value="id") String id){

        Optional<User> user = userService.findById(id);
        if(user.isPresent()){
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(ErrorResource.notFound("Not found an user with the given id"),
                HttpStatus.NOT_FOUND);
    }
}
