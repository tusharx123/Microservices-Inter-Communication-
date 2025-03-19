package com.tushar.userservice;

import com.tushar.userservice.entity.Users;
import com.tushar.userservice.repository.UserRepository;
import com.tushar.userservice.service.UserService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testGetAllUsers() {
        // Given
        List<Users> users = Arrays.asList(
                new Users(1, "John Doe", "john@example.com"),
                new Users(2, "Jane Doe", "jane@example.com")
        );

        when(userRepository.findAll()).thenReturn(users);

        // When
        List<Users> result = userService.getAllUsers();

        // Then
        assertEquals(2, result.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testAddUser() {
        // Given
        Users user = new Users(1, "John Doe", "john@example.com");

        when(userRepository.save(Mockito.any(Users.class))).thenReturn(user);

        // When
        Users savedUser = userService.addUser(user);

        // Then
        assertNotNull(savedUser);
        assertEquals("John Doe", savedUser.getUsername());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testGetUserById_Found() {
        // Given
        Users user = new Users(1, "John Doe", "john@example.com");

        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        // When
        Users result = userService.getUserById(1);

        // Then
        assertNotNull(result);
        assertEquals("John Doe", result.getUsername());
        verify(userRepository, times(1)).findById(1);
    }
}