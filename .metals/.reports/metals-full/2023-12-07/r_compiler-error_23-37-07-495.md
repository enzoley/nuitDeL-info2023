file://<WORKSPACE>/NaturellementQuiz/src/main/java/fr/nuit/de/l/info/NaturellementQuiz/model/Question.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

action parameters:
uri: file://<WORKSPACE>/NaturellementQuiz/src/main/java/fr/nuit/de/l/info/NaturellementQuiz/model/Question.java
text:
```scala
package fr.nuit.de.l.info.NaturellementQuiz.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Question {

    private String text;
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<Reponse> reponses;

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public List<Reponse> getReponses() {
        List<Reponse> result = new ArrayList<>();
        if(this.reponses.size()>4){
            for (int i = 0; i < 5; i++) {
                int index = (int)(Math.random()*(reponses.size()-1));
                result.add(reponses.get(index));
            }
        }else{
            return reponses;
        }
        return result;
    }
}

```



#### Error stacktrace:

```
scala.collection.Iterator$$anon$19.next(Iterator.scala:973)
	scala.collection.Iterator$$anon$19.next(Iterator.scala:971)
	scala.collection.mutable.MutationTracker$CheckedIterator.next(MutationTracker.scala:76)
	scala.collection.IterableOps.head(Iterable.scala:222)
	scala.collection.IterableOps.head$(Iterable.scala:222)
	scala.collection.AbstractIterable.head(Iterable.scala:933)
	dotty.tools.dotc.interactive.InteractiveDriver.run(InteractiveDriver.scala:168)
	scala.meta.internal.pc.MetalsDriver.run(MetalsDriver.scala:45)
	scala.meta.internal.pc.PcCollector.<init>(PcCollector.scala:42)
	scala.meta.internal.pc.PcSemanticTokensProvider$Collector$.<init>(PcSemanticTokensProvider.scala:60)
	scala.meta.internal.pc.PcSemanticTokensProvider.Collector$lzyINIT1(PcSemanticTokensProvider.scala:60)
	scala.meta.internal.pc.PcSemanticTokensProvider.Collector(PcSemanticTokensProvider.scala:60)
	scala.meta.internal.pc.PcSemanticTokensProvider.provide(PcSemanticTokensProvider.scala:81)
	scala.meta.internal.pc.ScalaPresentationCompiler.semanticTokens$$anonfun$1(ScalaPresentationCompiler.scala:99)
```
#### Short summary: 

java.util.NoSuchElementException: next on empty iterator