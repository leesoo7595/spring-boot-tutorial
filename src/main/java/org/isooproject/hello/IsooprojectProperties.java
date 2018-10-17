package org.isooproject.hello;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;

// 외부에 있는 파일이라 가정할 때(내가 어노테이션을 달지 못하는 상황)
public class IsooprojectProperties {

    private String name;

    private List<MyPojo> pojoList;

    private String workFor;

    private String whereToGo;

    private String fooBar;

    private Duration time1; // 1000ms

    private Duration time2; // 10h

    private Duration time3; // 10s

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

    public String getWorkFor() {
        return workFor;
    }

    public void setWorkFor(String workFor) {
        this.workFor = workFor;
    }

    public String getWhereToGo() {
        return whereToGo;
    }

    public void setWhereToGo(String whereToGo) {
        this.whereToGo = whereToGo;
    }

    public String getFooBar() {
        return fooBar;
    }

    public void setFooBar(String fooBar) {
        this.fooBar = fooBar;
    }

    public Duration getTime1() {
        return time1;
    }

    public void setTime1(Duration time1) {
        this.time1 = time1;
    }

    public Duration getTime2() {
        return time2;
    }

    public void setTime2(Duration time2) {
        this.time2 = time2;
    }

    public Duration getTime3() {
        return time3;
    }

    public void setTime3(Duration time3) {
        this.time3 = time3;
    }
}
