package com.back.end;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MyRepo extends MongoRepository<myData,String> {
    
}
