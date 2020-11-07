/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadeImpl;

import entity.ModulePrivileges;
import javax.ejb.Stateless;
import facade.ModulePrivilegesFacadeLocal;

/**
 *
 * @author kutlu
 */
@Stateless
public class ModulePrivilegesFacadeImpl extends BaseFacade<ModulePrivileges> implements ModulePrivilegesFacadeLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public ModulePrivilegesFacadeImpl() {
        super(ModulePrivileges.class);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
