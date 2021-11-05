package com.example.innofab.services;


import com.example.innofab.models.Marque;
import com.example.innofab.payloads.request.MarqueRequest;
import com.example.innofab.repositories.MarqueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarqueService {
    @Autowired
    MarqueRepo marqueRepo ;



    public Marque POSTMarque(MarqueRequest marqueRequest) throws Exception {

        if (marqueRepo.existsByCode(marqueRequest.getCode())){
            throw new Exception("already created");
        }

        Marque marque =new Marque(marqueRequest.getNom(),marqueRequest.getCode());
        return marqueRepo.save(marque);

    }



    public  List<Marque> FetchAllmarques() throws Exception{

        List<Marque> results= marqueRepo.findAll();
        return results;
    }



    public  Marque editmarque(Marque editrequest) throws Exception{
        System.out.println("step2");

        Marque marque = (Marque) marqueRepo.findByCode(editrequest.getCode()).orElseThrow(() -> new Exception("marque not found"));

        System.out.println("step2");

        if (editrequest.getNom() != null) {
            marque.setNom(editrequest.getNom());
        }
        System.out.println(marque.getCode());
        return marqueRepo.save(marque);
    }




}
