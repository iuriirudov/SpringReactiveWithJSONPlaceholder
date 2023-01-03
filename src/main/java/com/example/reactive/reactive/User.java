package com.example.reactive.reactive;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "name",
        "username",
        "email",
        "id"
})
public class User {
    private final long id;
    private final String name;
    private final String username;
    private final String email;

    @JsonCreator
    public User(@JsonProperty("id") long id,
                @JsonProperty("name") String name,
                @JsonProperty("username") String username,
                @JsonProperty("email") String email) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
