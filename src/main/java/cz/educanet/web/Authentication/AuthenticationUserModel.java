package cz.educanet.web.Authentication;

import cz.educanet.web.Token;
import cz.educanet.web.Users.Users;

public class AuthenticationUserModel {

    public Users user;
    public Token token;

    public AuthenticationUserModel(Users user, Token token) {
        this.user = user;
        this.token = token;
    }

    public AuthenticationUserModel() {
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
}
