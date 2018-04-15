(ns alphabet.alphabet_sort)

(def alphabet
  (set ["d" "f" "e" "j" "a" "i" "b" "g" "h" "c"]))

(def alphabet-two
  {:a "d" :b "b" :c "c" :d "d" :e "e" :f "f" :g "g" :h "h" :i "i" :j "j"})

(defn word-to-list [word]
  (into (list) (clojure.string/split word #"")))

(defn- check-letter [letter]
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

(defn- check-letter-version-two [letter]
  (let [is-key-present? (get alphabet-two (keyword letter))]
    (some? is-key-present?)))

(defn in-alphabet-version-two?
  ([word] (in-alphabet-version-two? word false))
  ([word current-result]
  (if (= (count word) 0)
    current-result
    (let [[first-letter & remaining] word
          current-result (check-letter-version-two first-letter)]
      (if (= current-result false)
        false
        (in-alphabet-version-two? remaining current-result))))))


(defn in-alphabet-version-three? [word]
  (let [translated-word (word-to-list word)]
    (in-alphabet-version-two? translated-word)))
