(ns iterate.iterate)

(defn sum-numbers [numbers]
  (reduce + numbers))

(defn convert-to-set [numbers]
  (reduce conj #{} numbers))

(defn add-collections [collection1 collection2]
  (reduce conj collection1 collection2))

(defn numbers-under-ten [random-numbers]
  (reduce
    (fn [acc random-numbers]
      (if (= acc < 10)
        (conj acc)
        acc))
    #{}
    random-numbers))
