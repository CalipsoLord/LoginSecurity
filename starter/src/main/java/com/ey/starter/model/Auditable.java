package com.ey.starter.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;



@SuppressWarnings("hiding")
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable<U> {
	
	@CreatedBy
    @Column(name = "CREATED_BY")
    private U createdBy;

    @CreatedDate
    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY")
    private U lastModifiedBy;

    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE")
    private Date lastModifiedDate;

	protected U getCreatedBy() {
		return createdBy;
	}

	protected void setCreatedBy(U createdBy) {
		this.createdBy = createdBy;
	}

	protected Date getCreatedDate() {
		return createdDate;
	}

	protected void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	protected U getLastModifiedBy() {
		return lastModifiedBy;
	}

	protected void setLastModifiedBy(U lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	protected Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	protected void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

    
}
