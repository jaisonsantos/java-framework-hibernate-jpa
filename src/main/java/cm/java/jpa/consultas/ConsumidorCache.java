package cm.java.jpa.consultas;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "t_consumidor_cache")
@Cacheable(true)
public class ConsumidorCache {

    // ======================================
    // =             Atributos              =
    // ======================================
    @Id
    @GeneratedValue
    private Long id;
    private String primeiroNome;
    private String ultimoNome;
    private String email;

    // ======================================
    // =            Construtores            =
    // ======================================

    public ConsumidorCache() {
    }

    public ConsumidorCache(String primeiroNomeParam, String ultimoNomeParam, String emailParam) {
        this.primeiroNome = primeiroNomeParam;
        this.ultimoNome = ultimoNomeParam;
        this.email = emailParam;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Long getId() {
        return id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}