package com.nhfc99.duty.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ResultDO implements Serializable {
	@JsonIgnore
    private Integer id;

    private String r_date;

    @JsonIgnore
    private Integer r_dpuid;

    @JsonIgnore
    private Integer r_fid1;

    @JsonIgnore
    private Integer r_fid2;
    
    @JsonIgnore
    private Integer r_dutytype;

    public Integer getR_dutytype() {
		return r_dutytype;
	}

	public void setR_dutytype(Integer r_dutytype) {
		this.r_dutytype = r_dutytype;
	}

	private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getR_date() {
        return r_date;
    }

    public void setR_date(String r_date) {
        this.r_date = r_date;
    }

    public Integer getR_dpuid() {
        return r_dpuid;
    }

    public void setR_dpuid(Integer r_dpuid) {
        this.r_dpuid = r_dpuid;
    }

    public Integer getR_fid1() {
        return r_fid1;
    }

    public void setR_fid1(Integer r_fid1) {
        this.r_fid1 = r_fid1;
    }

    public Integer getR_fid2() {
        return r_fid2;
    }

    public void setR_fid2(Integer r_fid2) {
        this.r_fid2 = r_fid2;
    }
}