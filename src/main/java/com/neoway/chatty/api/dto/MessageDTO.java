package com.neoway.chatty.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class MessageDTO {

    private Long id;

    @NotNull(message = "from might not be null")
    private String from;

    @NotNull(message = "to might not be null")
    private String to;

    @NotNull(message = "body might not be null")
    private String body;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private Date sentAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getSentAt() {
        return sentAt;
    }

    public void setSentAt(Date sentAt) {
        this.sentAt = sentAt;
    }
}
