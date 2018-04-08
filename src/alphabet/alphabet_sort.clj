(ns alphabet.alphabet_sort)

(def alphabet
  (set [:d :f :e :j :a :i :b :g :h :c]))

(defn check-letter [letter]
  (contains? alphabet letter))

(defn translate [word]
  (into #{} (map keyword word)))

(defn in-alphabet? [word]
  (let [translated-word (translate word)
        first-from-set (first translated-word)
        popped-set (pop (into [] translated-word))
        is-letter-in-alphabet (check-letter first-from-set)]
    (if (true? ((some? popped-set) is-letter-in-alphabet))
      (in-alphabet? popped-set))))

