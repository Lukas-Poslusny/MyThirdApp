package cz.educanet.web;

import java.util.UUID;

public class Token {

    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Token(String body) {
        this.body = body;
    }

    public Token() {
        this.body = UUID.randomUUID().toString();
    }
}
