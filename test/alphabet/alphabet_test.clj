(ns alphabet.alphabet_test
  (:require [clojure.test :refer :all]
            [alphabet.alphabet_sort :refer :all]))

;(deftest check-alphabet
;  (testing "an alphabet contains 10 unique letters"
;    (is (= (count alphabet) 10))
;    (is (= (type alphabet) clojure.lang.PersistentHashSet))))

(deftest check-word
  ;(testing "an empty word is not found in the alphabet"
  ;  (is (= (in-alphabet? '()) false)))
  ;(testing "a letter outside the alphabet are not found"
  ;  (is (= (in-alphabet? '("y")) false)))
  ;(testing "multiple letters outside the alphabet are not found"
  ;  (is (= (in-alphabet? '("x" "y" "z")))))
  (testing "a letter in the alphabet is found"
    (is (= (in-alphabet?  '("d")) true))))
  ;(testing "multiple letters from the alphabet are found"
  ;  (is (= (in-alphabet? '("a" "d")) true)))


