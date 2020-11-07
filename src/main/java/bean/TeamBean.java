/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Team;
import facade.TeamFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author kutlu
 */
@Named
@ViewScoped
public class TeamBean implements Serializable {

    @EJB
    private TeamFacadeLocal dao;
    private Team team;
    private List<Team> teamList;



    public Team getTeam() {
        if (this.team == null) {
            this.team = new Team();
        }
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    /* public List<Team> getTeamList() {
        if (this.teamList == null) {
            this.teamList = dao.findAll();
        }
        return teamList;
    }*/
    public List<Team> getTeamList() {

        this.teamList = dao.findAll();

        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    public void updateForm(Team tm) {
        this.team = tm;
    }

    public void create() {
        dao.create(this.team);
        this.team = new Team();
    }

    public void update() {
        dao.edit(this.team);
        this.team = new Team();

    }

    public String delete(Team tm) {
        dao.remove(tm);
        this.clearForm();
        return "/admin/team/team?faces-redirect=true ";

    }

    public int record() {
        return dao.count();
    }

    public void clearForm() {
        this.team = new Team();
    }



    ///////////////////////////////////////////
    /*public void deleteConfirm(Team tm){
        this.team = tm ;
    }*/
}
