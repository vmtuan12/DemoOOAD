package com.example.todo.controller.task;

import com.example.todo.http.request.TaskRequest;
import com.example.todo.model.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/task/admin")
public class AdminTaskController extends TaskController {

    @GetMapping("/user-id={userId}")
    public List<Task> tasksByUserId(@PathVariable(name = "userId") Integer id) {
        return taskService.tasksByUserId(id);
    }

    @DeleteMapping("/remove-task/{taskId}")
    public ResponseEntity<?> removeTask(@PathVariable(name = "taskId") Integer id) {
        taskService.removeTask(id);
        return ResponseEntity.ok().body("Remove task successfully");
    }

    @PutMapping("/modify-task/{taskId}")
    public ResponseEntity<?> modifyTask(@PathVariable(name = "taskId") Integer id, @RequestBody TaskRequest taskRequest) {
        taskService.modifyTask(id, taskRequest);
        return ResponseEntity.ok().body("Modify task successfully");
    }
}
