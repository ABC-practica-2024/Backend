package ro.ubb.abc2024.security.token;


import ro.ubb.abc2024.user.User;

public interface TokenService {
    boolean isTokenValid(UserToken userToken);

    UserToken createToken(User user, int availability);

    UserToken getToken(String token);

    void removeToken(UserToken userToken);
}
