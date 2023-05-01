package org.in5bv.werner.tuj.models.domain;

import java.sql.Time;

/**
 *
 * @author Werner Obdulio Emmanuel Tuj Chacom
 * @date 30/09/2022
 * @time 07:28:20
 * 
 * Código técnico: IN5BV
 * Grupo: 2/2
 *
 **/
public class Materia {

    private int idMateria;
    private String nombreMateria;
    private int ciclo;
    private Time horarioInicio;
    private Time horarioFinal;
    private String catedratico;
    private String salon;
    private int cupoMaximo;
    private int cupoMinimo;
   

    public Materia(int idMateria, String nombreMateria, int ciclo, Time horarioInicio, Time horarioFinal, String catedratico, String salon, int cupoMaximo, int cupoMinimo) {
        this.idMateria = idMateria;
        this.nombreMateria = nombreMateria;
        this.ciclo = ciclo;
        this.horarioInicio = horarioInicio;
        this.horarioFinal = horarioFinal;
        this.catedratico = catedratico;
        this.salon = salon;
        this.cupoMaximo = cupoMaximo;
        this.cupoMinimo = cupoMinimo;
    }

    public Materia(String nombreMateria, int ciclo, Time horarioInicio, Time horarioFinal, String catedratico, String salon, int cupoMaximo, int cupoMinimo) {
        this.nombreMateria = nombreMateria;
        this.ciclo = ciclo;
        this.horarioInicio = horarioInicio;
        this.horarioFinal = horarioFinal;
        this.catedratico = catedratico;
        this.salon = salon;
        this.cupoMaximo = cupoMaximo;
        this.cupoMinimo = cupoMinimo;
    }
    
    public Materia() {
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public Time getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(Time horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public Time getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(Time horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    public String getCatedratico() {
        return catedratico;
    }

    public void setCatedratico(String catedratico) {
        this.catedratico = catedratico;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public int getCupoMinimo() {
        return cupoMinimo;
    }

    public void setCupoMinimo(int cupoMinimo) {
        this.cupoMinimo = cupoMinimo;
    }

    @Override
    public String toString() {
        return "Materia{" + "idMateria=" + idMateria + ", nombreMateria=" + nombreMateria + ", ciclo=" + ciclo + ", horarioInicio=" + horarioInicio + ", horarioFinal=" + horarioFinal + ", catedratico=" + catedratico + ", salon=" + salon + ", cupoMaximo=" + cupoMaximo + ", cupoMinimo=" + cupoMinimo + '}';
    }
}
