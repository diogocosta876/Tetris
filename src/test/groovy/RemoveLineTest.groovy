import ldts.model.RemoveLine
import spock.lang.Specification

class RemoveLineTest extends Specification{
    def 'RemoveLine Test'(){
        given:
        def b = "#000000"
        def initial = [
                ["a","a","a","a"],
                ["b","a","b","b"],
                ["c","d","a","a"]
        ] as String[][]

        def remover = new RemoveLine()

        when:
        def result = remover.removeLine(1,initial)
        
        then:
        result== [
                [b,b,b,b],
                ["a","a","a","a"],
                ["c","d","a","a"]
        ] as String[][]
    }

}
