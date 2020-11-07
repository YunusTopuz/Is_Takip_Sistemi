package facade;

import entity.ModuleUser;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ModuleUserFacadeLocal {

    void create(ModuleUser obj);                                                //olustur

    void edit(ModuleUser obj);                                                  //güncelle

    void remove(ModuleUser obj);                                                //sil

    List<ModuleUser> findAll();                                                 //listele

    ModuleUser find(Object id);                                                 //id ye göre arama

    List<ModuleUser> findRange(int[] range);                                    //sayfalama

    List<ModuleUser> search(int[] range, String field, String term);            //arama

    int searchCount(String field, String term);                                 //arama sonucu bulunan eleman sayısı

    int count();                                                                //kayıt sayısı

    ModuleUser findByField(String field, String value);                         // ???

    ModuleUser login(String mail, String password);

}
