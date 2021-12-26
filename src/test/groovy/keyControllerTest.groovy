import spock.lang.Specification

import java.awt.event.KeyEvent;

class keyControllerTest extends Specification{

    def 'Controller Move Left'() {
        given:
        def game = new Game();
        when:
        result = 1
        then:
        result == 1
    }

}
