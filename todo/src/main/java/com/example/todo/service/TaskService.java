package com.example.todo.service;

import com.example.todo.exception.NoResultException;
import com.example.todo.http.request.TaskRequest;
import com.example.todo.model.Task;
import com.example.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService implements ServiceInterface {

    @Autowired
    TaskRepository taskRepository;

    public List<Task> tasksByUserId(Integer id) {
        return taskRepository.findAllByUserId(id);
    }

    public List<Task> tasksByUserId(Integer id, Integer pageNo, Integer size, String sortBy) {
        String[] sortPropertyList = sortBy.split(",");
        List<Order> sortList = new ArrayList<>();
        for (String s : sortPropertyList) {
            String[] temp = s.split("-");
            sortList.add(new Order(temp.length == 1 ? Sort.Direction.ASC : getSortDirection(temp[1]), temp[0]));
        }
        Pageable paging = PageRequest.of(pageNo, size, Sort.by(sortList));
        Page<Task> pagedResult = taskRepository.findAllByUserId(id, paging);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    public void addTask(Task task) {
        if(task.getStatus() == null) {
            task.setStatus(0);
        }
        taskRepository.save(task);
    }

    public void removeTask(Integer id) {
        Task task = taskRepository.getTaskById(id);
        if(task == null) {
            throw new NoResultException("Found no task with id = " + id);
        }
        taskRepository.deleteById(id);
    }

    public void modifyTask(Integer id, TaskRequest taskRequest) {
        Task task = taskRepository.getTaskById(id);
        if(task == null) {
            throw new NoResultException("Found no task with id = " + id);
        }
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setStatus(taskRequest.getStatus());
        taskRepository.save(task);
    }

    public void removeTask(Integer id, Integer userId) {
        Task task = taskRepository.getTaskByIdAndUserId(id, userId);
        if(task == null) {
            throw new NoResultException("Found no task of this user with id = " + id);
        }
        taskRepository.deleteById(id);
    }

    public void modifyTask(Integer id, TaskRequest taskRequest, Integer userId) {
        Task task = taskRepository.getTaskByIdAndUserId(id, userId);
        if(task == null) {
            throw new NoResultException("Found no task of this user with id = " + id);
        }
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setStatus(taskRequest.getStatus());
        taskRepository.save(task);
    }

    private Sort.Direction getSortDirection(String direction) {
        if(direction.equals("desc")) {
            return Sort.Direction.DESC;
        } else {
            return Sort.Direction.ASC;
        }
    }
}
