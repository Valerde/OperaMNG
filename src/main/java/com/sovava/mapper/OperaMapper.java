package com.sovava.mapper;

import com.sovava.pojo.Opera;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OperaMapper {


    /**
     * 查询所有
     *
     * @return
     */
    @Select("select * from tb_opera;")
    @ResultMap("operaResultMap")
    List<Opera> selectAll();

    /**
     * 新增剧目
     *
     * @param opera
     */
    @Insert("insert into tb_opera values (null,#{operaName},#{roles},#{genreName},#{type},#{actor},#{localPath},#{biliPath},#{description})")
    void add(Opera opera);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);

    /**
     * 分页条件查询
     * @param begin
     * @param size
     * @param opera
     * @return
     */
    List<Opera> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("opera") Opera opera);

    /**
     * 查询符合条件的总数量
     * @param opera
     * @return
     */
    int selectTotalCountByCondition(Opera opera);
}
