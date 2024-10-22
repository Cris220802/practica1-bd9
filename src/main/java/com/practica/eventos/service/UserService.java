package com.practica.eventos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.eventos.dto.UserDTO;
import com.practica.eventos.model.Perito;
import com.practica.eventos.model.User;
import com.practica.eventos.repository.PeritoRepository;
import com.practica.eventos.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PeritoRepository peritoRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    public User createUser(UserDTO userDTO) {
        if (userDTO == null) {
            throw new RuntimeException("El objeto userDTO no debe ser nulo");
        }

        if (userDTO.getPerito() == null) {
            throw new RuntimeException("El ID del tipo de evento no debe ser nulo");
        }

        // Buscar perito por id
        Perito perito = peritoRepository.findById(userDTO.getPerito())
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrado"));

       User user = new User(userDTO.getUsername(), userDTO.getEmail(), userDTO.getPassword(), userDTO.getCreateTime(), perito);

        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public User updateUser(String id, UserDTO userDTO) {
        if (userDTO == null) {
            throw new RuntimeException("El objeto userDTO no debe ser nulo");
        }

        if (userDTO.getPerito() == null) {
            throw new RuntimeException("El ID del tipo de evento no debe ser nulo");
        }

        // Buscar perito por id
        Perito perito = peritoRepository.findById(userDTO.getPerito())
                .orElseThrow(() -> new RuntimeException("Especialidad no encontrado"));

        // Buscar el user por el id
        User userExistente = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User no encontrado"));

        userExistente.setUsername(userDTO.getUsername());
        userExistente.setEmail(userDTO.getEmail());
        userExistente.setPassword(userDTO.getPassword());
        userExistente.setCreateTime(userDTO.getCreateTime());
        userExistente.setPerito(perito);

        return userRepository.save(userExistente);
    }
}
