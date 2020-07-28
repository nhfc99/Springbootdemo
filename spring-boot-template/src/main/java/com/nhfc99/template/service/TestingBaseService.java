package com.nhfc99.template.service;

import com.nhfc99.template.dao.TestingbaseDomainMapper;
import com.nhfc99.template.domain.TestingbaseDomain;
import com.nhfc99.template.vo.TestingBaseVo;
import com.nhfc99.template.vo.TestingbaseDomainAllVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class TestingBaseService {
    @Autowired
    TestingbaseDomainMapper testingbaseDomainMapper;

    @Transactional
    public Long insert(TestingBaseVo testingBaseVo) {
        //查看是否已经存在某标题，获取parentId
        int parentId = 0;
        TestingbaseDomain testingbaseDomain = testingbaseDomainMapper.selectByTitle(testingBaseVo.getTitle());
        if (testingbaseDomain == null) {
            testingbaseDomain = new TestingbaseDomain();
            testingbaseDomain.setTitle(testingBaseVo.getTitle());
            testingbaseDomainMapper.insertSelective(testingbaseDomain);
            parentId = Math.toIntExact(testingbaseDomain.getId());
        } else {
            parentId = Math.toIntExact(testingbaseDomain.getId());
        }
        //准备子数据
        testingbaseDomain = new TestingbaseDomain();
        testingbaseDomain.setParentid((long) parentId);
        testingbaseDomain.setName(testingBaseVo.getName());
        testingbaseDomain.setExplains(testingBaseVo.getExplains());
        testingbaseDomainMapper.insertSelective(testingbaseDomain);

        return testingbaseDomain.getId();
    }

    @Transactional
    public boolean update(TestingbaseDomain testingbaseDomain) {
        if (testingbaseDomain.getParentid() != 0) {
            TestingbaseDomain parentrecord = new TestingbaseDomain();
            parentrecord.setId(testingbaseDomain.getParentid());
            parentrecord.setTitle(testingbaseDomain.getTitle());
            testingbaseDomainMapper.updateByPrimaryKeySelective(parentrecord);
        }

        if (testingbaseDomain.getId() != 0) {
            TestingbaseDomain record = new TestingbaseDomain();
            record.setId(testingbaseDomain.getId());
            record.setName(testingbaseDomain.getName());
            record.setExplains(testingbaseDomain.getExplains());
            testingbaseDomainMapper.updateByPrimaryKeySelective(record);
        }

        return true;
    }

    public ArrayList<TestingbaseDomainAllVo> selectAll() {
        ArrayList<TestingbaseDomain> testingbaseDomains = testingbaseDomainMapper.selectAll();
        Map<Long, ArrayList<TestingbaseDomain>> stringArrayListMap = new HashMap<>();
        Map<Long, String> titles = new HashMap<>();

        for (TestingbaseDomain testingbaseDomain:
                testingbaseDomains) {
            ArrayList<TestingbaseDomain> testingbaseDomainArrayList = null;
            long parentId = testingbaseDomain.getParentid().longValue();
            if (parentId == 0) {//说明是父节点
                titles.put(testingbaseDomain.getId(), testingbaseDomain.getTitle());//将标题放入

                testingbaseDomainArrayList = new ArrayList<>();
                if (!stringArrayListMap.containsKey(testingbaseDomain.getId())) {//如果不存在的时候
                    stringArrayListMap.put(testingbaseDomain.getId(), testingbaseDomainArrayList);//将子节点放入
                }
            } else {//说明是子节点
                if (stringArrayListMap.containsKey(parentId)) {//看下内部是否已经存储了数据了，如果没有就创建
                    testingbaseDomainArrayList = stringArrayListMap.get(parentId);
                } else {
                    testingbaseDomainArrayList = new ArrayList<>();
                    stringArrayListMap.put(parentId, testingbaseDomainArrayList);//将子节点放入
                }
                String title = titles.get(parentId);
                if (title != null) {
                    testingbaseDomain.setTitle(title);
                }
                testingbaseDomainArrayList.add(testingbaseDomain);
            }
        }

//        for (TestingbaseDomain testingbaseDomain:
//            testingbaseDomains) {
//            ArrayList<TestingbaseDomain> testingbaseDomainArrayList = null;
//            long parentId = testingbaseDomain.getParentid().longValue();
//            if (parentId != 0) {//说明是节点
//                if (stringArrayListMap.containsKey(parentId)) {
//                    testingbaseDomainArrayList = stringArrayListMap.get(parentId);
//                } else {
//                    continue;
//                }
//            } else {
//                continue;
//            }
//            testingbaseDomain.setTitle(titles.get(parentId));
//            testingbaseDomainArrayList.add(testingbaseDomain);
//        }

        ArrayList<TestingbaseDomainAllVo> testingbaseDomainAllVoArrayList = new ArrayList<>();
        ArrayList<Long> keys = new ArrayList<Long>(titles.keySet());
        for (Long key:
            keys) {
            TestingbaseDomainAllVo testingbaseDomainAllVo = new TestingbaseDomainAllVo();
            testingbaseDomainAllVo.setId(key);
            testingbaseDomainAllVo.setTitle(titles.get(key));
            testingbaseDomainAllVo.setDefects(stringArrayListMap.get(key));
            testingbaseDomainAllVoArrayList.add(testingbaseDomainAllVo);
        }
        return testingbaseDomainAllVoArrayList;
    }
}
