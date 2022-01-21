package br.com.apcoders.desafio.domain.entity;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "tenants")
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "sex", nullable = false)
    private String sex;

    @Column(name = "telephone", nullable = false)
    private String telephone;

    @Column(name = "email", nullable = false)
    private String email;

    public Tenant() {}

    private Tenant(Long id, String name, int age, String sex, String telephone, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.telephone = telephone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tenant tenant = (Tenant) o;
        return (
            age == tenant.age &&
            Objects.equals(id, tenant.id) &&
            Objects.equals(name, tenant.name) &&
            Objects.equals(sex, tenant.sex) &&
            Objects.equals(telephone, tenant.telephone) &&
            Objects.equals(email, tenant.email)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, sex, telephone, email);
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private String name;
        private int age;
        private String sex;
        private String telephone;
        private String email;

        private Builder() {}

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder sex(String sex) {
            this.sex = sex;
            return this;
        }

        public Builder telephone(String telephone) {
            this.telephone = telephone;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Tenant build() {
            return new Tenant(id, name, age, sex, telephone, email);
        }
    }
}
