package br.com.apcoders.desafio.domain.entity;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "units")
public class Unity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "owner", nullable = false)
    private String owner;

    @Column(name = "condominium", nullable = false)
    private String condominium;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "id_tenant", nullable = false)
    private Long idTenant;

    public Unity() {}

    private Unity(Long id, String owner, String condominium, String address, Long idTenant) {
        this.id = id;
        this.owner = owner;
        this.condominium = condominium;
        this.address = address;
        this.idTenant = idTenant;
    }

    public Long getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public String getCondominium() {
        return condominium;
    }

    public String getAddress() {
        return address;
    }

    public Long getIdTenant() {
        return idTenant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unity unity = (Unity) o;
        return (
            Objects.equals(id, unity.id) &&
            Objects.equals(owner, unity.owner) &&
            Objects.equals(condominium, unity.condominium) &&
            Objects.equals(address, unity.address) &&
            Objects.equals(idTenant, unity.idTenant)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, owner, condominium, address, idTenant);
    }

    @Override
    public String toString() {
        return (
            "Unity{" +
            "id=" +
            id +
            ", owner='" +
            owner +
            '\'' +
            ", condominium='" +
            condominium +
            '\'' +
            ", address='" +
            address +
            '\'' +
            ", idTenant=" +
            idTenant +
            '}'
        );
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private String owner;
        private String condominium;
        private String address;
        private Long idTenant;

        private Builder() {}

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder owner(String owner) {
            this.owner = owner;
            return this;
        }

        public Builder condominium(String condominium) {
            this.condominium = condominium;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder idTenant(Long idTenant) {
            this.idTenant = idTenant;
            return this;
        }

        public Unity build() {
            return new Unity(id, owner, condominium, address, idTenant);
        }
    }
}
