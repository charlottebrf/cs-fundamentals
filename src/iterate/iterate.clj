(ns iterate.iterate)

(defn sum-numbers [numbers]
  (reduce + numbers))

(defn convert-to-set [numbers]
  (reduce conj #{} numbers))

;(defn numbers-under-ten [random-numbers]
;  (reduce
;    (fn [acc random-numbers]
;      (if (= random-numbers < 10)
;        conj random-numbers
;        acc) #{}) random-numbers))
