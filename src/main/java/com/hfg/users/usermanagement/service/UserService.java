package com.hfg.users.usermanagement.service;

import com.hfg.users.usermanagement.model.Usuario;
import com.hfg.users.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Usuario> listAllUsers() {
        return userRepository.findAll();
    }

    public Usuario registerUser(Usuario usuario) {
        return userRepository.save(usuario);
    }

    public void deleteUser(String username) {
        Usuario usuario = userRepository.findByUsername(username);
        if (usuario != null) {
            userRepository.delete(usuario);
        }
    }

    public Usuario updateUser(String username, Usuario updatedUsuario) {
        Usuario usuario = userRepository.findByUsername(username);
        if (usuario != null) {
            updatedUsuario.setId(usuario.getId());
            return userRepository.save(updatedUsuario);
        }
        return null;
    }
}
