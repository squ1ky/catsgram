package ru.project.catsgram.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
public class ChatMessage {

    @Setter
    private Integer id;

    @Setter
    private String userFrom;

    @Setter
    private String userTo;

    @Setter
    private Date sendDate;

    @Setter
    private String message;

    @Setter
    private Boolean userRead;
}
