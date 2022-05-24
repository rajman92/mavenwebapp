package com.github.rajman92.lang;

import com.github.rajman92.HibernateUtil;

import java.util.List;
import java.util.Optional;

public class LangRepository {
    /**
     * private List<Lang> languages;
     * <p>
     * LangRepository() {
     * languages = new ArrayList<>();
     * languages.add(new Lang(1, "Hello", "en"));
     * languages.add(new Lang(2, "Siemanko", "pl"));
     * }
     **/

    List<Lang> findAll() {
        var session = HibernateUtil.getSessionFactory().openSession();
        var tranaction = session.beginTransaction();

        var result = session.createQuery("from Lang", Lang.class).list();

        tranaction.commit();
        session.close();
        return result;
    }

    public Optional<Lang> findById(Integer id) {
        var session = HibernateUtil.getSessionFactory().openSession();
        var tranaction = session.beginTransaction();

        var result = session.get(Lang.class, id);

        tranaction.commit();
        session.close();
        return Optional.ofNullable(result);

        //return languages.stream()
        //        .filter(l -> l.getId().equals(id))
        //        .findFirst();

    }
}
