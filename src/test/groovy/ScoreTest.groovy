import ldts.model.Score
import spock.lang.Specification

class ScoreTest extends Specification{
    def 'addToScore and getScore test'(){
        given:
        def score = new Score()
        when:
        int linesCompleted = 3
        score.addToScore(linesCompleted)
        then:
        score.getScore() == 30
    }
}
