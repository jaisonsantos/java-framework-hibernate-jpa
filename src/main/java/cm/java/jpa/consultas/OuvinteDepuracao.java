package cm.java.jpa.consultas;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class OuvinteDepuracao {

    // ======================================
    // =      Metodos do Ciclo de Vida      =
    // ======================================

    @PrePersist
    void prePersistencia(Object objeto) {
        System.out.println("++ prePersistencia");
    }

    @PostPersist
    void posPersistencia(Object objeto) {
        System.out.println("++ posPersistencia");
    }

    @PreUpdate
    void preAtualizacao(Object objeto) {
        System.out.println("++ preAtualizacao");
    }

    @PostUpdate
    void posAtualizacao(Object objeto) {
        System.out.println("++ posAtualizacao");
    }

    @PreRemove
    void preRemocao(Object objeto) {
        System.out.println("++ preRemocao");
    }

    @PostRemove
    void posRemocao(Object objeto) {
        System.out.println("++ posRemocao");
    }

    @PostLoad
    void posCarregamento(Object objeto) {
        System.out.println("++ posCarregamento");
    }
}