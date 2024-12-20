package org.sh.plans.controller;

import org.sh.plans.dto.TodoListDTO;
import org.sh.plans.dto.UserDTO;
import org.sh.plans.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todo")
public class TodoListController {

    private final TodoListService todoListService;

    @Autowired
    public TodoListController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @PostMapping("/create")
    public TodoListDTO createTodo(@RequestBody TodoListDTO todoListDTO) {
        // 사용자 정보를 UserDTO로 변환
        UserDTO userDTO = UserDTO.builder()
                .id(todoListDTO.getUserDTO().getId())
                .username(todoListDTO.getUserDTO().getUsername())
                .password(todoListDTO.getUserDTO().getPassword())
                .name(todoListDTO.getUserDTO().getName())
                .createTime(todoListDTO.getUserDTO().getCreateTime())  // LocalDateTime 유지
                .role(todoListDTO.getUserDTO().getRole())
                .build();

        // TodoList 생성 요청 처리
        return todoListService.createTodo(todoListDTO.getTitle(), todoListDTO.getDonTime(), userDTO);
    }
}
