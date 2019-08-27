package com.hyzx.easypoi.hyzxeasypoi;

import cn.afterturn.easypoi.word.WordExportUtil;
import cn.afterturn.easypoi.word.entity.WordImageEntity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hyzx.easypoi.hyzxeasypoi.entity.ProjectTaskLog;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import org.apache.commons.io.FileUtils;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huyue
 * @date 2019/7/31 17:08
 */
public class WordTest {

    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(WordTest.class);

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");



    /**
     * 简单导出包含图片
     */
    @Test
    public void imageWordExport() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "Easypoi");
        WordImageEntity image = new WordImageEntity();
        image.setHeight(600);
        image.setWidth(800);
        image.setUrl("C:\\Users\\10283\\Desktop\\tree.png");
        image.setType(WordImageEntity.URL);
        map.put("image", image);
        try {
            XWPFDocument doc = WordExportUtil.exportWord07(
                    "D:\\github\\SpringBT\\hyzx-easypoi\\src\\main\\resources\\Image.docx", map);
            FileOutputStream fos = new FileOutputStream("D:\\github\\SpringBT\\hyzx-easypoi\\target\\图片.docx");
            doc.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 简单导出没有图片和Excel
     */
    @Test
    public void SimpleWordExport() {
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("department", "Easypoi");
//        map.put("person", "JueYue");
//        map.put("time", format.format(new Date()));
//        map.put("me", "JueYue");
//        map.put("date", "2015-01-03");

        ProjectTaskLog log = new ProjectTaskLog();
        log.setId("asjdlfjaskdfhaklhsdflkah");
        log.setConditionRecord("<p><strong>一、施工准备</strong></p><p>\t施工前先进行道路的场地平整，路基控制高程的测设，并经复核。</p><p><strong>二、材料、机械准备</strong></p><p>\t1、材料：级配砂砾、粗粒土等。</p><p>\t2、机械：洒水车、推土机、刮平机、振动碾、小型机具、铁锹等手使工具及小线、盒尺等。</p><p><strong>三、操作内容</strong></p><p>\t1、测量人员按设计高程将控制高程测设在路中及两侧隔离带的木桩上，给出油面高程，下返路床面高。</p><p>\t2、道路红线范围内地表以下30cm内的表层草皮、腐殖土、树根、生活垃圾等彻底清除。当路基填土高度小于路面和路床总厚度时，应将地基表层土进行超挖80cm并分层回填压实，压实度不得小于“零填及挖方路基”的规定值。</p><p>\t3、特殊填方、挖方路基时应符合下列要求：</p><p>\t1）填方、挖方路基进行分段处理。填方路段粘质粉土～粉质粘土填土层换填厚度为路床顶面以下1.5m；当土层厚度小于1.5m时，进行全部挖出换填。</p><p>\t2) 行车道、步道分别处理。此车行道路床顶面以下换填80cm厚级配砂砾，步道路床顶面以下换填20厚级配砂砾。</p><p>4、路床顶面土基回弹模量值应大于30Mpa，如不满足要求，采用级配砂砾进行处理，每层厚度20cm，具体处理厚度根据现场实际情况确定。</p><p>\t5、路床施工期间，应保持排水系统畅通，防止路床浸水，并在路床两侧修土埂，一是有利于排水，二是以便控制无机料的宽度，三是保持路床美观、平整。</p><p>\t6、路床施工时人工配合推土机进行施工，施工时机械找大面，人工进行检查井周围及路床两边的找补施工，并在推土机施工过后，用小线进行坡度及高程的量测，再进行路床碾压。</p><p>\t7、路床填挖工程接近完成时，应恢复到路中线、路床边缘线，检查纵断面与横断面高程，复核施工衔接段中线高程。</p><p>\t8、路床碾压由振动碾先进行静压一遍找平，量测，完成后进行带振碾压。碾压遍数经试验段实际测量，其压实度达到重型击实94%为止。</p><p><strong>四、质量要求</strong></p><p><br></p><p><strong>五、安全文明施工</strong></p><p>\t1、注意施工器具、材料等码放整齐，保持施工现场整齐有序。</p><p>\t2、施工中人员按要求身穿反光背心，佩戴安全帽。</p><p>\t3、现场外露土方需用绿网进行覆盖，现场洒水以防止扬尘。</p><p>\t4、施工应严格按照安全操作规定进行，保证施工能够安全进行。</p><p class=\"ql-align-justify\">\t5、施工人员现场严禁吸烟。</p>");
        log.setDate(new Date());
        log.setDayNote("string");
        log.setDayWeather("string");
        log.setNightNote("string");

        // 将对象转换成为字符串
        String str = JSON.toJSONString(log);
        // 字符串转map
        JSONObject jsonObject = JSONObject.parseObject(str);
        Map<String, Object> logmap = (Map<String, Object>) jsonObject;
        try {
            XWPFDocument doc = WordExportUtil.exportWord07(
                    "D:\\github\\SpringBT\\hyzx-easypoi\\src\\main\\resources\\日志.docx", logmap);
            FileOutputStream fos = new FileOutputStream("D:\\nginx-1.15.12\\html\\project-file\\simple.docx");
            doc.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 富文本导出Word
     *
     * @author huy
     * @date 11:01 2019/8/16
     */
    @Test
    public void richTextToWord() {
        //create a cell style and assign the first font to it
        try {
            String path = this.getClass().getClassLoader().getResource("projectTechnical.html").toURI().getPath();
            FileReader fileReader = new FileReader(path);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            StringBuffer temp = new StringBuffer(line);
            while (line != null) {
                temp.append(line);
                line = bufferedReader.readLine();
            }

            System.out.println(temp);
            String format = temp.toString();

            format = format.replace("{{7}}", "<p style=\"margin-bottom:10px;line-height:24px\"><strong><span style=\"font-family: 宋体;font-size: 16px\"><span style=\"font-family:宋体\">一、施工准备</span></span></strong></p><p style=\"text-indent:28px;line-height:24px\"><span style=\";font-family:宋体;font-size:14px\"><span style=\"font-family:宋体\">施工前先进行道路的场地平整，路基控制高程的测设，并经复核。</span></span></p><p style=\"margin-top:10px;margin-bottom:10px;line-height:24px\"><strong><span style=\"font-family: 宋体;font-size: 16px\"><span style=\"font-family:宋体\">二、材料、机械准备</span></span></strong></p><p style=\"text-indent:28px;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">1、材料：级配砂砾、粗粒土等。</span></p><p style=\"text-indent:28px;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">2、机械：洒水车、推土机、刮平机、振动碾、小型机具、铁锹等手使工具及小线、盒尺等。</span></p><p style=\"margin-top:10px;margin-bottom:10px;line-height:24px\"><strong><span style=\"font-family: 宋体;font-size: 16px\"><span style=\"font-family:宋体\">三、操作内容</span></span></strong></p><p style=\"text-indent:28px;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">1、测量人员按设计高程将控制高程测设在路中及两侧隔离带的木桩上，给出油面高程，下返路床面高。</span></p><p style=\"text-indent:28px;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">2、道路红线范围内地表以下30cm内的表层草皮、腐殖土、树根、生活垃圾等彻底清除。当路基填土高度小于路面和路床总厚度时，应将地基表层土进行超挖80cm并分层回填压实，压实度不得小于“零填及挖方路基”的规定值。</span></p><p style=\"text-indent:28px;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">3、特殊填方、挖方路基时应符合下列要求：</span></p><p style=\"text-indent:49px;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">1）填方、挖方路基进行分段处理。填方路段粘质粉土～粉质粘土填土层换填厚度为路床顶面以下1.5m；当土层厚度小于1.5m时，进行全部挖出换填。</span></p><p style=\"text-indent:49px;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">2) 行车道、步道分别处理。此车行道路床顶面以下换填80cm厚级配砂砾，步道路床顶面以下换填20厚级配砂砾。</span></p><p><span style=\";font-family:宋体;font-size:14px\">4、路床顶面土基回弹模量值应大于30Mpa，如不满足要求，采用级配砂砾进行处理，每层厚度20cm，具体处理厚度根据现场实际情况确定。</span></p><p style=\"text-indent:28px;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">5、路床施工期间，应保持排水系统畅通，防止路床浸水，并在路床两侧修土埂，一是有利于排水，二是以便控制无机料的宽度，三是保持路床美观、平整。</span></p><p style=\"text-indent:28px;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">6、路床施工时人工配合推土机进行施工，施工时机械找大面，人工进行检查井周围及路床两边的找补施工，并在推土机施工过后，用小线进行坡度及高程的量测，再进行路床碾压。</span></p><p style=\"text-indent:28px;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">7、路床填挖工程接近完成时，应恢复到路中线、路床边缘线，检查纵断面与横断面高程，复核施工衔接段中线高程。</span></p><p style=\"text-indent:28px;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">8、路床碾压由振动碾先进行静压一遍找平，量测，完成后进行带振碾压。碾压遍数经试验段实际测量，其压实度达到重型击实94%为止。</span></p><p style=\"margin-top:10px;margin-bottom:10px;line-height:29px\"><strong><span style=\"font-family: 宋体;font-size: 16px\"><span style=\"font-family:宋体\">四、质量要求</span></span></strong></p><p style=\"margin-bottom:10px;text-indent:161px;text-align:justify;text-justify:inter-ideograph;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\"><span style=\"font-family:宋体\">路基强度及压实度（重型击实标准）：</span></span></p><table cellspacing=\"0\" width=\"594\"><tbody><tr style=\"height:29px\" class=\"firstRow\"><td width=\"179\" valign=\"center\" rowspan=\"2\" style=\"padding: 0px 7px; border-width: 1px; border-color: windowtext;\"><p style=\"text-indent:0;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">项目分类</span></p></td><td width=\"132\" valign=\"center\" rowspan=\"2\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top-width: 1px; border-top-color: windowtext; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-indent:0\"><span style=\";font-family:宋体;font-size:14px\">路床顶面</span></p><p style=\"text-indent:0\"><span style=\";font-family:宋体;font-size:14px\">以下深度（m）</span></p></td><td width=\"170\" valign=\"center\" colspan=\"2\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top-width: 1px; border-top-color: windowtext; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-indent:0;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">压实度（%）</span></p></td><td width=\"113\" valign=\"center\" rowspan=\"2\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top-width: 1px; border-top-color: windowtext; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-indent:0\"><span style=\";font-family:宋体;font-size:14px\">填料最小</span></p><p style=\"text-indent:0\"><span style=\";font-family:宋体;font-size:14px\">强度（CBR）</span></p></td></tr><tr style=\"height:29px\"><td width=\"85\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-indent:0;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">行车道</span></p></td><td width=\"85\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-indent:0;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">人行道</span></p></td></tr><tr style=\"height:30px\"><td width=\"179\" valign=\"center\" rowspan=\"4\" style=\"padding: 0px 7px; border-left-width: 1px; border-left-color: windowtext; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-indent:0;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">填方路基</span></p></td><td width=\"132\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-indent:0;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">0～0.3</span></p></td><td width=\"85\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-indent:0;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">≥94</span></p></td><td width=\"85\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-indent:0;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">≥92</span></p></td><td width=\"113\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-indent:0;line-height:29px\"><span style=\"font-family:宋体;font-size:14px\">5</span></p></td></tr><tr style=\"height:30px\"><td width=\"132\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-indent:0;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">0.3～0.8</span></p></td><td width=\"85\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center\"><span style=\";font-family:宋体;font-size:14px\">≥94</span></p></td><td width=\"85\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center\"><span style=\";font-family:宋体;font-size:14px\">≥92</span></p></td><td width=\"113\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-indent:0;line-height:29px\"><span style=\"font-family:宋体;font-size:14px\">5</span></p></td></tr><tr style=\"height:30px\"><td width=\"132\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-indent:0;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">0.8～1.5</span></p></td><td width=\"85\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center\"><span style=\";font-family:宋体;font-size:14px\">≥92</span></p></td><td width=\"85\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center\"><span style=\";font-family:宋体;font-size:14px\">≥91</span></p></td><td width=\"113\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-indent:0;line-height:29px\"><span style=\"font-family:宋体;font-size:14px\">3</span></p></td></tr><tr style=\"height:30px\"><td width=\"132\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-indent:0;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">＞1.5</span></p></td><td width=\"85\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center\"><span style=\";font-family:宋体;font-size:14px\">≥91</span></p></td><td width=\"85\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center\"><span style=\";font-family:宋体;font-size:14px\">≥90</span></p></td><td width=\"113\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-indent:0;line-height:29px\"><span style=\"font-family:宋体;font-size:14px\">2</span></p></td></tr><tr style=\"height:30px\"><td width=\"179\" valign=\"center\" style=\"padding: 0px 7px; border-left-width: 1px; border-left-color: windowtext; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-indent:0;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">零填及挖方路基</span></p></td><td width=\"132\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-indent:0;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">0～0.3</span></p></td><td width=\"85\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center\"><span style=\";font-family:宋体;font-size:14px\">≥94</span></p></td><td width=\"85\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center\"><span style=\";font-family:宋体;font-size:14px\">≥92</span></p></td><td width=\"113\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-indent:0;line-height:29px\"><span style=\"font-family:宋体;font-size:14px\">5</span></p></td></tr></tbody></table><p style=\"margin-top:10px;margin-bottom:10px;text-align:center;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\"><span style=\"font-family:宋体\">路床允许偏差表：</span></span></p><table cellspacing=\"0\" width=\"594\"><tbody><tr class=\"firstRow\"><td width=\"28\" valign=\"center\" rowspan=\"2\" style=\"padding: 0px 7px; border-width: 1px; border-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">序号</span></p></td><td width=\"70\" valign=\"center\" rowspan=\"2\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top-width: 1px; border-top-color: windowtext; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">项目</span></p></td><td width=\"113\" valign=\"center\" rowspan=\"2\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top-width: 1px; border-top-color: windowtext; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">规定值或</span></p><p style=\"text-align:center;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">允许偏差(mm)</span></p></td><td width=\"137\" valign=\"center\" colspan=\"2\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top-width: 1px; border-top-color: windowtext; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">检查频率</span></p></td><td width=\"245\" valign=\"center\" rowspan=\"2\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top-width: 1px; border-top-color: windowtext; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">检验方法</span></p></td></tr><tr><td width=\"52\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">范围</span></p></td><td width=\"85\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">点数</span></p></td></tr><tr style=\"height:29px\"><td width=\"28\" valign=\"center\" style=\"padding: 0px 7px; border-left-width: 1px; border-left-color: windowtext; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\"font-family:宋体;font-size:14px\">1</span></p></td><td width=\"70\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">中线偏位</span></p></td><td width=\"113\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">≤30</span></p></td><td width=\"52\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">100m</span></p></td><td width=\"85\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\"font-family:宋体;font-size:14px\">2</span></p></td><td width=\"245\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">用经纬仪、钢尺量取最大值</span></p></td></tr><tr style=\"height:29px\"><td width=\"28\" valign=\"center\" style=\"padding: 0px 7px; border-left-width: 1px; border-left-color: windowtext; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\"font-family:宋体;font-size:14px\">2</span></p></td><td width=\"70\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">纵断高程</span></p></td><td width=\"113\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">-20～+10</span></p></td><td width=\"52\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">20m</span></p></td><td width=\"85\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\"font-family:宋体;font-size:14px\">1</span></p></td><td width=\"245\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">用水准仪测量</span></p></td></tr><tr style=\"height:29px\"><td width=\"28\" valign=\"center\" style=\"padding: 0px 7px; border-left-width: 1px; border-left-color: windowtext; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\"font-family:宋体;font-size:14px\">3</span></p></td><td width=\"70\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">平整度</span></p></td><td width=\"113\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">≤10</span></p></td><td width=\"52\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">20m</span></p></td><td width=\"85\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">每车道1处</span></p></td><td width=\"245\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">用3m直尺和塞尺连续量两尺取较大值</span></p></td></tr><tr style=\"height:29px\"><td width=\"28\" valign=\"center\" style=\"padding: 0px 7px; border-left-width: 1px; border-left-color: windowtext; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\"font-family:宋体;font-size:14px\">4</span></p></td><td width=\"70\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">宽度</span></p></td><td width=\"113\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">不小于设计值+B</span></p></td><td width=\"52\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">40m</span></p></td><td width=\"85\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\"font-family:宋体;font-size:14px\">1</span></p></td><td width=\"245\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">用钢尺量</span></p></td></tr><tr style=\"height:29px\"><td width=\"28\" valign=\"center\" style=\"padding: 0px 7px; border-left-width: 1px; border-left-color: windowtext; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\"font-family:宋体;font-size:14px\">5</span></p></td><td width=\"70\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">横坡</span></p></td><td width=\"113\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">±0.3%且不反坡</span></p></td><td width=\"52\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">100m</span></p></td><td width=\"85\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">4个断面</span></p></td><td width=\"245\" valign=\"center\" style=\"padding: 0px 7px; border-left: none; border-right-width: 1px; border-right-color: windowtext; border-top: none; border-bottom-width: 1px; border-bottom-color: windowtext;\"><p style=\"text-align:center;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">用水准仪测量</span></p></td></tr></tbody></table><p style=\"margin-top:10px;margin-bottom:10px;line-height:29px\"><strong><span style=\"font-family: 宋体;font-size: 16px\"><span style=\"font-family:宋体\">五、安全文明施工</span></span></strong></p><p style=\"text-indent:28px;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">1、注意施工器具、材料等码放整齐，保持施工现场整齐有序。</span></p><p style=\"text-indent:28px;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">2、施工中人员按要求身穿反光背心，佩戴安全帽。</span></p><p style=\"text-indent:28px;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">3、现场外露土方需用绿网进行覆盖，现场洒水以防止扬尘。</span></p><p style=\"text-indent:28px;line-height:29px\"><span style=\";font-family:宋体;font-size:14px\">4、施工应严格按照安全操作规定进行，保证施工能够安全进行。</span></p><p><span style=\";font-family:宋体;font-size:14px\">&nbsp;&nbsp;5、施工人员现场严禁吸烟。</span></p><p><br/></p>");


            htmlTWord(format);
            bufferedReader.close();
            fileReader.close();
        } catch (URISyntaxException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void htmlTWord(String html) {
        POIFSFileSystem poifs = null;
        FileOutputStream ostream = null;
        ByteArrayInputStream bais = null;
        String uuid = "D:\\github\\SpringBT\\hyzx-easypoi\\target\\测试.doc";
        File file = null;

        try {

            byte[] b= html.getBytes(StandardCharsets.UTF_8);  //这里是必须要设置编码的，不然导出中文就会乱码。

            bais = new ByteArrayInputStream(b);
            poifs = new POIFSFileSystem();
            DirectoryEntry directory = poifs.getRoot();
            //WordDocument名称不允许修改
            directory.createDocument("WordDocument", bais);
            ostream = new FileOutputStream(uuid);
            poifs.writeFilesystem(ostream);//当前目录下就生成了一个测试.docx的文档
        } catch (Exception e) {
            LOGGER.error("exception is {}", e);
        } finally {
            IOUtils.closeQuietly(poifs);
            IOUtils.closeQuietly(ostream);
            IOUtils.closeQuietly(bais);
            try {
                FileUtils.forceDelete(file);
            } catch (Exception e2) {
            }
        }
    }

    @Test
   public void word2pdf() throws IOException {
       String docPath = "C:\\Users\\10283\\Desktop\\测试生成.docx";
       String pdfPath = "C:\\Users\\10283\\Desktop\\测试生成.pdf";

       XWPFDocument document;
       InputStream doc = new FileInputStream(docPath);
       document = new XWPFDocument(doc);
       PdfOptions options = PdfOptions.create();
       OutputStream out = new FileOutputStream(pdfPath);
       PdfConverter.getInstance().convert(document, out, options);

       doc.close();
       out.close();
   }

    /*** doc 格式 */
    private static final int DOC_FMT = 0;

    /*** docx 格式 */
    private static final int DOCX_FMT = 12;
    /**
     * 根据格式类型转换 word 文件
     * jacob包  依赖 .dll文件
     * @param srcPath    源文件
     * @param descPath    目标文件
     * @param fmt        所转格式
     */
    public File convertDocFmt(String srcPath, String descPath, int fmt) throws Exception {
        // 实例化ComThread线程与ActiveXComponent
        ComThread.InitSTA();
        ActiveXComponent app = new ActiveXComponent("Word.Application");
        try {
            // 文档隐藏时进行应用操作
            app.setProperty("Visible", new Variant(false));
            // 实例化模板Document对象
            Dispatch document = app.getProperty("Documents").toDispatch();
            // 打开Document进行另存为操作
            Dispatch doc = Dispatch.invoke(document, "Open", Dispatch.Method, new Object[] { srcPath, new Variant(true), new Variant(true) }, new int[1]).toDispatch();
            Dispatch.invoke(doc, "SaveAs", Dispatch.Method, new Object[] { descPath, new Variant(fmt) }, new int[1]);
            Dispatch.call(doc, "Close", new Variant(false));
            return new File(descPath);
        } catch (Exception e) {
            throw e;
        } finally {
            // 释放线程与ActiveXComponent
            app.invoke("Quit", new Variant[] {});
            ComThread.Release();
        }
    }


    @Test
    public void doc2docx2() {
        String srcDocPath = "C:\\Users\\10283\\Desktop\\balabalabalabalabala.doc";
        String descDocPath = "C:\\Users\\10283\\Desktop\\balabalabalabalabala.docx";
        try {
            convertDocFmt(srcDocPath, descDocPath, DOCX_FMT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
