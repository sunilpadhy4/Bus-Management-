package com.buscrud.entity;

//import java.sql.Time;

//import com.busmanagement.entity.bus;

import jakarta.persistence.Entity;

//import java.sql.Time;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "BuscrudManagement")
@Entity
public class bus {
	
	@Id
	  private String id;
	    private String name;
	    private String route;
	    private String trip;
	    private String type;
	    private String starttime;
	    private String endtime;

}
