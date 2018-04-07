(ns alphabet.alphabet_test
  (:require [clojure.test :refer :all]
            [alphabet.alphabet_sort :refer :all]))

(deftest alphabet-sort
  (testing "an alphabet contains 10 unique letters"
    (is (= (count alphabet) 10))
    (is (= (type alphabet) clojure.lang.PersistentHashSet))))
