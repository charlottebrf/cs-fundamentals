(ns alphabet.alphabet_sort)

(def alphabet
  (set ["d" "f" "e" "j" "a" "i" "b" "g" "h" "c"]))

(defn check-letter [letter]
  (contains? alphabet letter))

(defn in-alphabet?
  ([word] (in-alphabet? word false))
  ([word provisional-result]
   (if (= (count word) 0)
     provisional-result
     (let [[first-letter & remaining] word
           provisional-result (check-letter first-letter)]
       (if (= provisional-result false)
         false
         (in-alphabet? remaining provisional-result))))))
