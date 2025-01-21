package com.flashcard.Study.entity;

public class Progress {

    private Long id;
    private Usuario user;
    private int totalPoints;
    private int acertos;
    private int erros;

    public Progress() {}

    public Progress(Long id, Usuario user, int totalPoints, int acertos, int erros) {
        this.id = id;
        this.user = user;
        this.totalPoints = totalPoints;
        this.acertos = acertos;
        this.erros = erros;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getAcertos() {
        return acertos;
    }

    public void setAcertos(int acertos) {
        this.acertos = acertos;
    }

    public int getErros() {
        return erros;
    }

    public void setErros(int erros) {
        this.erros = erros;
    }
}
