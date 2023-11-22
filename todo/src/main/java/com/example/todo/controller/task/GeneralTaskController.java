package com.example.todo.controller.task;

import com.example.todo.http.request.TaskRequest;
import com.example.todo.model.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/task/general")
public class GeneralTaskController extends TaskController {

    @GetMapping("/own-task")
    public List<Task> tasksByUserId(@RequestHeader("Authorization") String token,
                                    @RequestParam(name = "pageNo", defaultValue = "0") Integer pageNo,
                                    @RequestParam(name = "size", defaultValue = "5") Integer size,
                                    @RequestParam(name = "sort", defaultValue = "id") String sortBy) {
        return taskService.tasksByUserId(Integer.parseInt(jwtService.extractId(token.substring(7))),
                pageNo,
                size,
                sortBy);
    }

    @PostMapping("/add-task")
    public ResponseEntity<?> addTask(@RequestBody TaskRequest taskRequest, @RequestHeader("Authorization") String token) {
        Integer userId = Integer.parseInt(jwtService.extractId(token.substring(7)));
        taskService.addTask(new Task(taskRequest.getTitle(), taskRequest.getDescription(), userId));
        return ResponseEntity.ok().body("Add task successfully");
    }

    @DeleteMapping("/remove-task/{taskId}")
    public ResponseEntity<?> removeTask(@PathVariable(name = "taskId") Integer id, @RequestHeader("Authorization") String token) {
        Integer userId = Integer.parseInt(jwtService.extractId(token.substring(7)));
        taskService.removeTask(id, userId);
        return ResponseEntity.ok().body("Remove task successfully");
    }

    @PutMapping("/modify-task/{taskId}")
    public ResponseEntity<?> modifyTask(@PathVariable(name = "taskId") Integer id,
                                        @RequestBody TaskRequest taskRequest,
                                        @RequestHeader("Authorization") String token) {
        Integer userId = Integer.parseInt(jwtService.extractId(token.substring(7)));
        taskService.modifyTask(id, taskRequest, userId);
        return ResponseEntity.ok().body("Modify task successfully");
    }
}
