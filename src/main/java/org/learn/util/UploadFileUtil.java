package org.learn.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @program: frame
 * @description: 上传文件
 * @author: MiaoWei
 * @create: 2021-09-23 17:56
 **/
public class UploadFileUtil {

    /**
     * 上传文件
     *
     * @param upFile  向上文件
     * @param request 请求
     * @return {@link String}
     */
    public static String uploadFile(MultipartFile upFile, HttpServletRequest request) throws IOException {
        //文件名称
        String filename = upFile.getOriginalFilename();
        //文件后缀
        String suffix = FileUtil.getSuffix(filename);
        //随机生成文件名
        long seconds = DateUtil.currentSeconds();
        //拼接生成文件名
        String fileSuffix = seconds + "." + suffix;
        //获取文件输入流
        InputStream inputStream = upFile.getInputStream();
        //获取生成的地址
        String realPath = request.getServletContext().getRealPath("/upload");
        //获取输出流
        File file = new File(realPath, fileSuffix);
        FileOutputStream stream = new FileOutputStream(file);
        //复制
        IoUtil.copy(inputStream, stream);
        //关流
        IoUtil.close(stream);
        IoUtil.close(inputStream);
        return "/upload/" + fileSuffix;
    }
}
