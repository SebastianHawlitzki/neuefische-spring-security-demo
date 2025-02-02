package de.neuefische.neuefischespringsecuritydemo.appUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    private String id;
    private String username;
    private String password;
    private String role;
}
