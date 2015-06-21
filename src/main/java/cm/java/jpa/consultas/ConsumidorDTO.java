package cm.java.jpa.consultas;

/**
 * Contém os atributos e construtores da do pojo ConsumidorDTO
 * @author jaison.santos
 */
public class ConsumidorDTO {

  // ======================================
  // =             Atribuoes              =
  // ======================================

  private String primeiroNome;
  private String ultimoNome;
  private String pais;

  // ======================================
  // =            Construtores            =
  // ======================================

  public ConsumidorDTO() {
  }

  public ConsumidorDTO(String primeiroNomeParam, String ultimoNomeParam, String paisParam) {
    primeiroNome = primeiroNomeParam;
    ultimoNome = ultimoNomeParam;
    pais = paisParam;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

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

  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }
}