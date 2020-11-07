package bean;

import entity.HaveSeen;
import entity.ModuleGroup;
import entity.ModuleUser;
import entity.Task;
import entity.TaskUser;
import entity.Team;
import facade.DayOffFacadeLocal;
import facade.HaveSeenFacadeLocal;
import facade.TaskFacadeLocal;
import facade.TaskUserFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import javax.faces.context.FacesContext;

@Named
@ViewScoped
public class TaskBean implements Serializable {

    @EJB
    private TaskFacadeLocal dao;

    @EJB
    private TaskUserFacadeLocal tuDao;

    @EJB
    private HaveSeenFacadeLocal hsDao;

    @EJB
    private DayOffFacadeLocal dayDao;

    private Task task;
    private List<Task> taskList;

    private List<Task> taskTwoList;

    private TaskUser taskUser;

    public TaskUser getTaskUser() {
        return taskUser;
    }

    public void setTaskUser(TaskUser taskUser) {
        this.taskUser = taskUser;
    }

    public Task getTask() {
        if (this.task == null) {
            this.task = new Task();
        }
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    private Task taskTwo;

    public Task getTaskTwo() {
        if (this.taskTwo == null) {
            this.taskTwo = new Task();
        }
        return taskTwo;
    }

    public void setTaskTwo(Task taskTwo) {
        this.taskTwo = taskTwo;
    }

    public List<Task> getTaskList() {
        ModuleGroup mGroup = (ModuleGroup) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("selected_group");
        ModuleUser mUser = (ModuleUser) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("valid_user");
        if ("admin".equals(mGroup.getGroupName())) {
            this.taskList = dao.findAll();
        } else {
            this.taskList = dao.taskForUser(mUser);////////////////////////////////////////////////
        }
        return taskList;
    }

    public List<Task> getTaskTwoList() {
        ModuleGroup mGroup = (ModuleGroup) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("selected_group");
        ModuleUser mUser = (ModuleUser) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("valid_user");
        if ("admin".equals(mGroup.getGroupName())) {
            this.taskTwoList = dao.findAll();
        } else {
            this.taskTwoList = dao.findByTeam(mUser.getTeams());////////////////////////////////////////////////
        }

        return taskTwoList;
    }

    public void setTaskTwoList(List<Task> taskTwoList) {
        this.taskTwoList = taskTwoList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public void updateForm(Task tm) {
        this.task = tm;
    }

    public void updateFormTwo(Task a) {
        this.taskTwo = a;

        // this.taskUser=tuDao.haveSeenDate(a);
    }

    public void showed(Task ts) {
        ModuleUser mUser = (ModuleUser) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("valid_user");
        TaskUser tu = new TaskUser();
        tu.setTask(ts);
        tu.setUser(mUser);
        tu.getViewedDate();
        if (ts.getModuleUsers().contains(mUser)) {
            if (tuDao.hasRecord(ts, mUser)) {
            } else {
                tuDao.create(tu);
            }
        }
    }

    public void showedForTeam(Task ts) {
        ModuleUser mUser = (ModuleUser) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("valid_user");
        HaveSeen hs = new HaveSeen();
        hs.setTask(ts);
        hs.setUser(mUser);
        hs.getViewedDate();
        if (ts.getTeams().equals(mUser.getTeams())) {
            if (hsDao.hasRecord(ts, mUser)) {
            } else {
                hsDao.create(hs);
            }
        }
    }

    public void create() {
//        java.util.Date uDate = new java.util.Date();
//        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
//        System.out.println("s"+sDate);       
//        if(dayDao.isOffUser((ModuleUser) task.getModuleUsers(),sDate)){
//         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bu Kullanıcı İzinde!"));
//        }else{
        dao.create(task);
        task=new Task();
//       }
        
        /*if (dayDao.isPermUser(this.task.getModuleUsers())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bu Kullanıcı İzinde!"));
        } else {
            dao.create(this.task);
            this.task = new Task();
        }*/
    }

    public void update() {
//        if(dayDao.isPermUser(this.task.getModuleUsers())){
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bu Kullanıcı İzinde Olduğu İçin Görev Verilemiyor!"));
//        }else{
        dao.edit(this.task);
        this.task = new Task();
        //}
    }

    public String delete(Task tm) {
        dao.remove(tm);
        this.clearForm();
        return "/admin/task/task?faces-redirect=true ";
    }

    public int record() {
        return dao.count();
    }

    public void clearForm() {
        this.task = new Task();
    }

}
