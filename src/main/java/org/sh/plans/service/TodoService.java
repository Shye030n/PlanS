package org.sh.plans.service;

import org.sh.plans.entity.TodoList;

public interface TodoService {
    //투두 저장
    TodoList saveTodo(TodoList todoList);
    //투두 전체 조회
    //투두 삭제
}
