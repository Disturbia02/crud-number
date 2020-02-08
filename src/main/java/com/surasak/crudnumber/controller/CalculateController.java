package com.surasak.crudnumber.controller;

import com.surasak.crudnumber.entity.CalculateNum;
import com.surasak.crudnumber.service.CalculateService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/calculate")
@RestController
public class CalculateController {

    @Autowired
    private CalculateService calculateService;

    @PostMapping("/")
    public ResponseEntity Create(@RequestBody CalculateNum request) {
        return ResponseEntity.ok(calculateService.create(request));
    }
    @GetMapping("/find")
    public ResponseEntity Find(@RequestBody CalculateNum request){
        return ResponseEntity.ok(calculateService.findAll());
    }

    @GetMapping("/minus/{id}")
    public ResponseEntity calMiuns(@PathVariable int id) throws NotFoundException {
        return ResponseEntity.ok(calculateService.calMinus(id));
    }
    @GetMapping("/plus/{id}")
    public ResponseEntity calPlus(@PathVariable int id) throws NotFoundException {
        return ResponseEntity.ok(calculateService.calPlus(id));
    }
    @GetMapping("/multiplied/{id}")
    public ResponseEntity calMultiplied(@PathVariable int id) throws NotFoundException {
        return ResponseEntity.ok(calculateService.calMultiplied(id));
    }
    @GetMapping("/divide/{id}")
    public ResponseEntity calDivide(@PathVariable int id) throws NotFoundException {
        return ResponseEntity.ok(calculateService.calDivide(id));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id)throws NotFoundException {
        calculateService.deleteId(id);
        return ResponseEntity.ok().build();
    }
//    @DeleteMapping

//    @PutMapping
}
