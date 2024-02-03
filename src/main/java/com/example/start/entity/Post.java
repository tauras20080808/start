package com.example.start.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Заголовок не может быть пустым")
    @Size(max = 255, message = "Заголовок слишком длинный")
    private String title;

    @NotBlank(message = "Содержание не может быть пустым")
    @Size(max = 1000, message = "Содержание слишком длинное")
    private String content;
}
