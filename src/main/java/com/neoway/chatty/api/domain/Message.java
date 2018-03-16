package com.neoway.chatty.api.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Username might not be null")
    private String from;

    @NotNull(message = "name might not be null")
    private String to;

    @NotNull(message = "name might not be null")
    private Long body;

    @NotNull(message = "name might not be null")
    private Date sentAt;
}
