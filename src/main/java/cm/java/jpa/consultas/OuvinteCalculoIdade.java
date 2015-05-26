package cm.java.jpa.consultas;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static java.util.Calendar.DAY_OF_YEAR;
import static java.util.Calendar.YEAR;

public class OuvinteCalculoIdade {

    // ======================================
    // =      Metodos Ciclo de Vida         =
    // ======================================

    @PostLoad
    @PostPersist
    @PostUpdate
    public void calculaIdade(ConsumidorValidadoComOuvinte consumidor) {
        System.out.println("OuvinteCalculoIdade calculaIdade()");
        if (consumidor.getDataNascimento() == null) {
            consumidor.setIdade(null);
            return;
        }

        Calendar nascimento = new GregorianCalendar();
        nascimento.setTime(consumidor.getDataNascimento());
        Calendar hoje = new GregorianCalendar();
        hoje.setTime(new Date());
        int ajuste = 0;
        if (hoje.get(DAY_OF_YEAR) - nascimento.get(DAY_OF_YEAR) < 0) {
            ajuste = -1;
        }
        consumidor.setIdade(hoje.get(YEAR) - nascimento.get(YEAR) + ajuste);
    }
}