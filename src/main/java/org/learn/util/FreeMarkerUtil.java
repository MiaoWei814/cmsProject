package org.learn.util;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * @program: frame
 * @description: FreeMark模板生成
 * @author: MiaoWei
 * @create: 2021-09-19 21:32
 **/
public class FreeMarkerUtil {

    /**
     * 生成模板
     *
     * @param templatePath 模板路径
     * @param templateName 模板名称
     * @param object       对象
     * @return {@link String}
     * @throws Exception 异常
     */
    public static String generateTemplate(String templatePath,String templateName,Object object) throws Exception{
        //创建一个Configuration对象,直接new一个对象,构造方法的参数就是freemark对应的版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        //设置模板文件所在的路径【这里是目录】
        File file = new File(templatePath);
        //判断
        templatePathJudge(file);
        configuration.setDirectoryForTemplateLoading(file);
        //设置模板文件使用的字符集,一般就是utf-8
        configuration.setDefaultEncoding("utf-8");
        //加载一个具体的模板,创建一个模板对象
        //判断
        templateFileJudge(templatePath, templateName);
        Template template = configuration.getTemplate(templateName);
        //创建一个Writer对象,一般创建指定文件名称路径
        String fileUrlPath = System.currentTimeMillis() + ".html";
//        FileWriter writer = new FileWriter(new File(file, fileUrlPath));
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(new File(file, fileUrlPath)), StandardCharsets.UTF_8);
        //调用模板对象的process方法输出文件
        template.process(object, writer);
        //关闭流
        writer.close();
        return "/static/templates/" + fileUrlPath;
    }
    /**
     * 模板存放文件判断
     *
     * @param file 文件
     */
    private static void templatePathJudge(File file) {
        if (!file.exists()) {
            throw new RuntimeException("模板存放路径不存在!请检查后再试!");
        }
        if (!file.isDirectory()) {
            throw new RuntimeException("该模板存在路径只能是文件夹!");
        }
    }

    /**
     *
     * 获取具体的模板判断
     *
     * @param templatePath 模板路径
     * @param templateName 模板名称
     */
    private static void templateFileJudge(String templatePath,String templateName) {
        File file = new File(templatePath, templateName);
        if (!file.exists()) {
            throw new RuntimeException("该模板不存在!请检查后再试!");
        }
        if (file.isDirectory()) {
            throw new RuntimeException("该模板只能是文件的形式!");
        }
    }
}
