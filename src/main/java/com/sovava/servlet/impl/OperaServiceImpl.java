package com.sovava.servlet.impl;

import com.sovava.mapper.OperaMapper;
import com.sovava.pojo.Opera;
import com.sovava.pojo.PageBean;
import com.sovava.servlet.OperaService;
import com.sovava.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Description: TODO
 *
 * @author: ykn
 * @date: 2022年07月29日 17:06
 **/
public class OperaServiceImpl implements OperaService {
    //1. 创建SQLSessionFactory工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Opera> selectAll() {

        //2. h获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取OperaMapper
        OperaMapper operaMapper = sqlSession.getMapper(OperaMapper.class);

        List<Opera> operas = operaMapper.selectAll();
        //释放资源
        sqlSession.close();
        return operas;

    }


    @Override
    public void add(Opera opera) {
        SqlSession sqlSession = factory.openSession();
        OperaMapper operaMapper = sqlSession.getMapper(OperaMapper.class);
        operaMapper.add(opera);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteByIds(int[] ids) {
        SqlSession sqlSession = factory.openSession();
        OperaMapper operaMapper = sqlSession.getMapper(OperaMapper.class);
        operaMapper.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public PageBean<Opera> selectByPageAndCondition(int currentPage, int pageSize, Opera opera) {
        SqlSession sqlSession = factory.openSession();

        OperaMapper operaMapper = sqlSession.getMapper(OperaMapper.class);

        //处理数据
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;

        if (opera.getOperaName() != null)
            opera.setOperaName(likeHandle(opera.getOperaName()));
        if (opera.getRoles() != null)
            opera.setRoles(likeHandle(opera.getRoles()));
        if (opera.getActor() != null)
            opera.setActor(likeHandle(opera.getActor()));
        if (opera.getGenreName() != null)
            opera.setGenreName(likeHandle(opera.getGenreName()));
        if (opera.getDescription() != null)
            opera.setDescription(likeHandle(opera.getDescription()));


        System.out.println(opera.toString());
        List<Opera> rows = operaMapper.selectByPageAndCondition(begin, size, opera);

        int totalCount = operaMapper.selectTotalCountByCondition(opera);
        PageBean<Opera> operaPageBean = new PageBean<>();
        operaPageBean.setRows(rows);
        operaPageBean.setTotalCount(totalCount);

        sqlSession.close();

        return operaPageBean;
    }


    /**
     * 用于条件查询时模糊处理
     *
     * @param s
     * @return
     */
    private String likeHandle(String s) {
        String _s = null;
        if (s != null && s.length() > 0) {
            _s = "%" + s + "%";
            return _s;
        } else {
            return "";
        }

    }
}
