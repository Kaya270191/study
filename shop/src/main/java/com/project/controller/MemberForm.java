package com.project.controller;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberForm {
    private Long id;

    private Long pw;

    private String name;

    private int birthday;

    private String email;

    private String address;

}
