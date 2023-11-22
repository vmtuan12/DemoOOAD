DROP DATABASE IF EXISTS `ooad`;
CREATE DATABASE `ooad`;
USE ooad;

CREATE TABLE account (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(200),
    password VARCHAR(200)
);

CREATE TABLE member (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200),
    birthday DATE,
    gmail VARCHAR(200),
    role ENUM('PRESIDENT', 'EMPLOYEE', 'ACCOUNTANT', 'ADMINISTRATIVE', 'ADMIN', 'HR'),
    salary FLOAT
);

CREATE TABLE notification (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES member (id) ON DELETE SET NULL,
    content VARCHAR(255),
    status BOOLEAN,
    sent_time TIMESTAMP
);

CREATE TABLE department (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    department_name VARCHAR(100)
);

CREATE TABLE department_head (
    department_id BIGINT,
    head_id BIGINT,
    PRIMARY KEY (department_id, head_id),
    FOREIGN KEY (department_id) REFERENCES department (id) ON DELETE CASCADE,
    FOREIGN KEY (head_id) REFERENCES member (id) ON DELETE CASCADE
);

CREATE TABLE monthly_salary (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    owner_id BIGINT,
    FOREIGN KEY (owner_id) REFERENCES member (id) ON DELETE SET NULL,
    accountant_id BIGINT,
    time DATE,
    insurance_fee FLOAT,
    tax_fee FLOAT,
    bonus FLOAT,
    penalty FLOAT,
    is_final BOOLEAN
);

CREATE TABLE monthly_salary_complain_request (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    sent_user_id BIGINT,
    FOREIGN KEY (sent_user_id) REFERENCES member (id) ON DELETE SET NULL,
    receive_user_id BIGINT,
    FOREIGN KEY (receive_user_id) REFERENCES member (id) ON DELETE SET NULL,
    salary_id BIGINT,
    FOREIGN KEY (salary_id) REFERENCES monthly_salary (id) ON DELETE SET NULL,
    title VARCHAR(200),
    content VARCHAR(200),
    request_time TIMESTAMP,
    handled_time TIMESTAMP,
    note VARCHAR(255)
);

CREATE TABLE personal_request (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    sent_user_id BIGINT,
    FOREIGN KEY (sent_user_id) REFERENCES member (id) ON DELETE SET NULL,
    receive_user_id BIGINT,
    FOREIGN KEY (receive_user_id) REFERENCES member (id) ON DELETE SET NULL,
    title VARCHAR(200),
    content VARCHAR(200),
    request_time TIMESTAMP,
    handled_time TIMESTAMP,
    note VARCHAR(255)
);

CREATE TABLE fixed_salary_change_request (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    sent_user_id BIGINT,
    FOREIGN KEY (sent_user_id) REFERENCES member (id) ON DELETE SET NULL,
    receive_user_id BIGINT,
    FOREIGN KEY (receive_user_id) REFERENCES member (id) ON DELETE SET NULL,
    employee_id BIGINT,
    FOREIGN KEY (employee_id) REFERENCES member (id) ON DELETE SET NULL,
    new_salary FLOAT,
    title VARCHAR(200),
    content VARCHAR(200),
    request_time TIMESTAMP,
    handled_time TIMESTAMP,
    note VARCHAR(255)
);

CREATE TABLE work_request (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    sent_user_id BIGINT,
    FOREIGN KEY (sent_user_id) REFERENCES member (id) ON DELETE SET NULL,
    receive_user_id BIGINT,
    FOREIGN KEY (receive_user_id) REFERENCES member (id) ON DELETE SET NULL,
    title VARCHAR(200),
    content VARCHAR(200),
    request_time TIMESTAMP,
    handled_time TIMESTAMP,
    note VARCHAR(255),
    is_approved_by_head_of_dep BOOLEAN
);

CREATE TABLE draft_employee_profile (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    employee_id BIGINT,
    FOREIGN KEY (employee_id) REFERENCES member (id) ON DELETE SET NULL,
    name VARCHAR(200),
    birthday DATE,
    gmail VARCHAR(200),
    is_deleted BOOLEAN
);

CREATE TABLE profile_modification_request (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    sent_user_id BIGINT,
    FOREIGN KEY (sent_user_id) REFERENCES member (id) ON DELETE SET NULL,
    receive_user_id BIGINT,
    FOREIGN KEY (receive_user_id) REFERENCES member (id) ON DELETE SET NULL,
    draft_profile_id BIGINT,
    FOREIGN KEY (draft_profile_id) REFERENCES draft_employee_profile (id) ON DELETE SET NULL,
    title VARCHAR(200),
    content VARCHAR(200),
    request_time TIMESTAMP,
    handled_time TIMESTAMP,
    note VARCHAR(255)
);

CREATE TABLE employee_performance (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    employee_id BIGINT,
    FOREIGN KEY (employee_id) REFERENCES member (id) ON DELETE SET NULL,
    hr_id BIGINT,
    FOREIGN KEY (hr_id) REFERENCES member (id) ON DELETE SET NULL,
    performance_score FLOAT,
    comment TEXT,
    evaluate_time TIMESTAMP
);

CREATE TABLE re_evaluate_request (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    sent_user_id BIGINT,
    FOREIGN KEY (sent_user_id) REFERENCES member (id) ON DELETE SET NULL,
    receive_user_id BIGINT,
    FOREIGN KEY (receive_user_id) REFERENCES member (id) ON DELETE SET NULL,
    employee_performance_id BIGINT,
    FOREIGN KEY (employee_performance_id) REFERENCES employee_performance (id) ON DELETE SET NULL,
    title VARCHAR(200),
    content VARCHAR(200),
    request_time TIMESTAMP,
    handled_time TIMESTAMP,
    note VARCHAR(255)
);