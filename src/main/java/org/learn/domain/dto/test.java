package org.learn.domain.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: frame
 * @description:
 * @author: MiaoWei
 * @create: 2021-09-22 22:52
 **/
@Data
public class test {
    private Integer id;
    private Boolean enable;
    private MultipartFile photo;
}
