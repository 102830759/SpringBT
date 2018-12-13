package com.support.tool.docx;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * @author huyue
 * @email huyue@hdsxtech.com
 * @date 2018/12/13 13:04
 */
public class XmlToExcel {
    private static XmlToExcel tplm = null;
    private Configuration cfg = null;

    private XmlToExcel() {
        cfg = new Configuration();
        try {
            // 注册tmlplate的load路径
            // cfg.setClassForTemplateLoading(this.getClass(), "/template/");
            cfg.setDirectoryForTemplateLoading(new File("D:\\github\\SpringBT\\tool\\src\\main\\resources\\"));
        } catch (Exception e) {

        }
    }

    private static Template getTemplate(String name) throws IOException {
        if (tplm == null) {
            tplm = new XmlToExcel();
        }
        return tplm.cfg.getTemplate(name);
    }

    /**
     *
     * @param templatefile 模板文件
     * @param param 需要填充的内容
     * @param out 填充完成输出的文件
     * @throws IOException
     * @throws TemplateException
     */
    public static void process(String templatefile, Map param, Writer out) throws IOException, TemplateException {
        // 获取模板
        Template template = XmlToExcel.getTemplate(templatefile);
        template.setOutputEncoding("UTF-8");
        // 合并数据
        template.process(param, out);
        if (out != null) {
            out.close();
        }
    }

}
