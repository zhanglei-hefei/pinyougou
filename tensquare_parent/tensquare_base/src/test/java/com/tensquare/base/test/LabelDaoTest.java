package com.tensquare.base.test;

import com.tensquare.base.BaseApplication;
import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import util.IdWorker;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseApplication.class)
public class LabelDaoTest {
    @Autowired
    private LabelDao labelDao;
    @Autowired
    private IdWorker idWorker;

    @Test
    public void findAll(){
        List<Label> all = labelDao.findAll();
        System.out.println(all);
    }

    @Test
    public void save(){
        Label label = new Label(String.valueOf(idWorker.nextId()),"测试标签","0",10000L,"是",200l);
        Label save = labelDao.save(label);
        System.out.println(save);
    }
}
