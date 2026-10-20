package com.example.jobApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ToString
@Entity
public class JobPost {

    @Id
    private int postId;
    @NotBlank(message = "the post name cant be empty")
    private String postProfile;
    private String postDesc;
    private int reqExperience;
    private List<String> postTechStack;


}
