package com.surasak.crudnumber.service;

import com.surasak.crudnumber.entity.CalculateNum;
import com.surasak.crudnumber.repository.CalculateRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalculateService {


    public CalculateService(CalculateRepository calculateRepository) {
        this.calculateRepository = calculateRepository;
    }

    private CalculateRepository calculateRepository;

    public List<CalculateNum> findAll() {
        return calculateRepository.findAll();
    }

    public CalculateNum create(CalculateNum request) {
        return calculateRepository.save(request);
    }
    public int calPlus(int id)throws NotFoundException{
        CalculateNum calculateNum = calculateRepository.findById(id).orElseThrow(() -> new NotFoundException("Notfound record"));
        //calculateNum.getFirstNum();
        //calculateNum.getSecondNum();
        int sum = calculateNum.getFirstNum()+calculateNum.getSecondNum();
        return sum;
    }
    public int calMinus(int id)throws NotFoundException{
        CalculateNum calculateNum = calculateRepository.findById(id).orElseThrow(() -> new NotFoundException("Notfound record"));
        //calculateNum.getFirstNum();
        //calculateNum.getSecondNum();
        int sum = calculateNum.getFirstNum()-calculateNum.getSecondNum();
        return sum;
    }
    public int calMultiplied(int id)throws NotFoundException{
        CalculateNum calculateNum = calculateRepository.findById(id).orElseThrow(() -> new NotFoundException("Notfound record"));
        //calculateNum.getFirstNum();
        //calculateNum.getSecondNum();
        int sum = calculateNum.getFirstNum()*calculateNum.getSecondNum();
        return sum;
    }
//    public int calDivide(int id)throws NotFoundException{
//        CalculateNum calculateNum = calculateRepository.findById(id).orElseThrow(() -> new NotFoundException("Notfound record"));
//        //calculateNum.getFirstNum();
//        //calculateNum.getSecondNum();
//        int sum = calculateNum.getFirstNum()/calculateNum.getSecondNum();
//        return sum;
//    }

    public int calDivide(int id) throws NotFoundException {
        CalculateNum calculateNum = calculateRepository.findById(id).orElseThrow(() -> new NotFoundException("Notfound record"));
        //calculateNum.getFirstNum();
        //calculateNum.getSecondNum();
        int sum = calculateNum.getFirstNum()/calculateNum.getSecondNum();
        return sum;
    }
    public CalculateNum findById(int id) throws NotFoundException {
        return calculateRepository.findById(id).orElseThrow(() -> new NotFoundException("Notfound record"));
    }
    public void deleteId(int id)throws NotFoundException {
        findById(id);
        calculateRepository.deleteById(id);
    }


}
