package com.support.tool;

import com.support.tool.docx.XmlToDocx;
import com.support.tool.docx.XmlToExcel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ToolApplicationTests {

    @Test
    public void contextLoads() {
        Integer a = new Integer(30);
        Integer b = new Integer(30);
        int c = 30;
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(a == b);
        System.out.println(a == c);
    }

    @Test
    public void tempDocx() {
        try {
            // xml的文件名
            String xmlTemplate = "text.xml";
            // docx的路径和文件名
            String docxTemplate = "D:\\github\\SpringBT\\tool\\src\\main\\resources\\text.docx";
            // 填充完数据的临时xml
            String xmlTemp = "D:\\github\\SpringBT\\tool\\src\\main\\resources\\temp.xml";
            // 目标文件名
            String toFilePath = "D:\\github\\SpringBT\\tool\\src\\main\\resources\\test.docx";

            Writer w = new FileWriter(new File(xmlTemp));
            // 1.需要动态传入的数据


            Map<String, Object> p = new HashMap<>();
            p.put("num", 366);
            p.put("date", "2018年12月13日");
            p.put("time", "13时47分");
            List<Map<String,Object>> controlList = new ArrayList<>();
            Map<String,Object> map = new HashMap<>();
            map.put("label","因降雪实施交通管制的路段");
            List<String> children = new ArrayList<>();
            children.add("连霍高速（G30）民权收费站-豫皖收费站");
            children.add("连霍高速（G30）民权收费站-豫皖收费站");
            children.add("连霍高速（G30）民权收费站-豫皖收费站");
            map.put("children",children);
            controlList.add(map);
            controlList.add(map);
            controlList.add(map);
            p.put("control",controlList);

            // 2.把map中的数据动态由freemarker传给xml
            XmlToExcel.process(xmlTemplate, p, w);

            // 3.把填充完成的xml写入到docx中
            XmlToDocx xtd = new XmlToDocx();
            xtd.outDocx(new File(xmlTemp), docxTemplate, toFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
