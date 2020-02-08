package com.surasak.crudnumber.service;

import com.surasak.crudnumber.entity.CalculateNum;
import com.surasak.crudnumber.repository.CalculateRepository;
import javassist.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.xml.ws.Response;


import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
//ไม่ต้องประกาศ obj ใช้ ใน when ได้เลย

import static javafx.scene.input.KeyCode.I;


@ExtendWith(MockitoExtension.class)
class CalculateServiceTest {

    CalculateService calculateService;

    @Mock
    CalculateRepository calculateRepository;

    @BeforeEach
    public void setup() {
        calculateService = new CalculateService(calculateRepository);

    }

    @Test
    public void shouldReturnfive() throws NotFoundException {
        CalculateNum calculateNum = new CalculateNum();
        System.out.println(calculateNum.toString());
        calculateNum.setId(3);
        calculateNum.setFirstNum(3);
        calculateNum.setSecondNum(2);
        System.out.println(calculateNum.toString());

        when(calculateRepository.findById(anyInt())).thenReturn(java.util.Optional.of(calculateNum));
        int sum = calculateService.calPlus(3);
        assertEquals(5, sum);

    }
    @Test
    public void shouldReturneight() throws NotFoundException {
        CalculateNum calculateNum = new CalculateNum();
        calculateNum.setId(5);
        calculateNum.setFirstNum(10);
        calculateNum.setSecondNum(2);
        when(calculateRepository.findById(anyInt())).thenReturn(java.util.Optional.of(calculateNum));
        int sum = calculateService.calDivide(5);
        assertNotEquals(7,sum);


    }


}