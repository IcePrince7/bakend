package com.back.end;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Tasks {
   

   @Autowired
   private MyRepo myRep;

    @GetMapping("/")
     public String sendit(){
        return "Its working";
     }
    @GetMapping("/give")
     public List<myData> getit(){

        return myRep.findAll();
     }

     @PostMapping("/putthis")
     public void postMethodName(@RequestBody myData mydata) {
      myRep.insert(mydata);
     }
     
     
     
     
   }
