package com.example.restaurant.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor // 기본 생성자 생성
@AllArgsConstructor // 모든 객체를 포함하는 생성자 생성
public class Restaurant {

    @Id
    @GeneratedValue //
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String address;

    @Transient // json으로 값을 넘겨주기 위해 만들었었음. 빌드하지 않고 통과되도록 설정.
    private List<MenuItem> menuItems;

    public String getInformation() {
        return name + " in " + address;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
       this.menuItems = new ArrayList<>(menuItems);
    }

    public void updateInformation(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
