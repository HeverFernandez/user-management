package com.hfg.users.usermanagement.controller;

import com.hfg.users.usermanagement.model.Usuario;
import com.hfg.users.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Usuario> listAllUsers() {
        return userService.listAllUsers();
    }

    @PostMapping
    public Usuario registerUser(@RequestBody Usuario usuario) {
        return userService.registerUser(usuario);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{username}")
    public ResponseEntity<Usuario> updateUser(@PathVariable String username, @RequestBody Usuario updatedUsuario) {
        Usuario usuario = userService.updateUser(username, updatedUsuario);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.notFound().build();
    }
}
