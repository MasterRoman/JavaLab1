package com.application.commonCode.app.entity;

import lombok.*;

@EqualsAndHashCode(callSuper = false)
@Data
@Builder
public class StudentEntity {

    private Integer id;
    private String name;
    private Integer age;
    private String summary;
}
