package com.foodAPI.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity(name="bill")
public class Bill implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bill_id", unique = true, nullable = false)
	private Long billId;
	
	@Column(name="date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="phone", nullable=false)
	private Client client;
	
	@Column(name="iva", nullable = false)
	private float iva;
	
	@Column(name="adress", nullable = false)
	private String adress;
	
	@Column(name="state_pay", nullable = false)
	private String statePay;
	
	@Column(name="method_pay", nullable = false)
	private String methodPay;
	
	//from this state exists 2 types if it is pending true or false
	@Column(name="state", nullable = false)
	private boolean state;
	
	@OneToMany(mappedBy = "bill")
	private List<BillDetail> billDetails = new ArrayList<BillDetail>();

	public Bill() {
		super();
	}
	
	public Bill(Long billId, Date date, Client client, float iva, String adress, String statePay, String methodPay,
			boolean state, List<BillDetail> billDetails) {
		super();
		this.billId = billId;
		this.date = date;
		this.client = client;
		this.iva = iva;
		this.adress = adress;
		this.statePay = statePay;
		this.methodPay = methodPay;
		this.state = state;
		this.billDetails = billDetails;
	}
	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public float getIva() {
		return iva;
	}

	public void setIva(float iva) {
		this.iva = iva;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}


	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public List<BillDetail> getBillDetails() {
		return billDetails;
	}

	public void setBillDetails(List<BillDetail> billDetails) {
		this.billDetails = billDetails;
	}

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public String getStatePay() {
		return statePay;
	}

	public void setStatePay(String statePay) {
		this.statePay = statePay;
	}

	public String getMethodPay() {
		return methodPay;
	}

	public void setMethodPay(String methodPay) {
		this.methodPay = methodPay;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + ((billDetails == null) ? 0 : billDetails.hashCode());
		result = prime * result + ((billId == null) ? 0 : billId.hashCode());
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + Float.floatToIntBits(iva);
		result = prime * result + ((methodPay == null) ? 0 : methodPay.hashCode());
		result = prime * result + (state ? 1231 : 1237);
		result = prime * result + ((statePay == null) ? 0 : statePay.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bill other = (Bill) obj;
		if (adress == null) {
			if (other.adress != null)
				return false;
		} else if (!adress.equals(other.adress))
			return false;
		if (billDetails == null) {
			if (other.billDetails != null)
				return false;
		} else if (!billDetails.equals(other.billDetails))
			return false;
		if (billId == null) {
			if (other.billId != null)
				return false;
		} else if (!billId.equals(other.billId))
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (Float.floatToIntBits(iva) != Float.floatToIntBits(other.iva))
			return false;
		if (methodPay == null) {
			if (other.methodPay != null)
				return false;
		} else if (!methodPay.equals(other.methodPay))
			return false;
		if (state != other.state)
			return false;
		if (statePay == null) {
			if (other.statePay != null)
				return false;
		} else if (!statePay.equals(other.statePay))
			return false;
		return true;
	}
		
		
}
