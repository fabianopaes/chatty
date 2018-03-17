package com.neoway.chatty.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class UserDTO {

    private Long id;

    @NotNull(message = "username might not be null")
    private String username;

    private String name;

    private Long budget;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private Date createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private Date updatedAt;
}
