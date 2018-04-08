(ns alphabet.alphabet_sort)

(def alphabet
  (set ["d" "f" "e" "j" "a" "i" "b" "g" "h" "c"]))

(defn check-letter [letter]
  (contains? alphabet letter))

(defn in-alphabet? [word]
  (let [[first & rest] word]
    (prn "HERE IS FIRST" first)
    (prn "HERE IS REST" rest)
    (if (= (count rest) 0)
      (do
        (if (= (check-letter first) false)
          false))
      (do
        (if (= (check-letter first) true)
          (in-alphabet? rest)
          true)))))
