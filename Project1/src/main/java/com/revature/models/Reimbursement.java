package com.revature.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Reimbursement {

	private Integer id;
	private BigDecimal amount; 
	private LocalDateTime submitted;
	private LocalDateTime resolved;
	private String description;
	private String receipt;
	private User author;
	private User resolver;
	private ReimbursementStatus reimbStatus;
	private ReimbursementType reimbType;
	
	
	
	
	public Reimbursement(Integer id, BigDecimal amount, LocalDateTime submitted, String description, User author,
			ReimbursementType reimbType) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.description = description;
		this.author = author;
		this.reimbType = reimbType;
	}

	public Reimbursement(BigDecimal amount, LocalDateTime submitted, LocalDateTime resolved, String description,
			String receipt, User author, User resolver, ReimbursementStatus reimbStatus, ReimbursementType reimbType) {
		super();
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
	}

	public Reimbursement(Integer id, BigDecimal amount, LocalDateTime submitted, LocalDateTime resolved,
			String description, String receipt, User author, User resolver, ReimbursementStatus reimbStatus,
			ReimbursementType reimbType) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
	}

	public Reimbursement() {
		super();
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public LocalDateTime getSubmitted() {
		return submitted;
	}
	
	public void setSubmitted(LocalDateTime submitted) {
		this.submitted = submitted;
	}
	
	public LocalDateTime getResolved() {
		return resolved;
	}
	
	public void setResolved(LocalDateTime resolved) {
		this.resolved = resolved;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getReceipt() {
		return receipt;
	}
	
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}
	
	public User getAuthor() {
		return author;
	}
	
	public void setAuthor(User author) {
		this.author = author;
	}
	
	public User getResolver() {
		return resolver;
	}
	
	public void setResolver(User resolver) {
		this.resolver = resolver;
	}
	
	public ReimbursementStatus getReimbStatus() {
		return reimbStatus;
	}
	
	public void setReimbStatus(ReimbursementStatus reimbStatus) {
		this.reimbStatus = reimbStatus;
	}
	
	public ReimbursementType getReimbType() {
		return reimbType;
	}
	
	public void setReimbType(ReimbursementType reimbType) {
		this.reimbType = reimbType;
	}
	
	
	
}
