package com.example.datavalidationdemo.domain;

import com.example.datavalidationdemo.groups.Groups;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class Book {
    @NotNull(message = "id 不能为空" , groups = Groups.Update.class)
    private Integer id;
    @NotBlank(message = "name 不允许为空")
    @Length(min = 2, max = 10, message = "name长度必须在{min} - {max}之间", groups = Groups.Default.class)
    private String name;
    @NotNull(message = "price不能为空")
    @DecimalMin(value = "0.1", message = "价格不能低于{value}", groups = Groups.Default.class)
    private BigDecimal price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
