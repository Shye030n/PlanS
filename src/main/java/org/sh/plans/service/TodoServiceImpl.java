package org.sh.plans.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.sh.plans.entity.TodoList;
import org.sh.plans.entity.User;
import org.sh.plans.repository.TodoListRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoListRepository todoListRepository;
    //투두 저장
    @Override
    public TodoList saveTodo(TodoList todoList){
        todoList.setTitle(todoList.getTitle());
        todoList.setDonDate(todoList.getDonDate());
        todoList.setCreateDate(LocalDateTime.now());
        //저장된 투두 반환
        return todoListRepository.save(todoList);
    }
    //투두 전체 조회
    //투두 삭제




}
