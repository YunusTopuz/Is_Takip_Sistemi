/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.ModuleGroup;
import javax.ejb.Local;

/**
 *
 * @author kutlu
 */
@Local
public interface PermissionFacadeLocal {
    
    boolean hasPerm(ModuleGroup mg,String module,String process);
}
