package org.learn.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * (Emp)实体类
 *
 * @author 小缪
 * @since 2021-09-08 15:19:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Emp implements Serializable {
    private static final long serialVersionUID = -54732599093622670L;
    private Long id;
    private String name;
    private Boolean sex;
    private String address;
    private String tel;
//    @JsonIgnore
    private String card;
}

