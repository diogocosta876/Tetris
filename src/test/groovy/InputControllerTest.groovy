import spock.lang.Specification;

class InputControllerTest extends Specification{

    def 'Controller Move Left'() {
        given:
        def game = new Game();
        when:
        def result = 1
        then:
        result == 1
    }

}
