package com.example.todo.dto;

public interface BaseMemberDto {
    String getName();
    String getDepartment();
    String getRole();
    Integer getIsHead();

    default String getRoleStr() {
        String result;
        switch (getRole()) {
            case "EMPLOYEE" -> result = "Nhân viên";
            case "ACCOUNTANT" -> result = "Kế toán";
            case "HR" -> result = "Nhân sự";
            case "ADMIN" -> result = "Quản trị viên";
            case "ADMINISTRATIVE" -> result = "Chuyên viên hành chính";
            case "PRESIDENT" -> result = "Giám đốc";
            default -> result = "";
        }
        if (getIsHead() == 1) {
            result = "Trưởng phòng";
        }
        return result;
    }
}
