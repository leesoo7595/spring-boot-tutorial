package org.isooproject.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.Duration;
import java.util.List;

// 외부에 있는 파일이라 가정할 때(내가 어노테이션을 달지 못하는 상황)
public class IsooprojectProperties {

    @NotEmpty
    private String name;

    // @Value는 오직 순수한 값의 이름으로만 써야 바인딩이 된다.
    // @ConfigureProperties 는 Relaxed binding, Meta-data support 다 됨
    private List<MyPojo> pojoList;

    private String workFor;

    private String whereToGo;

    private String fooBar;

    private Duration time1; // 1000ms

    private Duration time2; // 10h

    private Duration time3; // 10s

    @Min(0)
    @Max(100)
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

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
