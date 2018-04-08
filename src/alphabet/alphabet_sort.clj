(ns alphabet.alphabet_sort)

(def alphabet
  (set ["d" "f" "e" "j" "a" "i" "b" "g" "h" "c"]))

(defn check-letter [letter]
  (contains? alphabet letter))

(defn in-alphabet? [word]
  (if (= (count word) 0)
    false
    (let [[first & rest] word]
      (if (prn "HERE IS CHECK LETTER" (check-letter first))
        (in-alphabet? rest)))))
