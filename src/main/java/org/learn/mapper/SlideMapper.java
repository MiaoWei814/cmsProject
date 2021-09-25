package org.learn.mapper;

import org.learn.domain.Slide;
import org.learn.domain.dto.SlideDto;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 幻灯片映射器
 *
 * @author MiaoDaWei
 * @date 2021/09/22
 */
@Repository
public interface SlideMapper {
    /**
     * 找到所有
     *
     * @param dto dto
     * @return {@link List}<{@link Slide}>
     */
    List<Slide> findAll(SlideDto dto);

    /**
     * 插入
     *
     * @param slide 幻灯片
     * @return {@link Integer}
     */
    Integer insert(Slide slide);

    /**
     * 查询通过id
     *
     * @param id id
     * @return {@link Slide}
     */
    Slide queryById(Long id);

    /**
     * 更新
     *
     * @param slide 幻灯片
     * @return {@link Integer}
     */
    Integer update(Slide slide);

    /**
     * 删除通过id
     *
     * @param id id
     * @return {@link Integer}
     */
    Integer deleteById(Long id);

    /**
     * 查询轮播图
     *
     * @return {@link List}<{@link Slide}>
     */
    List<Slide> selectCarousel();
}
