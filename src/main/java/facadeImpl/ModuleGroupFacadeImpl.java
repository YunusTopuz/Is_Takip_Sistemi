package facadeImpl;

import entity.ModuleGroup;
import facade.ModuleGroupFacadeLocal;
import javax.ejb.Stateless;

@Stateless
public class ModuleGroupFacadeImpl extends BaseFacade<ModuleGroup> implements ModuleGroupFacadeLocal {

    public ModuleGroupFacadeImpl() {
        super(ModuleGroup.class);
    }  
}
