package com.back.end;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class Tasks {

    
   @Autowired
   private MyRepo myRep;

   @GetMapping("/")
   public String sendit() {
      return "Its working";
   }

   @GetMapping("/give")
   public List<myData> getit() {
      return myRep.findAll();
   }

   @GetMapping("/give/total")
   public Long getcount() {
      return myRep.count();
   }

   @PostMapping("/postthis")
   public void postMethodName(@RequestBody myData mydata) {
      myRep.insert(mydata);
   }

   @PutMapping("/putthis")
   public String putMethodName(@RequestBody myData mydata) {
      List<myData> whole = getit();
      for (myData myData2 : whole) {
         if ((myData2.getName()).equals(mydata.getName())) {
            mydata.setId(myData2.getId());
            myRep.save(mydata);
            System.out.println(myData2.getName());
         }
      }
      return "Putted";
   }

   
   

   @DeleteMapping("/rem/{name}")
   public String removethis(@PathVariable("name") String Name) {
      List<myData> whole = getit();
      for (myData myData2 : whole) {
         if (myData2.getName().equals(Name)){
            String idd =myData2.getId();
           myRep.deleteById(idd);
          
         }
      }
      System.out.println(Name);
      return "Deleted";
   }

}
