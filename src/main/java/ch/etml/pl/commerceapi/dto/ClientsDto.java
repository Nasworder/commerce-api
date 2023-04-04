package ch.etml.pl.commerceapi.dto;

import ch.etml.pl.commerceapi.entity.ClientsEntity;

import java.math.BigDecimal;
public class ClientsDto {
	private Integer num;
	private String prenom;
	private BigDecimal solde;

	public ClientsDto() {
	}


	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public BigDecimal getSolde() {
		return solde;
	}

	public void setSolde(BigDecimal solde) {
		this.solde = solde;
	}
}