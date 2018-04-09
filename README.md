# data-structures-exercises

A series of katas to learn the fundamentals of Computer Science data structures, whilst also learning Clojure :D 

## Installation

Download the project from:
`git@github.com:charlottebrf/cs-fundamentals.git`

## Usage
Run the Clojure Tests:

`cd data-structures-exercises
lein test`

## Description
**The first kata, fifo,** explores the concept of [queues](https://en.wikipedia.org/wiki/Queue_(abstract_data_type)). It creates and manages the size of its queues via custom methods: to create a new queue, check its size, pop and push functions. 
`fifo-pop` replicates a [first in first out](https://en.wikipedia.org/wiki/FIFO_(computing_and_electronics)) function.
`lifo-pop` replicates a [last in first out](https://techterms.com/definition/filo)  This will be refactored at a later stack to a Stack kata as Queues can only be FIFO. 

**The second kata, alphabet,** further explores data structures.
`alphabet-sort` creates an alphabet which when given a word checks if all the letters of that word are in the alphabet. If any letters are not in the alphabet then it will return false, if all are in the alphabet then true. 

## Further Reading
As well as writing katas, I am also writing a monthly blog post on latest CS fundamentals learnt. These can be found on my blog [here](https://medium.com/@charlottebrf).

## License
Distributed under the Eclipse Public License either version 1.0.
