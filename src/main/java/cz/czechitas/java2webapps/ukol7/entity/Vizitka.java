package cz.czechitas.java2webapps.ukol7.entity;

import org.hibernate.loader.plan.build.internal.returns.ScalarReturnImpl;
import org.hibernate.validator.constraints.Length;
import org.springframework.core.SpringVersion;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * Entita – údaj o jedné osobě
 * Pojmenování properties musí zůstat zachováno -> odpovídá názvům sloupečků v databázové tabulce
 * Jmeno třídy musí zůstat zachováno -> odpovídá jménu tabulky v databázi
 * @Id - jednoznacny identifikator v databazi
 * @Length - maximalni delka retezce
 * @GeneratedValue - rika, jak se id generuji
 *                 - strategy = jakym zpusobem se id generuje
 *                 - GenerationType.IDENTITY = samotna databaze, umi sama prirazovat cisla
 */

@Entity
public class Vizitka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Length(max = 100)
    @NotBlank
    private String celeJmeno;

    @Length(max = 100)
    @NotBlank
    private String firma;

    @Length(max = 100)
    @NotBlank
    private String ulice;

    @Length(max = 100)
    @NotBlank
    private String obec;

    @Length(max = 5)
    @NotBlank
    private String psc;

    @Length(max = 100)
    @Email
    private String email;

    @Length(max = 20)
    @Pattern(regexp = "\\+?\\d+")
    private String telefon;

    @Length(max = 100)
    private String web;


    public String celaAdresa(){
        return ulice + ", " + obec + ", " + psc;
    }


//    bezparametricky konstruktor
    public Vizitka() {
    }

//    konstruktor
    public Vizitka(Integer id, String celeJmeno, String firma, String ulice, String obec, String psc, String email, String telefon, String web) {
        this.id = id;
        this.celeJmeno = celeJmeno;
        this.firma = firma;
        this.ulice = ulice;
        this.obec = obec;
        this.psc = psc;
        this.email = email;
        this.telefon = telefon;
        this.web = web;
    }

//    gettery a settery
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCeleJmeno() {
        return celeJmeno;
    }

    public void setCeleJmeno(String celeJmeno) {
        this.celeJmeno = celeJmeno;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getUlice() {
        return ulice;
    }

    public void setUlice(String ulice) {
        this.ulice = ulice;
    }

    public String getObec() {
        return obec;
    }

    public void setObec(String obec) {
        this.obec = obec;
    }

    public String getPsc() {
        return psc;
    }

    public void setPsc(String psc) {
        this.psc = psc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
}
