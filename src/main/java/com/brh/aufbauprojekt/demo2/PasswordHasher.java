package com.brh.aufbauprojekt.demo2;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHasher {
    public static class hashPassword{
        public hashPassword(String profileName, String newPW) {
            // Erzeuge ein Hash mit BCrypt
            String hashedPW = BCrypt.hashpw(newPW, BCrypt.gensalt());
            new JSONHandler.saveProfileData(profileName, hashedPW);
        }
    }
    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}