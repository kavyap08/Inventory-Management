package com.example.demo.procurement;

import java.time.LocalDateTime;

import com.example.demo.parts.Parts;
import com.example.demo.user.User;

import jakarta.persistence.*;

@Entity
public class Pr{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String prNumber;

    @ManyToOne
    private Parts part;

    @ManyToOne
    private User createdBy;

    private Integer currentStock;

    private Integer threshold;

    private Integer requestedQty;

    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private PRStatus status;

    public enum PRStatus {

        OPEN,
        APPROVED,
        REJECTED,
        PO_CREATED
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPrNumber() {
		return prNumber;
	}

	public void setPrNumber(String prNumber) {
		this.prNumber = prNumber;
	}

	public Parts getPart() {
		return part;
	}

	public void setPart(Parts part) {
		this.part = part;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getCurrentStock() {
		return currentStock;
	}

	public void setCurrentStock(Integer currentStock) {
		this.currentStock = currentStock;
	}

	public Integer getThreshold() {
		return threshold;
	}

	public void setThreshold(Integer threshold) {
		this.threshold = threshold;
	}

	public Integer getRequestedQty() {
		return requestedQty;
	}

	public void setRequestedQty(Integer requestedQty) {
		this.requestedQty = requestedQty;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public PRStatus getStatus() {
		return status;
	}

	public void setStatus(PRStatus status) {
		this.status = status;
	}
    
    // Generate Getters and Setters
}