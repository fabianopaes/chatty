package com.neoway.chatty.api.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Document(collection = "messages")
public class Message {

    @Id
    private String id;

    @NotNull(message = "from might not be null")
    private String from;

    @NotNull(message = "to might not be null")
    private String to;

    @NotNull(message = "body might not be null")
    private String body;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    @CreatedDate
    private Date sentAt;

    public static Message of(String from,String to, String body, Date sentAt ){
        Message message = new Message();
        message.setBody(body);
        message.setFrom(from);
        message.setTo(to);
        message.setSentAt(sentAt);
        return message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
