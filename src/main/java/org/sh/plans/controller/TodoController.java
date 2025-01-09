package org.sh.plans.controller;

import org.sh.plans.entity.TodoList;
import org.sh.plans.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todo")
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    private final TodoService todoService;  // TodoService의 의존성을 주입받기 위한 필드 선언

    @Autowired  // 생성자 기반 의존성 주입
    public TodoController(TodoService todoService) {
        this.todoService = todoService;  // 주입받은 TodoService 필드를 초기화
    }

    @PostMapping("/save")  // POST 요청을 통해 새로운 투두 리스트 항목을 저장하는 메서드
    public TodoList saveTodo(@RequestBody TodoList todoList) {
        return todoService.saveTodo(todoList);  // TodoService의 saveTodo 메서드를 호출하여 투두 리스트 저장 및 반환
    }
}

