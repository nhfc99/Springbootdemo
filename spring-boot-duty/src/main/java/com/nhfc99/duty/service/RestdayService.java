package com.nhfc99.duty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhfc99.duty.dao.RestdayDOMapper;
import com.nhfc99.duty.model.RestdayDO;

@Service
public class RestdayService {
    @Autowired
    RestdayDOMapper restdayDOMapper;

    public List<RestdayDO> selectAll() {
        return restdayDOMapper.selectAll();
    }

    public RestdayDO haveDate(List<RestdayDO> restdays, String datestr) {
        for (int i = 0; i < restdays.size(); i++) {
            RestdayDO restdayDO = restdays.get(i);
            String restdaystr = restdayDO.getH_date();
            if (restdaystr.equals(datestr)) {
                return restdayDO;
            }
        }
        return null;
    }
}
