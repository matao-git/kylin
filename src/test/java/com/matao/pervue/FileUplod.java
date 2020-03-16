package com.matao.pervue;

import com.matao.pervue.entity.Plan;
import com.matao.pervue.service.IPlanService;
import com.matao.pervue.utils.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;

@SpringBootTest
public class FileUplod {
    @Autowired
    private IPlanService iPlanService;
    @Test
    public void fileTest(){
        try {
            BufferedReader bufferedReader = FileUtils.readerLine("E://aaa.txt");
            String str = "";
            while((str=bufferedReader.readLine()) != null){
                String[] split = str.split("||");
                Plan plan = new Plan();
                plan.setName(split[0]);
//                int i = Integer.parseInt(split[1]);
//                plan.setAmount(new BigDecimal(i));
                plan.setContent(split[2]);
                iPlanService.save(plan);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
