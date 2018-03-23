package controllers;

import dao.impl.OppDaoImpl;
import entities.Opportunity;
import play.mvc.Controller;
import play.mvc.Result;
import services.Counter;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * This controller demonstrates how to use dependency injection to
 * bind a component into a controller class. The class contains an
 * action that shows an incrementing count to users. The {@link Counter}
 * object is injected by the Guice dependency injection system.
 */
@Singleton
public class CountController extends Controller {

    private final Counter counter;


    @Inject
    private OppDaoImpl oppDaoImpl;

    @Inject
    public CountController(Counter counter) {
       this.counter = counter;
    }

    /**
     * An action that responds with the {@link Counter}'s current
     * count. The result is plain text. This action is mapped to
     * <code>GET</code> requests with a path of <code>/count</code>
     * requests by an entry in the <code>routes</code> config file.
     */
    public Result count() {
        Opportunity opp = null;
        try {
            opp = oppDaoImpl.getById("V0-ZR6T7F5");

            System.out.println(opp.getId());
            System.out.println(opp.getName());
            return ok("Opp name is :" + opp.getName());
        } catch (Exception e) {
            e.printStackTrace();
            return ok("welcome");
        }
    }
}
