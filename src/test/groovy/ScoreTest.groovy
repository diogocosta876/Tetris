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
        score.getScore() == 300
        when:
        linesCompleted = 4
        score.addToScore(linesCompleted)
        then:
        score.getScore() == 300+1200
        when:
        linesCompleted = 1
        score.addToScore(linesCompleted)
        then:
        score.getScore() == 300+1200+40
        when:
        linesCompleted = 2
        score.addToScore(linesCompleted)
        then:
        score.getScore() == 300+1200+40+100
    }
}
