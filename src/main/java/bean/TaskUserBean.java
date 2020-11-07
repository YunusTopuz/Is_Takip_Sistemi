package bean;

import entity.ModuleUser;
import entity.Task;
import entity.TaskUser;
import facade.TaskUserFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class TaskUserBean implements Serializable {

    @EJB
    private TaskUserFacadeLocal dao;
    private TaskUser taskUser;
    private List<TaskUser> taskUserList;

    public TaskUser getTaskUser() {
        if (this.taskUser == null) {
            this.taskUser = new TaskUser();
        }
        return taskUser;
    }

    public void setTaskUser(TaskUser taskUser) {
        this.taskUser = taskUser;
    }
    
    //şuan boşta bunu sil
    public void getData(Task a){
    this.taskUser.setTask(a);
    this.taskUser.setUser((ModuleUser) a.getModuleUsers());
    
    }

    public List<TaskUser> getTaskUserList() {
        if (this.taskUserList == null) {
            this.taskUserList = dao.findAll();
        }
        return this.taskUserList;
    }

    public void setTaskUserList(List<TaskUser> taskUserList) {
        this.taskUserList = taskUserList;
    }

    public void updateForm(TaskUser tm) {
        this.taskUser = tm;
    }
    
   
    public void create() {
        dao.create(this.taskUser);
        this.taskUser = new TaskUser();
    }

    public void update() {
        dao.edit(this.taskUser);
        this.taskUser = new TaskUser();
    }

    public String delete(TaskUser tm) {
        dao.remove(tm);
        this.clearForm();
        return "/admin/taskuser/list?faces-redirect=true ";

    }

    public int record() {
        return dao.count();
    }

    public void clearForm() {
        this.taskUser = new TaskUser();
    }

}
