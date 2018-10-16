package org.isooproject.hello;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

// 외부에 있는 파일이라 가정할 때(내가 어노테이션을 달지 못하는 상황)
public class IsooprojectProperties {

    private String name;

    private List<MyPojo> pojoList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MyPojo> getPojoList() {
        return pojoList;
    }

    public void setPojoList(List<MyPojo> pojoList) {
        this.pojoList = pojoList;
    }
}
