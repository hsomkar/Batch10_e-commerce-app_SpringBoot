package com.te.ecommersboot.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@Table(name = "item")
@Entity
@XmlRootElement(name = "item-info")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonRootName("item_info")
public class ItemBean implements Serializable {
	@Id
	@Column
	private Integer id;
	@Column
	private String name;
	@Column
	private Integer qty;
	@Column
	private Double price;
}
