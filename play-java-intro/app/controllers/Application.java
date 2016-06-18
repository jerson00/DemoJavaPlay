package controllers;

import models.Match;
import play.*;
import play.mvc.*;
import play.db.jpa.*;
import views.html.*;
import models.Person;
import play.data.FormFactory;
import javax.inject.Inject;
import java.util.List;
import java.util.StringJoiner;

import static play.libs.Json.*;

public class Application extends Controller {

    @Inject
    FormFactory formFactory;

    public Result index() {
        return ok(index.render());
    }

    @Transactional
    public Result addPerson() {
        Person person = formFactory.form(Person.class).bindFromRequest().get();
        JPA.em().persist(person);
        return redirect(routes.Application.index());
    }

    @Transactional(readOnly = true)
    public Result getPersons() {
        List<Person> persons = (List<Person>) JPA.em().createQuery("select p from Person p").getResultList();
        return ok(toJson(persons));
    }

    @Transactional
    public Result addMatch() {
        Match match = formFactory.form(Match.class).bindFromRequest().get();
        match.goalsAwayTeam = (int) Math.random() * ( 7 - 0) + 1;
        match.goalsLocalTeam = (int) Math.random() * ( 7 - 0) + 1;
        JPA.em().persist(match);
        return redirect(routes.Application.index());
    }

    @Transactional(readOnly = true)
    public Result getMatches() {
        List<Match> matches = (List<Match>) JPA.em().createQuery("select m from Match m").getResultList();
        return ok(toJson(matches));
    }

    @Transactional
    public Result deleteMatch(String id) {
        Match match = JPA.em().find(Match.class, id);
        JPA.em().remove(match);

        return redirect(routes.Application.index());
    }


}
