package com.neoway.chatty.api.web;

import com.neoway.chatty.api.config.EndpointConfig;
import com.neoway.chatty.api.domain.User;
import com.neoway.chatty.api.domain.resource.ErrorResource;
import com.neoway.chatty.api.service.UserService;
import com.neoway.chatty.api.utils.URIPathBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.Produces;
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

    @RequestMapping(value = EndpointConfig.USERS_COLLECTION, method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<User> list(){
        return userService.findAll();
    }

    @RequestMapping(value = EndpointConfig.USERS_COLLECTION, method = POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> create(@Valid @RequestBody User request, Errors errors) throws URISyntaxException {

        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(ErrorResource.badRequest(errors));
        }

        Optional<User> user = userService.findByUsername(request.getUsername());
        if(user.isPresent()){
            return new ResponseEntity(ErrorResource.conflict("Unable to create. A User with name " +
                    user.get().getName() + " already exist."),HttpStatus.CONFLICT);

        }
        userService.save(request);

        return ResponseEntity
            .created(URIPathBinder.resourceLocationBuilder(request.getId()))
            .body(request);
    }

    @RequestMapping(value = EndpointConfig.USERS_SINGLE_RESOURCE, method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
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
