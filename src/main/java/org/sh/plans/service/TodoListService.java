package org.sh.plans.service;

import org.sh.plans.dto.TodoListDTO;
import org.sh.plans.dto.UserDTO;
import org.sh.plans.entity.TodoList;
import org.sh.plans.entity.User;
import org.sh.plans.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class TodoListService {
    private final TodoListRepository todoListRepository;

    @Autowired
    public TodoListService(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    public TodoListDTO createTodo(String title, LocalDate donDate, UserDTO userDTO) {
        if (userDTO == null || userDTO.getId() == null) {
            throw new IllegalArgumentException("Invalid UserDTO provided.");
        }
        // UserDTO를 사용해 User 객체 생성
        User user = User.builder()
                .id(userDTO.getId())
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .name(userDTO.getName())
                .createTime(LocalDateTime.of(userDTO.getCreateTime(), LocalDateTime.now().toLocalTime()))  // LocalDate를 LocalDateTime으로 변환
                .role(userDTO.getRole())
                .build();

        // 현재 날짜와 시간 함께 포함된 LocalDateTime 사용
        TodoList todoList = TodoList.builder()
                .title(title)
                .createDate(LocalDateTime.now())  // LocalDateTime 사용
                .donDate(donDate)
                .isdone(false)
                .user(user)  // User 객체 사용
                .build();

        TodoList savedTodo = todoListRepository.save(todoList);
        return TodoListDTO.builder()
                .id(savedTodo.getId())
                .title(savedTodo.getTitle())
                .createTime(savedTodo.getCreateDate())  // LocalDateTime 사용 그대로 사용
                .donTime(savedTodo.getDonDate())
                .isDone(savedTodo.isIsdone())
                .build();
    }

}
