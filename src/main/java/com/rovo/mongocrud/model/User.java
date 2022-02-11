package com.rovo.mongocrud.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="User")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    private long id;
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Indexed(unique = true)
    private String name;
    @Indexed(unique = true)
    private String  city;

}
