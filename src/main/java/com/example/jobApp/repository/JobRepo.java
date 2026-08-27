package com.example.jobApp.repository;


import com.example.jobApp.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {

    public List<JobPost> findBypostDescContaining(String name);


}
