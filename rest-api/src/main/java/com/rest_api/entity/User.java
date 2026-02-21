package com.rest_api.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Data
@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(unique = true, length = 20)
    private String username;  //아이디

    @Column(nullable = false)
    private String password;  //비밀번호

    @Column(nullable = false, length = 50)
    private String email;  //이메일

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp regDate;  //가입일

    @UpdateTimestamp
    @Column(insertable = false)
    private  Timestamp updateDate; //수정일
}
