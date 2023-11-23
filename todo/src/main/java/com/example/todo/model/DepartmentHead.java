package com.example.todo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@Table(name = "department_head")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(DepHeadPair.class)
public class DepartmentHead implements Serializable {

    private static final long serialVersionUID = -197553281792804396L;

    @Id
    @Column(name = "department_id")
    private Long departmentId;

    @Id
    @Column(name = "head_id")
    private Long headId;
}
