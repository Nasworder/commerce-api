package ch.etml.pl.commerceapi.entity;

import ch.etml.pl.commerceapi.dto.ClientsDto;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "clients", schema = "commerce", catalog = "")
public class ClientsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "num")
    private int num;
    @Basic
    @Column(name = "prenom")
    private String prenom;
    @Basic
    @Column(name = "solde")
    private BigDecimal solde;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientsEntity that = (ClientsEntity) o;

        if (num != that.num) return false;
        if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;
        if (solde != null ? !solde.equals(that.solde) : that.solde != null) return false;

        return true;
    }
    public ClientsDto toDto() {
        ClientsDto dto = new ClientsDto();
        dto.setNum(num);
        dto.setPrenom(prenom);
        dto.setSolde(solde);
        return dto;
    }

    @Override
    public int hashCode() {
        int result = num;
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (solde != null ? solde.hashCode() : 0);
        return result;
    }

    public boolean isPresent() {
        return false;
    }
}
