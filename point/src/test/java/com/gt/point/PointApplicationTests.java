package com.gt.point;

import org.junit.Test;
import org.kabeja.dxf.DXFDocument;
import org.kabeja.parser.ParseException;
import org.kabeja.parser.Parser;
import org.kabeja.parser.ParserBuilder;
import org.kabeja.svg.SVGGenerator;
import org.kabeja.xml.SAXGenerator;
import org.kabeja.xml.SAXSerializer;
import org.kabeja.xslt.SAXXMLSerializer;
import org.xml.sax.SAXException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class PointApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void sss() throws SAXException, FileNotFoundException, ParseException {
        Parser dxfParser = ParserBuilder.createDefaultParser();
        dxfParser.parse(new FileInputStream("D:\\dxf\\05 06西毓顺路（推荐 修改）.dwg-2019-09-25-16-15-51-742.dxf"),"GB18030");//需要转换的dxf
        DXFDocument doc = dxfParser.getDocument();

        SAXGenerator generator = new SVGGenerator();


        // 输出SVG
        SAXSerializer out =new SAXXMLSerializer();

        OutputStream fileo = new FileOutputStream("D:\\test2.svg");//转换所得的文件

        // out.setOutputStream(response.getOutputStream()) //write direct to
        // ServletResponse
        out.setOutput(fileo);
        // generate
        generator.generate(doc, out, new HashMap());
    }
}
