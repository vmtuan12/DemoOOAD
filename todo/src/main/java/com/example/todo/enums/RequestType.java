package com.example.todo.enums;

public enum RequestType {

    CONG_VIEC("Yêu cầu công việc"),
    CA_NHAN("Yêu cầu cá nhân"),
    CSHS("Yêu cầu chỉnh sửa hồ sơ"),
    FIXED_SAL("Yêu cầu tăng lương"),
    MONTH_SAL("Yêu cầu sửa lương tháng"),
    RE_EVAL("Yêu cầu đánh giá lại");
    private String name;

    RequestType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
