(ns alphabet.alphabet_sort)

(def alphabet
  (set [:d :f :e :j :a :i :b :g :h :c]))

(defn check-letter [letter]
  (contains? alphabet letter))

(defn translate [word]
  (if (nil? word)
    #{}
    (into #{} (map keyword word))))

(defn in-alphabet? [word]
  false)



