package com.array.onlineshopspring.TestFile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestFileRepo extends JpaRepository<TestFile, Integer> {
}
