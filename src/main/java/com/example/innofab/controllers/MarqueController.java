package com.example.innofab.controllers;


import com.example.innofab.models.Marque;
import com.example.innofab.payloads.request.MarqueRequest;
import com.example.innofab.payloads.response.DataResponse;
import com.example.innofab.payloads.response.MessageResponse;
import com.example.innofab.services.MarqueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/marque")
@Slf4j

public class MarqueController {
@Autowired
MarqueService marqueService ;

    @PostMapping(value = "/post")
    public ResponseEntity registerRecruiter(@RequestBody @Validated MarqueRequest marqueRequest) {
        try {

           Marque recruiter=   marqueService.POSTMarque(marqueRequest);
            // return ResponseEntity.ok(new DataResponse(recruiter));

            return ResponseEntity.ok(new MessageResponse("added with success"));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
    }



    @GetMapping("/get")
    public ResponseEntity FetchallMarques() {
        try {
            List<Marque> result=marqueService.FetchAllmarques();
            return ResponseEntity.ok(new DataResponse(result));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }

    }


    @PutMapping("/edit")
    public ResponseEntity editJob(@RequestBody Marque editRequest) {
        try {
            System.out.println("hello edit");
            marqueService.editmarque(editRequest);
            return ResponseEntity.ok(new MessageResponse("marque updated"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }

    }




}





